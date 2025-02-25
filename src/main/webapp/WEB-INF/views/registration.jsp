<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registration</title>
</head>
<body>
<h1>Registration</h1>
<form action="<%= request.getContextPath() %>/register" method="post">
    <div>
        <label for="username">Username:</label>
        <input type="text" id="username" name="username" required>
    </div>
    <div>
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required>
    </div>
    <div>
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required>
    </div>
    <div>
        <button type="submit">Register</button>
    </div>
</form>
<p>Already have an account? <a href="<%= request.getContextPath() %>/login">Login here</a></p>
</body>
</html>
