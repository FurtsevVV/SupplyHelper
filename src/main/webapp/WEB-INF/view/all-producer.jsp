<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<body>
<h2>Producers</h2>

<br>
<br>
<a href="/">Welcome page</a>
<br>
<br>
<br>
<br>
<input type="button" value="Add Producer" onclick="window.location.href='newProducer'"/>
<br>
<table>
    <tr>
        <th>Name of producer: </th>
        <th>Contact person:   </th>
        <th>Phone Number:     </th>
        <th>Operations:       </th>
    </tr>
  <c:forEach var="producers" items="${allProducer}">
      <c:url var="updateButton" value="/updateProducer">
          <c:param name="producerId" value="${producers.id}"/>
      </c:url>
      <c:url var="deleteButton" value="/deleteProducer">
          <c:param name="producerId" value="${producers.id}"/>
      </c:url>
        <tr>
            <td>${producers.name}</td>
            <td>${producers.contact}</td>
            <td>${producers.phone}</td>
            <td><input type="button" value="Update Producer" onclick="window.location.href='${updateButton}'"> </td>
            <td><input type="button" value="Delete" onclick="window.location.href='${deleteButton}'"> </td>
        </tr>
    </c:forEach>

</table>


<br>



</body>
</html>