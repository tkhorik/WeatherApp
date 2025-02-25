<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Login - WeatherApp</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css">
  <link rel="icon" href="/favicon.svg" type="image/svg+xml">
</head>
<body>
<div class="container">
  <h2>Login</h2>
  <form action="/login" method="post">
    <div class="form-group">
      <label for="username">Username:</label>
      <input type="text" class="form-control" id="username" name="username">
    </div>
    <div class="form-group">
      <label for="password">Password:</label>
      <input type="password" class="form-control" id="password" name="password">
    </div>
    <button type="submit" class="btn btn-primary">Login</button>
  </form>
  <a href="/register">Register</a>
</div>
</body>
</html>