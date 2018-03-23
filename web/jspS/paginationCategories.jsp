<%@ page import="logic.servicesForDataBase.ServicesForProductDB" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<%
   String nameCategory="all";
%>

<a href="${pageContext.request.contextPath}/PaginationCategories?nameCategory=<%=nameCategory%>">All products</a>
<%
    ArrayList<String> names = ServicesForProductDB.getAllCategoryNamesFromCategories();
    for (String tempNameCategory : names) {
        nameCategory=tempNameCategory;
%>
    <a href="${pageContext.request.contextPath}/PaginationCategories?nameCategory=<%=nameCategory%>"><%=nameCategory%></a>
<%
    }
%>

