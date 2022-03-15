<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 12.01.2022
  Time: 15:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<form:form action="saveTenant" modelAttribute="tenant">
    Name <form:input path="name"></form:input>
    <form:errors path="name"></form:errors>
    <br><br>
    Surname <form:input path="surname"></form:input>
    <form:errors path="surname"></form:errors>
    <br><br>
    Phone number <form:input path="number"></form:input>
    <form:errors path="number"></form:errors>
    <br><br>
    <input type="submit" value="OK">

</form:form>
</body>
</html>
