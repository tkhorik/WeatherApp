<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Main - WeatherApp</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css">
    <link rel="icon" href="/favicon.svg" type="image/svg+xml">
</head>
<body>
<div class="container">
    <h2>Welcome, <%= session.getAttribute("username") %>!</h2>
    <a href="/logout" class="btn btn-secondary">Logout</a>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>