<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false" %>
<html>
<head>
<title>Edit Class</title>
</head>
<body>
	<div align="center">
		<h1>Edit Class</h1>
		<form:form action="saveClass" method="post" modelAttribute="class">
			<table>
				<form:hidden path="class"/>
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
					<td><form:checkbox path="dayM" />M</td>
					<td><form:checkbox path="dayT" />T</td>
					<td><form:checkbox path="dayW" />W</td>
					<td><form:checkbox path="dayTh" />Th</td>
					<td><form:checkbox path="dayF" />F</td>
				</tr>
				<tr>
					<td>LEC/LAB</td>
					<td><form:select path="tag" items="${tagList}" /></td>
				</tr>
				<tr>
					<td>Room #:</td>
					<td><form:input path="room" /></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit" value="Save" /></td>
				</tr>
			</table>
		</form:form>
	</div>
	
</body>
</html>