<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="static logic.ServicesForSession.*" %>
<%@ page import="static logic.ServicesForCockie.*" %>

<html>
<head>
    <link href="../css/main.css" rel="stylesheet" type="text/css"/>
    <title>Dron's Store</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/jspS/main.jsp"><H1>Welcome to Dron's Store.</H1></a>

<%
    String guest = "guest";
    if (getFirstNameFromSession(request)==null) {
        if (getFirstNameFromCookie(request) != null)
            guest = getFirstNameFromCookie(request);
    } else guest = getFirstNameFromSession(request);
%>

<div>
    Hello <%=guest%>
</div>
<jsp:include page="viewAmountProductsInBusket.jsp"/>

<% if (isLogedInSession(request)) {%>
<div>
    <button onclick="location.href='/LogOut'">Log Out</button>

</div>

<%} else {%>
<div>
    <button onclick="location.href='/jspS/registrationFirstStep.jsp'">Registration</button>
    <button onclick="location.href='/jspS/logIn.jsp'">Log In</button>
</div>
<%}%>

<jsp:include page="paginationCategories.jsp"/>

<div class="border">

    <jsp:include page="paginationProducts.jsp"/>

    <jsp:include page="viewProducts.jsp"/>

</div>
</body>
</html>
