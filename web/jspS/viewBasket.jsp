<%@ page import="beans.Basket" %>
<%@ page import="logic.ServicesForSession" %>
<%@ page import="java.util.Map" %>
<%@ page import="beans.Product" %>
<%@ page import="logic.servicesForDataBase.ServicesForProductDB" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Basket</title>
</head>
<body>

<h3>Basket</h3>

<%
    Basket basket = ServicesForSession.getBasketFromSesion(request);
    double orderSumm = 0;
    for (Map.Entry<Integer, Integer> pair : basket.getBasket().entrySet()) {
        Product product = ServicesForProductDB.getProductFromBaseById(pair.getKey());
        double summ = product.getPrice() * pair.getValue();
        orderSumm += summ;
%>
        <p>Name: <%=product.getName()%>
        </p>

        <p>Price for one:<%=product.getPrice()%> $</p>

        <p>count: <%=pair.getValue()%>
            <button onclick="location.href='${pageContext.request.contextPath}/MinusProduct?idProduct=<%=product.getIdProduct()%>'">-</button>
            <button onclick="location.href='${pageContext.request.contextPath}/PlusProduct?idProduct=<%=product.getIdProduct()%>'">+</button>
        </p>
        <p>price for all: <%=summ%> $</p>
<hr/>
<%
    }
%>

<p>
    Order's price: <%=orderSumm%>
</p>

<%
String address="";
String error="";
if (request.getAttribute("error")!=null){
    error= (String) request.getAttribute("error");
}
%>
<p><%=error%></p>
<form action="${pageContext.request.contextPath}/MakeOrder" method="post">
    Enter shipping address: <input type='text' name="address" value="<%=address%>" />
    <input type='submit'  value="To order"/>
</form>


<jsp:include page="buttonBack.jsp"/>

</body>
</html>
