<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<body>
<body bgcolor="#CCCCCC">
<h2>Add new base of supply</h2>
<br>

<div>Links</div>
<a href="/allbase">Show all base of supply</a>
<br>
<br>
<form:form action="saveBaseOfSupply" modelAttribute="baseOfSupply">
    <form:hidden path="id"/>
    Name of Object: <form:input path="nameOfObject"/>
    <form:errors path="nameOfObject"/>
    <br>
    Customer: <form:input path="customer"/>
    <form:errors path="customer"/>
    <br>
    <input type="submit" value="Add!">

</form:form>




<br>
</body>
</html>