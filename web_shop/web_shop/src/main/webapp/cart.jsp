<%@ page import="com.example.web_shop.Handlers.Product" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.web_shop.Handlers.ShoppingCartHandler" %>
<%@ page import="com.example.web_shop.EntitiesInfo.ShoppingCartInfo" %>
<%@ page import="com.example.web_shop.EntitiesInfo.UserInfo" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Kund vagn</title>
</head>
<body>
<header>
    <p>Hejsan <%= session.getAttribute("name") != null ? session.getAttribute("name") : "Gäst" %>!</p>
    <nav>

        <% if (session.getAttribute("name") == null) { %>
        <div>

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
    UserInfo user = (UserInfo) session.getAttribute("user");
    if (user != null) {

        List<ShoppingCartInfo> cartItems = ShoppingCartHandler.getCartForUser(user.getId());

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
        for (ShoppingCartInfo item : cartItems) {
            Product product = Product.selectProduct(item.getProductId());
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
