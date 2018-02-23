<%@ page import="java.util.ArrayList" %>
<%@ page import="logic.ServicesForDataBase" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<%
   String nameCategory="all";
%>

<a href="/PaginationCategories?nameCategory=<%=nameCategory%>">All products</a>
<%
    ArrayList<String> names = ServicesForDataBase.getAllCategoryNamesFromCategories();
    for (String tempNameCategory : names) {
        nameCategory=tempNameCategory;
%>
    <a href="/PaginationCategories?nameCategory=<%=nameCategory%>"><%=nameCategory%></a>
<%
    }
%>

