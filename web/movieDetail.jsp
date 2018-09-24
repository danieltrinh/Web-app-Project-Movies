<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.FromAPI.Genre" %>
<%@ page import="model.FromAPI.Movie" %>
<%@ page import="java.util.List" %>
<%@ page import="model.UserMovie" %><%--
  Created by IntelliJ IDEA.
  User: Daniel
  Date: 9/24/2018
  Time: 12:01 AM
  To change this template use File | Settings | File Templates.
--%>
<jsp:include page="header.jsp"/>

<div class="container">

    <div class="row">

        <div class="col-md-8">
            <img id="moviePic" class="img-fluid" src="https://image.tmdb.org/t/p/w500/${movie.poster_path} " alt="">
        </div>
        <% Movie m = (Movie) request.getAttribute("movie"); %>

        <div class="col-md-4 movie_description">
            <h1 class="my-3 movieTitle title"> ${movie.original_title}
                </h1>
                    <p><strong>
                        <% Integer watchList = (Integer) request.getAttribute("watchList"); %>
                        <% if (watchList != null) {
                            if (watchList == 1) {
                        %>
                            In WatchList
                        <% } else {%>
                            Add to WatchList
                        <% }
                        }  %></strong>
                    </p>

                    <p id="movieDescription">${movie.overview}</p>
                    <h3 class="my-3 movieGenre title">Genre</h3>
                    <ul>
                        <c:forEach items="${movie.genres}" var="genre">
                            <li class="genre" data-genre-id="${genre.id}"> ${genre.name} </li>
                        </c:forEach>
                    </ul>
        </div>

    </div>
    <!-- /.row -->

    <div class="row">
        <div class="col-lg-12">
            <h2 class="my-4 title">Cast</h2>
        </div>
        <c:forEach items="${casts}" var="cast" begin="1" end="6">
            <div class="col-lg-4 col-sm-6 text-center mb-4">
                <img id="cast0img" class="rounded-circle img-fluid d-block mx-auto"
                     src="https://image.tmdb.org/t/p/w500/${cast.profile_path}" alt="">
                <h3 id="cast0Name">${cast.name}</h3>
                <h4 id="cast0Title">${cast.character}</h4>
            </div>
        </c:forEach>
    </div>

    <!-- Related Projects Row -->
    <h3 class="my-4 title">Simlar Movies</h3>

    <div class="row">
        <c:forEach items="${similar_movies}" var="similar_mov" begin="1" end="8">
            <div class="col-md-3 col-sm-6 mb-4">
                <a href="/movie?id=${similar_mov.id}">
                    <img id="simlar1" class="img-fluid" src="https://image.tmdb.org/t/p/w500/${similar_mov.poster_path}"
                         alt="" title="E${similar_mov.overview}" dataid="26390">
                </a>
                <p id="name1" class="similar_name">${similar_mov.original_title}</p>
            </div>
        </c:forEach>
    </div>
    <!-- /.row -->

</div>
<input type="hidden" id="movieId" name="movieId" value="<%= m.getId() %>">
<%--<jsp:include page="review.jsp"/>--%>

<jsp:include page="footer.jsp"/>
