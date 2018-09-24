<%@ page import="model.FromAPI.Movie" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Daniel
  Date: 9/21/2018
  Time: 3:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="header.jsp"/>


<!-- Navigation -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
  <div class="container">
    <a class="navbar-brand" href="#">Start Bootstrap</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarResponsive">
      <ul class="navbar-nav ml-auto">
        <li class="nav-item active">
          <a class="nav-link" href="#">Home
            <span class="sr-only">(current)</span>
          </a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">About</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">Services</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">Contact</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/login.jsp">Login</a>
        </li>
      </ul>
    </div>
  </div>
</nav>
<%! String poster_prefix = "https://image.tmdb.org/t/p/w500/"; %>
<!-- Page Content -->
<div class="container">

  <!-- Heading Row -->
  <div class="row my-4">
    <div class="col-lg-8">
      <img class="img-fluid rounded" src="<%= poster_prefix %>${mainBannerMovie.backdrop_path}" alt="">
    </div>
    <!-- /.col-lg-8 -->
    <div class="col-lg-4">
      <h1>${mainBannerMovie.original_title}</h1>
      <p>${mainBannerMovie.overview}</p>
      <a class="btn btn-primary btn-lg" href="/movie?id=${mainBannerMovie.id}">To the Movie</a>
    </div>
    <!-- /.col-md-4 -->
  </div>
  <!-- /.row -->

  <!-- Call to Action Well -->
  <div class="card text-white bg-secondary my-4 text-center">
    <div class="card-body">
      <p class="text-white m-0">Browse through our newest and hottest Movies</p>
    </div>
  </div>

  <!-- Content Row -->
  <div class="row">

      <%  ArrayList<Movie> subBannerMovies = (ArrayList<Movie>) request.getAttribute("subBannerMovies");
        for (Movie m: subBannerMovies)
        {  %>
      <div class="col-md-4 mb-4">
      <%--<c:forEach  items="$(subBannerMovies}" var="Item" >--%>
        <div class="card">
          <div class="card-body">
            <h2 class="card-title"><%= m.getOriginal_title() %></h2>
            <%--<p class="card-text"><%= m.getOverview() %></p>--%>
              <img class="img-fluid rounded" src="<%= poster_prefix %><%= m.getBackdrop_path() %>" alt="" title="<%= m.getOverview() %>">
          </div>
          <div class="card-footer">
            <a href="#" class="btn btn-primary">More Info</a>
          </div>
        </div>
      </div>
      <% } %>
      <%--</c:forEach>--%>

    <!-- /.col-md-4 -->
  </div>
  <!-- /.row -->

</div>
<!-- /.container -->

<jsp:include page="footer.jsp"/>