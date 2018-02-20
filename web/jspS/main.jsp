<%@ page import="beans.Product" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="static logic.ServicesForSession.*" %>
<%@ page import="static logic.ServicesForContext.addProductsToContext" %>
<%@ page import="static logic.ServicesForCockie.*" %>

<html>
<head>
    <link href="../css/main.css" rel="stylesheet" type="text/css"/>
    <title>Dron's Store</title>
</head>
<body>
<a href="index.jsp"><H1>Welcome to Dron's Store.</H1></a>

<%
    String guest;
    if (request.getSession().isNew())
        guest = getFirstNameFromCookie(request);
    else guest = getFirstNameFromSession(request);
%>

<div>
    Hello <%=guest%>
</div>
<% if (isLogedInSession(request)) {%>
<div>

    <form action="LogOut" method="post">
        <button type="submit">Log out</button>
    </form>
</div>

<%} else {%>
<div>
    <button onclick="location.href='jspS/registrationFirstStep.jsp'">Registration</button>
    <button onclick="location.href='jspS/logIn.jsp'">Log In</button>
</div>
<%}%>

    <jsp:include page="paginationCategories.jsp"/>

<div class="border">

    <jsp:include page="paginationProducts.jsp"/>

    <% if (request.getServletContext().getAttribute("products")==null)
        addProductsToContext(1,request);
        ArrayList<Product> list = (ArrayList<Product>) request.getServletContext().getAttribute("products");
        if (list != null)
            for (Product product : list) {
    %>
    <p>Name: <%=product.getName()%> </p>
    <p>Price: <%=product.getPrice()%> $</p>

    <p>
        <img src="${pageContext.request.contextPath}/blobToImage?idProduct=<%=product.getIdProduct()%>"
             width="160" height="160" alt="Photo"/>
    </p>

    <form action="${pageContext.request.contextPath}/InfoAboutProduct" method="post">
        <button type="submit" name="idProduct" value="<%=product.getIdProduct()%>">more info</button>
    </form>

    <form action="buy" method="post">
        <button type="submit" name="buy" value="<%=product.getIdProduct()%>">buy this</button>
    </form>
    <%}%>
</div>
</body>
</html>