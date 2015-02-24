<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  Testing Spring MVC Connectivity
<P>  The time on the server is ${serverTime}. </P>

<a href="${pageContext.request.contextPath}/test" onclick = "window.open('${pageContext.request.contextPath}/test', 'newwindow', 'width=300, height=250'); return false;">Test</a>
</body>
</html>