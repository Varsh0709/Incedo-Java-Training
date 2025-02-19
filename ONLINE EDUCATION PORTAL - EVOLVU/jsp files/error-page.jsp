<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error Page</title>
    <style>
        body { font-family: Arial, sans-serif; text-align: center; padding: 50px; background-color: #f8d7da; }
        h1 { color: #721c24; }
        p { color: #721c24; font-size: 18px; }
        .container { background: white; padding: 20px; border-radius: 10px; box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); width: 50%; margin: auto; }
        a { text-decoration: none; color: #155724; font-weight: bold; }
        a:hover { text-decoration: underline; }
    </style>
</head>
<body>
    <div class="container">
        <h1>Oops! Something went wrong 😞</h1>
        <p>${errorMessage}</p>
        <a href="/users">Go Back to Users List</a>
    </div>
</body>
</html>
