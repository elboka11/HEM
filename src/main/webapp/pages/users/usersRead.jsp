<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<html>
<head>
    <title>Read Users</title>
    <h1>Read Users</h1>
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
    <c:forEach var="user" items="${users}">
        <tr>
            <td>${user.firstName}</td>
            <td>${user.secondName}</td>
            <td>${user.department}</td>
            <td>${user.userName}</td>
            <td>${user.userPassword}</td>
            <td>${user.userRole}</td>
            <td>
                <a href="${pageContext.request.contextPath}/users/update?userId=${user.userId}">
                    <button type="submit">Update</button>
                </a>
            </td>
            <td>
                <a href="${pageContext.request.contextPath}/users/delete?userId=${user.userId}">
                    <button type="submit">Delete</button>
                </a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
