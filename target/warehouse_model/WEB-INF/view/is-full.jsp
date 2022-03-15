<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 23.01.2022
  Time: 22:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><%@ page isELIgnored="false" %></head>
<body>
Your summary volume is greater than 100. Volume of your new product must be less.
<br><br>
<c:url var="returnButton" value="/addNewProduct">
</c:url>
<input type="button" value="Return"
       onclick="window.location.href='${returnButton}'">
</body>
</html>
