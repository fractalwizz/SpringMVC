<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body onload="enabtn(input)">
<h1>
	Hello world!  
</h1>

<P>  Testing Spring MVC Connectivity
<P>  The time on the server is ${serverTime}. </P>

<script type="text/javascript">
	function enabtn(testButton) {
		testButton.disabled = false;
	}
</script>

<script type="text/javascript">
	function disab(testButton) {
		testButton.disabled = true;
	}
</script>

<form>
<input type="button" id="input" value="Input"
onclick="window.open('${pageContext.request.contextPath}/test', 'newwindow', 'width=300, height=250'); disab(this); return false;">
</form>

</body>
</html>