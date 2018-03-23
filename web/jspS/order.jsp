<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
    <title>Order</title>
</head>
<body>
<%
    String address="";
%>
<form action="${pageContext.request.contextPath}/" method="post">
    Enter shipping address: <input type='text' name='address' value="<%=address%>" />
    <input type='submit'  value="To order"/>
</form>
<jsp:include page="buttonBack.jsp"/>
</body>
</html>
