<%@ page import="logic.ServicesForDataBase" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<%
    int amountPages;

    if (request.getServletContext().getAttribute("listIdProducts") != null) {
        ArrayList<Integer> listIdProducts = (ArrayList<Integer>) request.getServletContext().getAttribute("listIdProducts");
        amountPages = listIdProducts.size();
    } else
        amountPages = ServicesForDataBase.amountNameOfProductsInBase();

    for (int i = 1; i <= amountPages; i++) {
%>
<a href="${pageContext.request.contextPath}/PaginationProducts?page=<%=i%>">
    Page<%=i%>
</a>
<%
    }
%>