<%@ page import="static logic.AutoLogIn.doAutoLogIn" %>
<%@ page import="static logic.ServicesForContext.addProductsToContext" %>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Auto login</title>
</head>
<body>
<%
    request.getSession().invalidate();
    doAutoLogIn(request);
    addProductsToContext(1,request);
%>
<jsp:include page="jspS/main.jsp"/>
</body>
</html>
