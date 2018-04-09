package com.yyb.controller;

import com.yyb.bean.User;
import com.yyb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.UUID;

@Controller
public class UserController {

    @Autowired
    UserService service;

    //index jsp中的两个超链接
    //根据路径参数 转向
    @RequestMapping(path = "/user/{op}")
    public String ToRegisterAndLogin(@PathVariable("op") String op) {
        String res = "jsp/index.jsp";

        if ("toRegister".equals(op))
            res = "jsp/register";
        else if ("toLogin".equals(op))
            res = "jsp/login";

        return res;
    }

    //注册 邮箱为主键
    //判断注册邮箱是否重名 重名：重注册 不重名：注册
    //存头像 —— 存信息入数据库 —— forward
    @RequestMapping(path = "register.do", method = RequestMethod.POST)
    public String register(User user, Model model, MultipartFile head, HttpServletRequest request) throws Exception {
        System.out.println("Do Controller register()...");
        System.out.println("registerUser = " + user);

        //主键重名？
        if (service.emailExist(user.getEmail())) {
            model.addAttribute("errorMsg","该邮箱已被注册");
            return "jsp/register";
        }

        if (head == null) {
            model.addAttribute("errorMsg","请上传头像");
            return "jsp/register";
        }

        String headFilename = UUID.randomUUID().toString() + head.getOriginalFilename();

        //头像保存的目标路径
        String realPath = request.getServletContext().getRealPath("/WEB-INF/image/");
        user.setHeadpath(request.getContextPath()+"/WEB-INF/image/" + headFilename);

        //创建文件
        File file= new File(realPath + headFilename);
        if (!file.getParentFile().exists())

            file.getParentFile().mkdirs();

        //存头像
        head.transferTo(file);

        //存入数据库
        service.register(user);

        model.addAttribute("user",user);
        model.addAttribute("msg","注册成功");

        return "jsp/index";
    }

    //登陆
    @RequestMapping(path = "login.do", method = RequestMethod.POST)
    public String login(@RequestParam("email") String email, @RequestParam("password") String password, Model model) throws Exception {

        System.out.println("登录");

        User login = service.login(email, password);

        if (login == null) {
            model.addAttribute("errorMsg","邮箱或密码错误");
            return "jsp/login";
        }

        model.addAttribute("user", login);
        model.addAttribute("msg","登陆成功");
        return "jsp/index";
    }


}
