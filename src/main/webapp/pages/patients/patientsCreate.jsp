<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Create Patients</title>
    <h1>Create Patients</h1>
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
    <form action="${pageContext.request.contextPath}/patients/create" method="post">
        <tr>
            <td><label>
                <input type="Text" name="passportId" placeholder="Enter patient's passportId">
            </label></td>
            <td><label>
                <input type="Text" name="patientFirstName" placeholder="Enter patient's FirstName">
            </label></td>
            <td><label>
                <input type="Text" name="patientSecondName" placeholder="Enter patient's SecondName">
            </label></td>
            <td><label>
                <input type="Text" name="patientAge" placeholder="Enter patient's Age">
            </label></td>
            <td><label>
                <input type="Text" name="patientDiagnosis" placeholder="Enter patient's Diagnosis">
            </label></td>
            <td><input type="submit" value="create"></td>
        </tr>
    </form>
    </tbody>
</table>
</body>
</html>
