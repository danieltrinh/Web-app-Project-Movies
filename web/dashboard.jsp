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
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="resources/css/dashboard.css">

<!------ Include the above in your HEAD tag ---------->
<html>
<head>
    <title>Welcome </title>
</head>
<body>

<%= session.getAttribute("personalList")  %>

<%= request.getAttribute("watchedList")  %>
<%= request.getAttribute("willWatchList")  %>
<% User user = (User) request.getAttribute("userInfo"); %>

<div class="container emp-profile">
    <form method="post">
        <div class="row">

            <div class="col-md-6">
                <div class="profile-head">
                    <h5>
                        <%= user.getFullname() %>
                    </h5>
                    <ul class="nav nav-tabs" id="myTab" role="tablist">
                        <li class="nav-item">
                            <a class="nav-link active" id="home-tab" data-toggle="tab" href="#home" role="tab" aria-controls="home" aria-selected="true">About</a>
                        </li>
                    </ul>
                </div>
            </div>

        </div>
        <div class="row">
            <div class="col-md-8">
                <div class="tab-content profile-tab" id="myTabContent">
                    <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
                        <div class="row">
                            <div class="col-md-6">
                                <label>Email</label>
                            </div>
                            <div class="col-md-6">
                                <p><%= user.getEmail() %>
                                </p>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-md-6">
                                <label>Telephone</label>
                            </div>
                            <div class="col-md-6">
                                <p><%=user.getTelephone() %></p>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6">
                                <label>Address</label>
                            </div>
                            <div class="col-md-6">
                                <p><%= user.getAddress()%></p>
                            </div>
                        </div>

                    </div>
                </div>
            </div>
        </div>
    </form>
</div>
</body>
</html>
