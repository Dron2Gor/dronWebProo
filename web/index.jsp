<%@ page import="static logic.AutoLogIn.doAutoLogIn" %><%--
  Created by IntelliJ IDEA.
  User: Dron
  Date: 06.02.2018
  Time: 21:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Auto login</title>
</head>
<body>
<%doAutoLogIn(request);%>
<jsp:include page="jspS/main.jsp"/>
</body>
</html>
