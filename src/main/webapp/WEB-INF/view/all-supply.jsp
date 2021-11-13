<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<body>
<body bgcolor="#CCCCCC">
<h2>All Supplys</h2>
<h3><a href="/">Welcome page</a></h3>
<br>
<h2>Sorting</h2>
<form:form method="get" modelAttribute="sortedMethodModel" action="/sortingAllSupply">
<table border="1" width="400">
    <tr>
        <td>Sort by Producer:</td>
        <td><form:input path="sortedProducer" /></td>
        <form:errors path="sortedProducer"/>

    </tr>
    <tr>
        <td>Sort by Base of Supply:</td>
        <td><form:input path="sortedBase" /></td>
        <form:errors path="sortedBase"/>

    </tr>
    <tr>
    <td>Sort by Status:</td> <td> <form:select path="sortedStatus">
        <form:option value="No value" label="No value"/>
        <form:option value="Order approval" label="Order approval"/>
    <form:option value="Make a contract" label="Make a contract"/>
    <form:option value="On the way" label="On the way"/>
    <form:option value="Delivery is done" label="Delivery is done"/>
</form:select>
    </td>
    </tr>
    <tr>
        <td>Sort by Sum, More Than:</td>
        <td><form:input path="sortedSum" /></td>
         </tr>
    <td colspan="3"><input type="submit" value="Submit" /></td>

</table>
</form:form>
<br>
<br>
<h3>Add new Supply</h3>
<input type="button" value="Add Supply" onclick="window.location.href='newsupply'"/>
<br>
<table border="1" width="1600">
    <tr>
        <th>Material: </th>
        <th>Qty:   </th>
        <th>Price:     </th>
        <th>Sum:       </th>
        <th>Producer:       </th>
        <th>Status:       </th>
        <th>Date:       </th>
        <th>Base of Supply:       </th>
        <th>Commentary:       </th>
        <th>Operations:       </th>


    </tr>
    <c:forEach var="supplys" items="${allSupply}">
        <c:url var="updateButton" value="/updateSupply">
            <c:param name="supplyId" value="${supplys.id}"/>
        </c:url>
        <c:url var="deleteButton" value="/deleteSupply">
            <c:param name="supplyId" value="${supplys.id}"/>
        </c:url>
        <tr>
            <td>${supplys.material}</td>
            <td>${supplys.quantity}</td>
            <td>${supplys.price}</td>
            <td>${supplys.sum}</td>
            <td>${supplys.producer.name}</td>
            <td>${supplys.status}</td>
            <td>${supplys.date}</td>
            <td>${supplys.baseOfSupply.nameOfObject}</td>
            <td>${supplys.commentary}</td>>
            <td><input type="button" value="Update Supply" onclick="window.location.href='${updateButton}'"> </td>
            <td><input type="button" value="Delete Supply" onclick="window.location.href='${deleteButton}'"> </td>



        </tr>

    </c:forEach>

</table>


<br>