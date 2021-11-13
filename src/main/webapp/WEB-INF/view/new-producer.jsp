<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<body>
<body bgcolor="#CCCCCC">
<h2>Add new producer</h2>
<br>

<div>Links</div>
<a href="/allProducer">Show all Producers</a>
<br>
<br>
<form:form action="saveProducer" modelAttribute="producer">
    <form:hidden path="id"/>
    Name of Producer: <form:input path="name"/>
    <form:errors path="name"/>
    <br>
    Contact Person: <form:input path="contact"/>
    <br>
    <br>
    <div>Use phone pattern X-XXX-XXX-XXXX</div>
    <br>
    Phone Number: <form:input path="phone"/>
    <form:errors path="phone"/>
    <br>
    <input type="submit" value="Add!">

</form:form>




<br>
</body>
</html>