<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Register</title>
</head>

<body>
<header>
  <h1>Skapa ett nytt konto</h1>
</header>

<main>
  <form action="RegisterServlet" method="post">
    <label for="name">Namn:</label>
    <input type="text" id="name" name="name" required><br><br>

    <label for="email">Email:</label>
    <input type="email" id="email" name="email" required><br><br>

    <label for="password">Lösenord:</label>
    <input type="password" id="password" name="password" required><br><br>

    <label for="confirmPassword">Bekräfta Lösenord:</label>
    <input type="password" id="confirmPassword" name="confirmPassword" required><br><br>

    <label for="cardNumber">Kort nummer:</label>
    <input type="cardNumber" id="cardNumber" name="cardNumber" required><br><br>

    <input type="submit" value="Register">
  </form>

  <p><a href="login.jsp">Login</a></p>
</main>

<footer>
</footer>
</body>

</html>
