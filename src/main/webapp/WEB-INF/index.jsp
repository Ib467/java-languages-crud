<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page isErrorPage="true" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.0/css/bulma.min.css">
<style>
body{
font-size: 1.5em;
}

</style>
</head>
<body class="container">

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
  
<h1>All Languages</h1>
<table class="">
    <thead>
        <tr>
            <th>Name</th>
            <th>Creator</th>
            <th>Version</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${languages}" var="language">
        <tr>
            <td><a href="/languages/${language.id}/show"> <c:out value="${language.name}"/>  </a></td>
            <td><c:out value="${language.creator}"/></td>
            <td><c:out value="${language.version}"/></td>
            <td><a href="/languages/${language.id}">Edit </a>|
            <a href="/languages/${language.id}/delete">Delete </a></td>
            
        </tr>
        </c:forEach>
    </tbody>
</table>
<!-- <a href="/books/new">New Book</a> -->

	<br>
	<h1>Create a Language</h1>
	<form:form action="/languages" method="post" modelAttribute="language">
	    <p>
	        <form:label path="name">Name</form:label>
	        <form:errors path="name"/>
	        <form:input path="name"/>
	    </p>
	    <p>
	        <form:label path="creator">Creator</form:label>
	        <form:errors path="creator"/>
	        <form:input path="creator"/>
	    </p>
	    <p>
	        <form:label path="version">Version</form:label>
	        <form:errors path="version"/>
	        <form:input path="version"/>
	    </p>
	    
	    <input type="submit" value="Submit"/>
	</form:form>



</body>
</html>