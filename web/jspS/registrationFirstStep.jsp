<%@ page contentType="text/html;charset=UTF-8"  %>
<html>
<head>
    <title>Registration 1</title>
</head>
<body>
<h3> Registration </h3>
<h3> 1 step</h3>
<%  String loginName="";
    String error = "";

    if (request.getAttribute("loginName") != null)
        loginName = (String) request.getAttribute("loginName");
    if (request.getAttribute("error") != null)
        error = (String) request.getAttribute("error");
%>
<p>
    <%=error%>
</p>
<%
    error = "";
%>
<form action="${pageContext.request.contextPath}/RegistrationFirstStep" method="post">

    Enter login: <input type='text' name='loginName' value="<%=loginName%>"/> <br/>
    Enter password: <input type='password' name='password'/> <br/>
    Confirm password: <input type='password' name='password_repeat'/> <br/>
    <input type='submit' value="Next"/>
</form>
    <jsp:include page="buttonBack.jsp"/>
</body>
</html>
