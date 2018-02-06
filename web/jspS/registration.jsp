<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SingingUp</title>
</head>
<body>
<h3>Singing Up:</h3>

<form action="/Registration" method="post">
    Enter login: <input type='text' name='login'/> <br />
    Enter email: <input type='email' name='email' /> <br />
    Enter password: <input type='password' name='password' /> <br />
    Confirm password: <input type='password' name='password_repeat' /> <br />
    <input type='submit'  value="Singing Up"/>
</form>
</body>
</html>
