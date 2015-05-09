<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Classroom Scheduling Assistant - Home</title>
</head>
<body>
	<div align="center">
		<h1>Classroom Schedule List</h1>
		<h3><a href="/springmvc/importData">Import CSV</a></h3>
		<table border="1">
			<th>Name</th>
			<th># of Students</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Start Time</th>
			<th>End Time</th>
			<th>Mon</th>
			<th>Tues</th>
			<th>Wed</th>
			<th>Thur</th>
			<th>Fri</th>
			<th>LEC:LAB</th>
			<th>Room #</th>
			<th>Action</th>
			
			<c:forEach var="clss" items="${listClass}">
			<tr>
				<td>${clss.name}</td>
				<td>${clss.numStud}</td>
				<td>${clss.teachFirst}</td>
				<td>${clss.teachLast}</td>
				<td>${clss.timeStart}</td>
				<td>${clss.timeEnd}</td>
				<td>${clss.dayM}</td>
				<td>${clss.dayT}</td>
				<td>${clss.dayW}</td>
				<td>${clss.dayTh}</td>
				<td>${clss.dayF}</td>
				<td>${clss.tag}</td>
				<td>${clss.room}</td>
				<td>
					<% /*<a href="/springmvc/editClass?name=${clss.name}">Edit</a>
					&nbsp;&nbsp;&nbsp;&nbsp;*/ %>
					<a href="/springmvc/deleteClass?name=${clss.name}">Delete</a>
				</td>
			</tr>
			</c:forEach>
		</table>
	</div>

</body>
</html>