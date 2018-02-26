<%@ page import="java.util.ArrayList" %>
<%@ page import="logic.ServicesForPages" %>
<%@ page import="logic.servicesForDataBase.ServicesForProductDB" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<%
    int amountPages = -1;

    if (request.getSession().getAttribute("listIdProducts") != null) {
        ArrayList<Integer> listIdProducts = (ArrayList<Integer>) request.getSession().getAttribute("listIdProducts");

        amountPages = ServicesForPages.getAmountPages(listIdProducts.size());
    }
    if (amountPages == -1)

        amountPages = ServicesForPages.getAmountPages(ServicesForProductDB.amountNameOfProductsInBase());

    if (amountPages != 1) {
        for (int i = 1; i <= amountPages; i++) {
%>
<a href="${pageContext.request.contextPath}/PaginationProducts?page=<%=i%>">
    Page<%=i%>
</a>
<%
        }
    }
%>