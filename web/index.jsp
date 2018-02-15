<%@ page import="static logic.AutoLogIn.doAutoLogIn" %>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Auto login</title>
</head>
<body>
<%doAutoLogIn(request);%>
<jsp:include page="jspS/main.jsp"/>
</body>
</html>
