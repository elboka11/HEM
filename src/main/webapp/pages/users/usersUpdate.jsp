<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Update Users</title>
    <h1>Update Users</h1>
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
    <form action="${pageContext.request.contextPath}/users/update" method="post">
        <tr>
            <td><label>
                <input type="Text" name="firstName" value="${firstName}">
            </label></td>
            <td><label>
                <input type="Text" name="secondName" value="${secondName}">
            </label></td>
            <td><label>
                <input type="Text" name="department" value="${department}">
            </label></td>
            <td><label>
                <input type="Text" name="userName" value="${userName}">
            </label></td>
            <td><label>
                <input type="Text" name="userPassword" value="${userPassword}">
            </label></td>
            <td><label>
                <select name="userRole">
                    <option>ADMIN</option>
                    <option>USER</option>
                </select>
            </label></td>
            <td><input type="submit" value="update"></td>
        </tr>
    </form>
    </tbody>
</table>
</body>
</html>
