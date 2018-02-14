<%--
  Created by IntelliJ IDEA.
  User: Dron
  Date: 13.02.2018
  Time: 16:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration second Step</title>
</head>
<body>
<h3> Registration </h3>
<h3> 2 step</h3>
<%
    if (request.getAttribute("error") != null)
        error = (String) request.getAttribute("error");
%>
<p>
    <%=error%>
</p>
<%
    error = "";
%>

<%!
    String email="";
    String firstName="";
    String lastName="";
    String phone="";
    String error = "";
%>
<%
    if (request.getAttribute("firstName")!=null) firstName=(String)request.getAttribute("firstName");
    if (request.getAttribute("lastName")!=null) lastName=(String)request.getAttribute("lastName");
    if (request.getAttribute("email")!=null) email=(String)request.getAttribute("email");
    if (request.getAttribute("phone")!=null) phone=(String)request.getAttribute("phone");

%>
<%--<%=error%>--%>
<form action="/RegistrationSecondStep" method="post">
    Enter First Name: <input type='text' name='firstName' value="<%=firstName%>" /> <br />
    Enter Last Name: <input type='text' name='lastName' value="<%=lastName%>" /> <br />
    Enter email: <input type='email' name='email' value="<%=email%>"/> <br />
    Enter phone number: <input type='text' name='phone' value="<%=phone%>" /> <br />

    <input type='submit'  value="Registration"/>
</form>
</body>
</html>
