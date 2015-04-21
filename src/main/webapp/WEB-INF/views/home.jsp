<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Classroom Scheduling Assistant - Home</title>
</head>
<body>
	<div align="center">
		<h1>Classroom Schedule List</h1>
		<h3><a href="/springmvc/newClass">New Class</a></h3>
		<table border="1">
			<th>Name</th>
			<th>Number of Students</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Start Time</th>
			<th>End Time</th>
			<th>Monday</th>
			<th>Tuesday</th>
			<th>Wednesday</th>
			<th>Thursday</th>
			<th>Friday</th>
			<th>LEC:LAB</th>
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
				<td>
					<a href="/springmvc/editClass?name=${clss.name}">Edit</a>
					&nbsp;&nbsp;&nbsp;&nbsp;
					<a href="/springmvc/deleteClass?name=${clss.name}">Delete</a>
				</td>
			</tr>
			</c:forEach>
		</table>
	</div>

</body>
</html>