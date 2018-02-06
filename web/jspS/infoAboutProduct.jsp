<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Info about products</title>
</head>
<body>
    <div>
        <p>Product info</p>
        <p>Name: ${product.name}</p>
        <p>Information: ${product.description}</p>
        <p>Price: ${product.price}</p>

        <button onclick="location.href='/index.jsp'">back</button>
    </div>
</body>
</html>
