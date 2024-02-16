<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Create Users</title>
    <h1>Create Users</h1>
</head>
<body>
<table>
    <thead>
    <tr>
        <th>firstName</th>
        <th>secondName</th>
        <th>department</th>
        <th>userName</th>
        <th>Password</th>
        <th>userRole</th>
    </tr>
    </thead>
    <tbody>
    <form action="${pageContext.request.contextPath}/users/create" method="post">
        <tr>
            <td><label>
                <input type="Text" name="firstName" placeholder="Enter your UserName">
            </label></td>
            <td><label>
                <input type="Text" name="secondName" placeholder="Enter your UserName">
            </label></td>
            <td><label>
                <input type="Text" name="department" placeholder="Enter your UserName">
            </label></td>
            <td><label>
                <input type="Text" name="userName" placeholder="Enter your UserName">
            </label></td>
            <td><label>
                <input type="Text" name="userPassword" placeholder="Enter your UserName">
            </label></td>
            <td><label>
                <select name="userRole">
                    <option>ADMIN</option>
                    <option>USER</option>
                </select>
            </label></td>
            <td><input type="submit" value="create"></td>
        </tr>
    </form>
    </tbody>
</table>
</body>
</html>
