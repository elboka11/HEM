<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Read patients</title>
    <h1>Read patients</h1>
</head>
<body>
<table>
    <thead>
    <tr>
        <th>passportId</th>
        <th>patientFirstName</th>
        <th>patientSecondName</th>
        <th>patientAge</th>
        <th>patientDiagnosis</th>
    </tr>
    </thead>
    <tbody>

    <c:forEach var="patient" items="${patients}">
        <tr>
            <td>${patient.passportId}</td>
            <td>${patient.patientFirstName}</td>
            <td>${patient.patientSecondName}</td>
            <td>${patient.patientAge}</td>
            <td>${patient.patientDiagnosis}</td>
            <td>
                <a href="${pageContext.request.contextPath}/patients/update?patientId=${patient.patientId}">
                    <button type="submit">Update</button>
                </a>
            </td>
            <td>
                <a href="${pageContext.request.contextPath}/patients/delete?patientId=${patient.patientId}">
                    <button type="submit">Delete</button>
                </a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
