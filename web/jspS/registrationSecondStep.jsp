<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Registration second Step</title>
</head>
<body>
<h3> Registration </h3>
<h3> 2 step</h3>
<%
    String  error="";
    if (request.getAttribute("error") != null)
        error = (String) request.getAttribute("error");
%>
<p>
    <%=error%>
</p>
<%
    error = "";
%>

<%
    String email="";
    String firstName="";
    String lastName="";
    String phone="";

    if (request.getAttribute("firstName")!=null) firstName=(String)request.getAttribute("firstName");
    if (request.getAttribute("lastName")!=null) lastName=(String)request.getAttribute("lastName");
    if (request.getAttribute("email")!=null) email=(String)request.getAttribute("email");
    if (request.getAttribute("phone")!=null) phone=(String)request.getAttribute("phone");

%>

<form action="${pageContext.request.contextPath}/RegistrationSecondStep" method="post">
    Enter First Name: <input type='text' name='firstName' value="<%=firstName%>" /> <br />
    Enter Last Name: <input type='text' name='lastName' value="<%=lastName%>" /> <br />
    Enter email: <input type='email' name='email' value="<%=email%>"/> <br />
    Enter phone number: <input type='text' name='phone' value="<%=phone%>" /> <br />

    <input type='submit'  value="Registration"/>

</form>
<jsp:include page="buttonBack.jsp"/>
</body>
</html>
