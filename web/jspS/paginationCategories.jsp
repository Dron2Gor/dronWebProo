<%@ page import="java.util.ArrayList" %>
<%@ page import="logic.ServicesForDataBase" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<%
    ArrayList<String> names = ServicesForDataBase.getAllCategoryNamesFromCategories();
    for (String nameCategory : names) {
%>
    <a href="/PaginationCategories?nameCategory=<%=nameCategory%>"><%=nameCategory%></a>
<%
    }
%>

