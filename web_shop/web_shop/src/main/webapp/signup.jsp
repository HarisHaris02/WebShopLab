<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Register</title>
  <link rel="stylesheet" href="styles.css">
</head>

<body>
<header>
  <h1>Create a New Account</h1>
</header>

<main>
  <form action="RegisterServlet" method="post">
    <label for="name">Name:</label>
    <input type="text" id="name" name="name" required><br><br>

    <label for="email">Email:</label>
    <input type="email" id="email" name="email" required><br><br>

    <label for="password">Password:</label>
    <input type="password" id="password" name="password" required><br><br>

    <label for="confirmPassword">Confirm Password:</label>
    <input type="password" id="confirmPassword" name="confirmPassword" required><br><br>

    <label for="cardNumber">Card number:</label>
    <input type="cardNumber" id="cardNumber" name="cardNumber" required><br><br>

    <input type="submit" value="Register">
  </form>

  <p>Already have an account? <a href="login.jsp">Login</a></p>
</main>

<footer>
</footer>
</body>

</html>
