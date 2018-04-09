<%--
  Created by IntelliJ IDEA.
  User: 83598
  Date: 2018/4/5
  Time: 21:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页面</title>
</head>
<body>

<form action="${pageContext.request.contextPath}/login.do" method="post">
    <table>
        <tr>
            <td>${errorMsg}</td>
        </tr>
        <tr>
            <td>邮箱</td>
            <td><input type="email" name="email"></td>

        </tr>
        <tr>
            <td>密码</td>
            <td><input type="password" name="password"></td>
        </tr>
        <tr>
            <td><input type="submit" value="登录"></td>
        </tr>
    </table>

</form>
</body>
</html>
