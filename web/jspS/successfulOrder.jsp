
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Successful Order</title>
</head>
<body>
<%
    String idOrder="";
if (request.getAttribute("idOrder")!=null)
            idOrder=(String)request.getAttribute("idOrder");
%>
<h3> -=Succsessful=- </h3>

<p>Number your order is
    <%=idOrder%>
</p>

<jsp:include page="buttonHome.jsp"/>
</body>
</html>
