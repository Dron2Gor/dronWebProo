<%@ page import="logic.ServicesForSession" %>
<%@ page import="beans.Basket" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    int amount=0;
    Basket basket=ServicesForSession.getBasketFromSesion(request);
    if (basket!=null){
        amount=basket.getAmountProductsInBasket();
    }
%>
<p>
  In basket = <%=amount%>
    <%
        if (amount>0){
    %>
    <button onclick="location.href='/jspS/viewBasket.jsp'">checkout</button>
    <%
        }
    %>

</p>

