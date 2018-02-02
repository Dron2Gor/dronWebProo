<%--
  Created by IntelliJ IDEA.
  User: Dron
  Date: 01.02.2018
  Time: 17:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="css/main.css"
          rel="stylesheet" type="text/css">
    <title>Dron</title>
</head>
<body>
<H1>Welcome to Dron's Store. Hello!!!</H1>

<div class="border">
    <%--<div>--%>
        <%--<form action="first" method="post">--%>
            <%--<button type="submit" name="button" value="Olesya">Button Olesya</button>--%>
        <%--</form>--%>
        <%--<a class="btn" onclick="" href="first?one=Olesya">Показать все имена</a>--%>
    <%--</div>--%>

        <%! int i=0;%>
        <% for (i=0; i<2; i++) { %>
    ${good.name}
    ${good.price}
    <form action="info" method="post">
        <button type="submit" name="info" value="1">more info</button>
    </form>
        <form action="buy" method="post">
            <button type="submit" name="buy" value="${good.articul}">buy this</button>
        </form>
<% }%>
</div>
</body>
</html>
