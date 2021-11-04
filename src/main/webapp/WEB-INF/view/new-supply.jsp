<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<body>
<h2>New supply</h2>
<br>

<div>Links</div>
<a href="/allsupply">Show all supplys</a>
<br>
<br>
<form:form action="saveSupplyWithAttribute" modelAttribute="supply">
    <form:hidden path="id"/>
    Material: <form:input path="material"/>
    <br>
    Quantity: <form:input path="quantity"/>
    <br>
    Price: <form:input path="price"/>
    <br>
    Sum: <form:input path="sum"/>
    <br>
    Status of delivery: <form:select path="status">
    <form:option value="Order approval" label="Order approval"/>
    <form:option value="Make a contract" label="Make a contract"/>
    <form:option value="On the way" label="On the way"/>
    <form:option value="Delivery is done" label="Delivery is done"/>

</form:select>
    <br>
    <div>Use date pattern YYYY-DD-MM</div>
    Date: <form:input path="date"/>
    <form:errors path="date"/>
    <br>
    Commentary: <form:input path="commentary"/>
    <br>

    Producer name: <form:input path="producer"/>
    <br>
    Base of Supply: <form:input path="baseOfSupply"/>
    <br>
    <input type="submit" value="Add!">

</form:form>




<br>
</body>
</html>