<%@ page import="logic.ServicesForDataBase" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<%
    int amountPages= ServicesForDataBase.amountNameOfProductsInBase();
    for (int i = 1; i <=amountPages ; i++) {
%>
<a href="${pageContext.request.contextPath}/PaginationProducts?page=<%=i%>" >Page<%=i%></a>
<%
    }
%>