<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 12.01.2022
  Time: 15:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><%@ page isELIgnored="false" %></head>
<body>
<h2>All tenants</h2>
<br>
<br>
<table>
    <tr>
        <th>Name</th>
        <th>Surname</th>
        <th>Phone number</th>
        <th>Volume</th>
        <th>Place number</th>
        <th>Operation</th>
    </tr>
    <c:forEach var="tenant" items="${allTenants}">

        <c:url var="infoButton" value="/allProductsInfo">
            <c:param name="placeNumber" value="${tenant.placeNumber}"></c:param>
        </c:url>
        <c:url var="deleteButton" value="/deleteTenant">
            <c:param name="placeNumber" value="${tenant.placeNumber}"></c:param>
        </c:url>

     <tr>
         <td>${tenant.name}</td>
         <td>${tenant.surname}</td>
         <td>${tenant.number}</td>
         <td>${tenant.summaryVolume}</td>
         <td>${tenant.placeNumber}</td>
         <td>
             <input type="button" value="Info"
                    onclick="window.location.href='${infoButton}'">
             <input type="button" value="Delete"
                    onclick="window.location.href='${deleteButton}'">
         </td>
     </tr>
    </c:forEach>
    <br>
    <br>
    <input type="button" value="Add"
           onclick="window.location.href='addNewTenant'">
    <br>
    <br>
</table>
</body>
</html>
