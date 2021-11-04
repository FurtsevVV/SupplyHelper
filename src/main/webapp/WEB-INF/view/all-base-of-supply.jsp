<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<body>
<h2>Base of Supply</h2>

<br>
<br>
<a href="/">Welcome page</a>
<br>
<br>
<br>
<input type="button" value="Add Base Of Supply" onclick="window.location.href='newbase'"/>
<br>
<br>
<table>
    <tr>
        <th>Name of object: </th>
        <th>Customer:       </th>
        <th>Operations:       </th>
    </tr>
    <c:forEach var="bases" items="${allBaseOfSupply}">
        <c:url var="updateButton" value="/updateBase">
            <c:param name="baseId" value="${bases.id}"/>
        </c:url>
        <c:url var="deleteButton" value="/deleteBase">
            <c:param name="baseId" value="${bases.id}"/>
        </c:url>
        <tr>
            <td>${bases.nameOfObject}</td>
            <td>${bases.customer}</td>
            <td><input type="button" value="Update Base of Supply" onclick="window.location.href='${updateButton}'"> </td>
            <td><input type="button" value="Delete" onclick="window.location.href='${deleteButton}'"> </td>
        </tr>
    </c:forEach>

</table>


<br>



</body>
</html>