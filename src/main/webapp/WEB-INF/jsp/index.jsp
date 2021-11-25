<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="clients" scope="request" type="java.util.List"/>
<head>
    <title>WelcomePage</title>
</head>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <table border="1" cellspacing="0" cellpadding="2">
        <tr>
            <td>ID</td>
            <td>First Name</td>
            <td>Last Name</td>
            <td>Phone number</td>
        </tr>
        <c:forEach var="client" items="${clients}">
        <tr>
            <td>${client.id}</td>
            <td>${client.firstName}</td>
            <td>${client.lastName}</td>
            <td>${client.phoneNumber}</td>
        </tr>
        </c:forEach>
    </table>
</body>
</html>