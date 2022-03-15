<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 17.01.2022
  Time: 14:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><%@ page isELIgnored="false" %></head>
<body>
<h2>All products</h2>
<br>
<br>
<table>
    <form:form action="addNewProduct" modelAttribute="productList">
    <tr>
        <th>Name</th>
        <th>Volume</th>
    </tr>
    <c:forEach var="product" items="${productList}">
        <c:url var="deleteButton" value="/deleteProduct">
            <c:param name="id" value="${product.id}"></c:param>
        </c:url>
        <tr>
            <td>${product.name}</td>
            <td>${product.volume}</td>
            <td>
            <input type="button" value="Delete"
                   onclick="window.location.href='${deleteButton}'">
            </td>
        </tr>
    </c:forEach>
    <br>
    <br>
    <input type="submit" value="Add">
    </form:form>
</table>
</body>
</html>
