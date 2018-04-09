<%--
  Created by IntelliJ IDEA.
  User: 83598
  Date: 2018/4/5
  Time: 21:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>人人网注册页面</title>
    <style type="text/css">
        body{
            margin: 0;
        }
        caption{
            text-align: -webkit-left;
            padding: 10px 10px 10px 100px;
        }
        tr{
            height: 40px;
            text-align:center
        }
        tr>td {
            width: 200px;
            text-align: right;
        }
        td+td{
            width: 500px;
            text-align: left;
        }
        img+a{
            font-size: 8px;
        }
    </style>
</head>
<body onload="init()">

<form action="${pageContext.request.contextPath}/register.do" method="post" enctype="multipart/form-data">
    <table>
        <caption>免费开通人人网账号</caption>
        <br/>${errorMsg}
        <tr >
            <td>注册邮箱：</td>
            <td><input type="email" name="email"></td>
        </tr>
        <tr>
            <td></td>
            <td>你还可以试用<a href="">&nbsp;账号&nbsp;</a>注册或者<a href="">&nbsp;手机号&nbsp;</a>注册</td>
        </tr>
        <tr>
            <td>创建密码：</td>
            <td><input type="password" name="password"></td>
        </tr>
        <tr>
            <td>真实姓名：</td>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <td>头像：</td>
            <td><input type="file" name="head"></td>
        </tr>
        <tr>
            <td>性别：</td>
            <td>
                <input type="radio" name="sex" id="male" value="male" checked>男
                <input type="radio" name="sex" id="female" value="female">女
            </td>
        </tr>
        <tr>
            <td>爱好：</td>
            <td>
                <input type="checkbox" name="hobby" value="study Java"/>Java
                <input type="checkbox" name="hobby" value="study C++"/>C++
                <input type="checkbox" name="hobby" value="study Python"/>Python
            </td>
        </tr>
        <tr>
            <td>生日：</td>
            <td>
                <input type="date" name="birthday">
            </td>
        </tr>
        <tr>
            <td>我现在：</td>
            <td>
                <select id="state">
                    <option selected="selected">正在上学</option>
                    <option>工作</option>
                </select>
            </td>
        </tr>
        <tr>
            <td></td>
            <td>
                <img src="/verycode.gif" alt="验证码"><a href="">看不清换一张？</a>
            </td>
        </tr>
        <tr>
            <td>验证码：</td>
            <td><input type="text" name="code"></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" style="background-image: url('/btn_reg.gif');width:186px;height:40px;border:0"
                       value=""/></td>
        </tr>
    </table>
</form>

</body>
</html>
