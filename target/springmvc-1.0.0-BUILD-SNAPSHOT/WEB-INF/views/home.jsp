<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body onload="enabtn(input)">
<h1>
	Classroom Scheduling Assistant   
</h1>

<P>  </P>

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
	onclick="location.href='${pageContext.request.contextPath}/test'; disab(this); return false;">
</form>

</body>
</html>