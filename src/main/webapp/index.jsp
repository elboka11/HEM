<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Login Page</title>
    <h1>Login</h1>
</head>
<body>
<table>
    <thead>
    <tr>
        <th>userName</th>
        <th>Password</th>
    </tr>
    </thead>
    <tbody>
    <form action="/login" method="post">
        <tr>
            <td><input type="Text" name="userName" placeholder="Enter your UserName" required></td>
            <td><input type="Text" name="userPassword" placeholder="Enter your UserPassword" required></td>
            <td><input type="submit" value="Login"></td>
        </tr>
    </form>
    </tbody>
</table>
</body>
</html>
