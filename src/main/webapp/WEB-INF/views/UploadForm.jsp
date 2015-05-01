<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false" %>
<html>
<head>
<title>Import CSV</title>
</head>
<body>
	<div align="center">
		<h1>Import Class CSV</h1>
		<form:form action="upload" method="post" enctype="multipart/form-data">
			Import File:
			<input type="file" name="file" />
			<input type="submit" value="Upload" />
			<form:errors path="file" cssStyle="color: #ff0000;" />
		</form:form>
	</div>
	
</body>
</html>