<%@ page import="beans.Good" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="static logic.ServicesForCockie.*" %>
<html>
<head>
    <link href="css/main.css" rel="stylesheet" type="text/css">
    <title>Dron</title>
</head>
<body>
<H1>Welcome to Dron's Store. Hello!!!</H1>

<% String guest=getUserNameFromCookie(request);
    if (session.getAttribute("isLogged")!=null){

}%>

<div>
    Hello <%=guest%>
</div>

<div>
    <button onclick="location.href='jspS/singingUp.jsp'">Singing up</button>
    <button onclick="location.href='jspS/singingIn.jsp'">Singing In</button>
</div>
<%--<jsp:include page="/good"></jsp:include>--%>
<div class="border">
    <% ArrayList<Good> list = (ArrayList<Good>) request.getSession().getAttribute("goods");
        if (list != null)
            for (Good good : list) {
    %>
    <p>Name <%=good.getName()%>
    </p>
    <p>Price <%=good.getPrice()%> $</p>

    <form action="info" method="post">
        <button type="submit"  name="info" value="<%=good.getArticul()%>">more info</button>
    </form>

    <form action="buy" method="post">
        <button type="submit" name="buy" value="<%=good.getArticul()%>">buy this</button>
    </form>
    <%}%>
</div>
</body>
</html>
