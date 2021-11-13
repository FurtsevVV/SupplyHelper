<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<body>
<body bgcolor="#CCCCCC">
<h2>Supply sorting</h2>
<br>

<div>Links</div>
<a href="/allsupply">Show all supplys</a>
<br>
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
    <c:forEach var="supplys" items="${sortedSupply}">
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
</body>
</html>