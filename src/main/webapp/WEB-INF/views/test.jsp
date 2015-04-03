<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
    <title>Test page</title>
</head>
<body>
<h1>
    ${message} 
</h1>
<button onclick = "closing()">Submit</button>

<script>
function closing() {
	window.close();
	window.opener.location.reload();
}
</script>
</body>
</html>