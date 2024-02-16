<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Admin InterFace</title>
    <h1>Admin workflow</h1>
</head>
<body>
<div class="btn-group">

    <a href="${pageContext.request.contextPath}/users/create">
        <button type="submit">Create new User</button>
    </a>
    <a href="${pageContext.request.contextPath}/users/read">
        <button type="submit">See All Users</button>
    </a>
    <a href="${pageContext.request.contextPath}/patients/create">
        <button type="submit">Create new patient</button>
    </a>
    <a href="${pageContext.request.contextPath}/patients/read">
        <button type="submit">See All Patients</button>
    </a>
</div>
</body>
</html>
