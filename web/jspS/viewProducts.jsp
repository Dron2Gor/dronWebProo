<%@ page import="beans.Product" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%

    if (request.getServletContext().getAttribute("products") == null) {
%>
<p>NO PRODUCT</p>
<% } else {
    ArrayList<Product> list = (ArrayList<Product>) request.getServletContext().getAttribute("products");
    for (Product product : list) {
        if (product.getName() != null) {
%>
<p>Name: <%=product.getName()%>
</p>
<p>Price: <%=product.getPrice()%> $</p>

<p>
    <img src="${pageContext.request.contextPath}/blobToImage?idProduct=<%=product.getIdProduct()%>" width="160" height="160" alt="Photo"/>

</p>

<form action="${pageContext.request.contextPath}/InfoAboutProduct" method="post">
    <button type="submit" name="idProduct" value="<%=product.getIdProduct()%>">more info</button>
</form>

<form action="${pageContext.request.contextPath}/AddProductToBasket" method="post">
    <button type="submit" name="idProduct" value="<%=product.getIdProduct()%>">add this to basket</button>
</form>
<%
            }
        }
    }
%>
