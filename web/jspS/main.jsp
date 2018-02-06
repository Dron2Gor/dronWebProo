<%@ page import="beans.Product" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="static logic.ServicesForSession.*" %>
<%@ page import="static logic.ServicesForContext.addProductsToContext" %>
<html>
<head>
    <link href="../css/main.css" rel="stylesheet" type="text/css"/>
    <title>Dron's Store</title>
</head>
<body>
<H1>Welcome to Dron's Store.</H1>

<%
    String guest = getUserNameFromSession(request);
%>

<div>
    Hello <%=guest%>
</div>
<% if (isLogged(request)) {%>
<div>

    <form action="LogOut" method="post">
        <button type="submit">Log out</button>
    </form>
</div>

<%} else {%>
    <div>
        <button onclick="location.href='jspS/registration.jsp'">Registration</button>

        <button onclick="location.href='jspS/logIn.jsp'">Log In</button>
    </div>
<%}%>
<div class="border">
    <%  addProductsToContext(request);
        ArrayList<Product> list = (ArrayList<Product>) request.getServletContext().getAttribute("products");

    if (list != null)
            for (Product product : list) {
    %>
    <p>Name <%=product.getName()%></p>
    <p>Price <%=product.getPrice()%> $</p>

    <form action="InfoAboutProduct" method="post">
        <button type="submit" name="info" value="<%=product.getId()%>">more info</button>
    </form>

    <form action="buy" method="post">
        <button type="submit" name="buy" value="<%=product.getId()%>">buy this</button>
    </form>
    <%}%>
</div>
</body>
</html>
