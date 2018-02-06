<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Info</title>
</head>
<body>
    <div>
        <p>Good info</p>
        <p>Name: ${good.name}</p>
        <p>Information: ${good.description}</p>
        <p>Price: ${good.price}</p>

        <button onclick="location.href='/good'">back</button>
    </div>
</body>
</html>
