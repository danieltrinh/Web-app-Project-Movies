<%--
  Created by IntelliJ IDEA.
  User: Daniel
  Date: 9/24/2018
  Time: 12:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="header.jsp"/>
<!-- Page Content -->
<div class="container">

    <!-- Page Heading -->
    <h1 class="my-4">Search Movie
    </h1>

    <div id="searchBar">
        <input id="movieInput" type="text" name="Movie Name" placeholder="Movie Name">

        <input type="button" id="searchButton" name="searchButton" value="Search"/>
    </div>

    <div class="row" id="searchResult">

    </div>
    <!-- /.row -->

    <!-- Pagination -->
</div>
<!-- /.container -->
<jsp:include page="footer.jsp"/>