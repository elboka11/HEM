<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Update Patients</title>
    <h1>Update Patients</h1>
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
    <form action="${pageContext.request.contextPath}/patients/update" method="post">
        <tr>
            <td><label>
                <input type="Text" name="passportId" value="${passportId}">
            </label></td>
            <td><label>
                <input type="Text" name="patientFirstName" value="${patientFirstName}">
            </label></td>
            <td><label>
                <input type="Text" name="patientSecondName" value="${patientSecondName}">
            </label></td>
            <td><label>
                <input type="Text" name="patientAge" value="${patientAge}">
            </label></td>
            <td><label>
                <input type="Text" name="patientDiagnosis" value="${patientDiagnosis}">
            </label></td>
            <td><input type="submit" value="Update"></td>
        </tr>
    </form>
    </tbody>
</table>
</body>
</html>
