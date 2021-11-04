<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<body>
<h2>All Supplys</h2>

<br>
<br>
<a href="/">Welcome page</a>
<br>
<br>
<br>
<input type="button" value="Add Supply" onclick="window.location.href='newsupply'"/>
<br>
<table>
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



    </tr>
    <c:forEach var="supplys" items="${allSupply}">


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




        </tr>

    </c:forEach>

</table>


<br>