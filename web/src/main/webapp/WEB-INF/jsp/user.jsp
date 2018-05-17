<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>user:</h1>
${requestScope.user.name}<br>
${requestScope.user.role.name}<br>
${requestScope.user.password}<br>
${requestScope.user.mailbox}
</body>
</html>
