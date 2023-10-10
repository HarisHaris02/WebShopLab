
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>

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
</head>

<body>
<header>
    <h1>Det här är vår hemsida</h1>
    <p>Hej, <%= session.getAttribute("name") != null ? session.getAttribute("name") : "Gäst" %>!</p>
    <nav>
        <% if (session.getAttribute("name") == null) { %>
        <div>
            <a href="login.jsp">Logga in</a>
        </div>
        <% } else { %>
        <div>
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

    <div>
        <% for (ProductInfo product : products) { %>
        <div>
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
