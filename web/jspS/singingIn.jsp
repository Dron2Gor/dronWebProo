<%@ page import="static logic.ServicesForCockie.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Singing in</title>
</head>
<body>
<%!
    String userName ;
    String password ;
    String error = "";
%>
<% if (request.getAttribute("error") != null) error = (String) request.getAttribute("error");
    userName=getUserNameFromCookie(request);
    password=getPasswordFromCookie(request);

%>
<H3>Singing in:</H3>
<p>
    <%=error%>
</p>
<%error = "";%>
<form action="/SingingIn" method="post">
    Enter login: <input type='text' name='login' value="<%=userName%>"/> <br/>
    Enter password: <input type='password' name='password' value="<%=password%>"/> <br/>
    <input type='submit' value="Singing in"/>
</form>

</body>
</html>
