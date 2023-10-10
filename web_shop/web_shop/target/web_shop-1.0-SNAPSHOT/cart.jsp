<%@ page import="com.example.web_shop.Handlers.Product" %>
<%@ page import="com.example.web_shop.Handlers.ShoppingCart" %>
<%@ page import="com.example.web_shop.Dao.ShoppingCartDAO" %>
<%@ page import="com.example.web_shop.Handlers.User" %>
<%@ page import="com.example.web_shop.Dao.ProductDAO" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Shopping Cart</title>
</head>
<body>
<header>
    <p>Hejsan <%= session.getAttribute("name") != null ? session.getAttribute("name") : "Gäst" %>!</p>
    <nav>

        <% if (session.getAttribute("name") == null) { %>
        <div class="buttons">
            <a href="login.jsp">Logga in</a>
        </div>
        <% } else { %>
        <a href="<%=request.getContextPath()%>/index.jsp?logout=true">Logga ut</a>
        <a href="cart.jsp">Kund korg</a>
        <a href="index.jsp">Tillbaka</a>
        <% } %>
    </nav>
</header>

<%
    User user = (User) session.getAttribute("user");
    if (user != null) {
        ShoppingCartDAO cartDAO = new ShoppingCartDAO();
        ProductDAO productDAO = new ProductDAO();
        List<ShoppingCart> cartItems = cartDAO.selectCartByUserId(user.getId());
%>
<h2>Din kund korg</h2>
<div style="width: 300px;">
    <div style="display: flex; justify-content: space-between;">

        <p style="font-weight: bold;">Produkt</p>

        <p style="font-weight: bold;">Antal</p>

        <p style="font-weight: bold;">Pris</p>

        <p style="font-weight: bold;">Total Pris</p>

    </div>
    <%
        double grandTotal = 0;
        for (ShoppingCart item : cartItems) {
            Product product = productDAO.selectProduct(item.getProductId());
            double price = product.getCost();
            double total = price * item.getInStock();
            grandTotal += total;
    %>

    <div style="display: flex; justify-content: space-between;">

        <p><%= product.getName() %>
        </p>
        <p><%= item.getInStock() %>
        </p>
        <p><%= price %>
        </p>
        <p><%= total %>
        </p>

    </div>
    <br/>
    <% } %>

</div>


<p><strong>Totala priset: <%= grandTotal %>
</strong></p>
<%
    if (user != null && cartItems.size() > 0) {
%>
<form action="buy" method="post">
    <input type="submit" value="Buy Now">
</form>
<%
    }
%>
<%
} else {
%>
<p>Logga in <a href="login.jsp">Logga in</a></p>
<%
    }
%>


</body>
</html>
