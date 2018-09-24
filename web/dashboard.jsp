<%@ page import="model.User" %>
<%@ page import="model.UserMovie" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Daniel
  Date: 9/24/2018
  Time: 2:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome </title>
</head>
<body>

<%= session.getAttribute("personalList")  %>

<%= request.getAttribute("watchedList")  %>
<%= request.getAttribute("willWatchList")  %>

</body>
</html>
