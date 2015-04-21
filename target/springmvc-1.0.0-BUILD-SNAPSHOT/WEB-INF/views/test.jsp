<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false" %>
<html>
<head>
<title>Input</title>
</head>
<body>
	<div align="center">
		<form:form action="input" method="post" commandName="classForm">
			<table border="1">
				<tr>
					<td colspan="2" align="center"><h2>Class Form</h2></td>
				</tr>
				<tr>
					<td>Class Name:</td>
					<td><form:input path="name" /></td>
				</tr>
				<tr>
					<td>Number of Students:</td>
					<td><form:input path="numStud" /></td>
				</tr>
				<tr>
					<td>Teacher First Name:</td>
					<td><form:input path="teachFirst" /></td>
				</tr>
				<tr>
					<td>Teacher Last Name:</td>
					<td><form:input path="teachLast" /></td>
				</tr>
				<tr>
					<td>Class Time Start:</td>
					<td><form:input path="timeStart" /></td>
				</tr>
				<tr>
					<td>Class Time End:</td>
					<td><form:input path="timeEnd" /></td>
				</tr>
				<tr>
					<td><form:checkbox path="day[0]" />M</td>
					<td><form:checkbox path="day[1]" />T</td>
					<td><form:checkbox path="day[2]" />W</td>
					<td><form:checkbox path="day[3]" />Th</td>
					<td><form:checkbox path="day[4]" />F</td>
				</tr>
				<tr>
					<td>LEC/LAB</td>
					<td><form:select path="tag" items="${tagList}" /></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit" value="Submit" /></td>
				</tr>
			</table>
		</form:form>
	</div>
	
</body>
</html>