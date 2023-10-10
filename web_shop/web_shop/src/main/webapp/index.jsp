<%@ page import="com.example.web_shop.Handlers.Product" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="com.example.web_shop.Handlers.Product" %>
<%@ page import="com.example.web_shop.Dao.ProductDAO" %>
<%@ page import="com.example.web_shop.EntitiesInfo.ProductInfo" %>
<%@ page import="com.example.web_shop.Handlers.ProductHandler" %>
<%

    List<ProductInfo> products  = ProductHandler.getAllProducts();
%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Hem</title>
    <link rel="stylesheet" href="styles.css">
</head>

<body>
<header>
    <h1>Det här är vår hemsida</h1>
    <p>Hej, <%= session.getAttribute("name") != null ? session.getAttribute("name") : "Gäst" %>!</p>
    <nav>
        <% if (session.getAttribute("name") == null) { %>
        <div class="buttons">
            <a href="login.jsp">Logga in</a>
        </div>
        <% } else { %>
        <div class="buttons">
            <a href="<%=request.getContextPath()%>/index.jsp?logout=true">Logga ut</a>
        </div>
            <a href="cart.jsp">Kund vagn</a>

        <% } %>

    </nav>
</header>
<%
    String logout = request.getParameter("logout");
    if(logout != null && logout.equals("true")) {
        session.invalidate();
        response.sendRedirect(request.getContextPath() + "/index.jsp");
        return;
    }
%>
<main>
    <h2>Produkter</h2>

    <div id="products">
        <% for (ProductInfo product : products) { %>
        <div class="product-card">
            <h3><%= product.getName() %></h3>
            <p><%= product.getDescription() %></p>
            <p>Pris: <%= product.getCost() %>kr</p>
            <% if(product.getImage() != null && !product.getImage().trim().isEmpty()) { %>
            <img src="<%= product.getImage() %>" alt="<%= product.getName() %>">
            <% } %>
            <form action="ShoppingCart" method="post">
                <input type="hidden" name="productId" value="<%= product.getId() %>">
                <% if (session.getAttribute("name") != null) { %>
                    <input type="submit" value="Add to Cart">
                <% } %>
            </form>
        </div>
        <% } %>

    </div>
</main>
</body>

</html>
