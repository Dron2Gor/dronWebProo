<%@ page import="beans.Basket" %>
<%@ page import="logic.ServicesForSession" %>
<%@ page import="java.util.Map" %>
<%@ page import="beans.Product" %>
<%@ page import="logic.ServicesForDataBase" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Basket</title>
</head>
<body>

<h3>Basket</h3>

<%

    Basket basket = ServicesForSession.getBasketFromSesion(request);
    double orderSumm=0;
    for (Map.Entry<Integer, Integer> pair : basket.getBasket().entrySet()) {
        Product product = ServicesForDataBase.getProductFromBaseById(pair.getKey());
        double summ=product.getPrice()*pair.getValue();
        orderSumm+=summ;

%>
<p>Name: <%=product.getName()%></p>
<p>Price for one:<%=product.getPrice()%> $</p>
<p>count: <%=pair.getValue()%></p>
<p>price for all: <%=summ%> $</p>
<hr/>
<%
    }
%>

<p>Order's price: <%=orderSumm%></p>
<jsp:include page="buttonBack.jsp"/>

</body>
</html>
