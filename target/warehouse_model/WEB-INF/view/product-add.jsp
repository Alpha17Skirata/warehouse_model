<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 17.01.2022
  Time: 14:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<form:form action="saveProduct" modelAttribute="addProduct" >
    Name <form:input path="name"></form:input>
    <form:errors path="name"></form:errors>
    <br>
    <br>
    Volume <form:input path="volume"></form:input>
    <form:errors path="volume"></form:errors>
    <br>
    <br>
    <input type="submit" value="OK">
</form:form>
</body>
</html>
