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
			
			<c:forEach var="class" items="${listClass}">
			<tr>
				<td>${class.name}</td>
				<td>${class.numStud}</td>
				<td>${class.teachFirst}</td>
				<td>${class.teachLast}</td>
				<td>${class.timeStart}</td>
				<td>${class.timeEnd}</td>
				<td>${class.dayM}</td>
				<td>${class.dayT}</td>
				<td>${class.dayW}</td>
				<td>${class.dayTh}</td>
				<td>${class.dayF}</td>
				<td>${class.tag}</td>
				<td>
					<a href="/editClass?name=${class.name}">Edit</a>
					&nbsp;&nbsp;&nbsp;&nbsp;
					<a href="/deleteClass?name=${class.name}">Delete</a>
				</td>
			</tr>
			</c:forEach>
		</table>
	</div>

</body>
</html>