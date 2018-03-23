<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Info about products</title>
</head>
<body>
    <div>
        <p>
            <img src="${pageContext.request.contextPath}/blobToImage?idProduct=${product.idProduct}" width="240" height="240" alt="Photo"/>

        </p>
        <p>Product info</p>
        <p>Name: ${product.name}</p>
        <p>Information: ${product.description}</p>
        <p>Price: ${product.price}</p>

        <jsp:include page="buttonBack.jsp"/>

    </div>
</body>
</html>
