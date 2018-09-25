<%--
  Created by IntelliJ IDEA.
  User: LinhNDG
  Date: 9/23/2018
  Time: 3:07 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.ReviewReturn" %>
<%@ page import="model.FromAPI.Movie" %>
<%@ page import="java.util.stream.Collectors" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<link href="https://fonts.googleapis.com/css?family=Abel" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="http://netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
<!------ Include the above in your HEAD tag ---------->

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="favicon.ico">

    <title>Fixed Top Navbar Example for Bootstrap</title>
    <script src="resources/js/review.js"></script>


    <link href="resources/css/review.css" rel="stylesheet">



    <![endif]-->
</head>

<body>

<!-- Fixed navbar -->
<%List<ReviewReturn> reviewReturnsList = (ArrayList<ReviewReturn>) request.getAttribute("listReview");%>
<% Movie m = (Movie) request.getAttribute("movie");
reviewReturnsList = reviewReturnsList.stream().filter(x -> x.getMovieId() == m.getId()).collect(Collectors.toList());
%>
<div class="container">

    <div class="row">
        <div class="col-sm-3">
            <div class="rating-block">
                <h4>Average user rating</h4>
                <h2 class="bold padding-bottom-7"><%= reviewReturnsList.stream().mapToInt(ReviewReturn::getRate).summaryStatistics().getAverage()%> <small>/ 5</small></h2>

            </div>
        </div>
        <div class="col-sm-3">
            <h4>Rating breakdown</h4>
            <div class="pull-left">
                <div class="pull-left" style="width:35px; line-height:1;">
                    <div style="height:9px; margin:5px 0;">5 <span class="glyphicon glyphicon-star"></span></div>
                </div>
                <div class="pull-left" style="width:180px;">
                    <div class="progress" style="height:9px; margin:8px 0;">
                        <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="5" aria-valuemin="0" aria-valuemax="5" style="width: <%= ((float) reviewReturnsList.stream().filter(x -> x.getRate() == 5).count() / reviewReturnsList.size())*100%>%">
                            <span class="sr-only">80% Complete (danger)</span>
                        </div>
                    </div>
                </div>
                <div class="pull-right" style="margin-left:10px;"><%= reviewReturnsList.stream().filter(x -> x.getRate() == 5).count() %></div>
            </div>
            <div class="pull-left">
                <div class="pull-left" style="width:35px; line-height:1;">
                    <div style="height:9px; margin:5px 0;">4 <span class="glyphicon glyphicon-star"></span></div>
                </div>
                <div class="pull-left" style="width:180px;">
                    <div class="progress" style="height:9px; margin:8px 0;">
                        <div class="progress-bar progress-bar-primary" role="progressbar" aria-valuenow="4" aria-valuemin="0" aria-valuemax="5" style="width: <%= ((float) reviewReturnsList.stream().filter(x -> x.getRate() == 4).count() / reviewReturnsList.size())*100%>%">
                            <span class="sr-only">80% Complete (danger)</span>
                        </div>
                    </div>
                </div>
                <div class="pull-right" style="margin-left:10px;"><%= reviewReturnsList.stream().filter(x -> x.getRate() == 4).count()%></div>
            </div>
            <div class="pull-left">
                <div class="pull-left" style="width:35px; line-height:1;">
                    <div style="height:9px; margin:5px 0;">3 <span class="glyphicon glyphicon-star"></span></div>
                </div>
                <div class="pull-left" style="width:180px;">
                    <div class="progress" style="height:9px; margin:8px 0;">
                        <div class="progress-bar progress-bar-info" role="progressbar" aria-valuenow="1" aria-valuemin="0" aria-valuemax="5" style="width: <%= ((float)reviewReturnsList.stream().filter(x -> x.getRate() == 3).count() / reviewReturnsList.size())*100%>%">
                            <span class="sr-only">80% Complete (danger)</span>
                        </div>
                    </div>
                </div>
                <div class="pull-right" style="margin-left:10px;"><%= reviewReturnsList.stream().filter(x -> x.getRate() == 3).count() %></div>
            </div>
            <div class="pull-left">
                <div class="pull-left" style="width:35px; line-height:1;">
                    <div style="height:9px; margin:5px 0;">2 <span class="glyphicon glyphicon-star"></span></div>
                </div>
                <div class="pull-left" style="width:180px;">
                    <div class="progress" style="height:9px; margin:8px 0;">
                        <div class="progress-bar progress-bar-warning" role="progressbar" aria-valuenow="2" aria-valuemin="0" aria-valuemax="5" style="width: <%= ((float)reviewReturnsList.stream().filter(x -> x.getRate() == 2).count() / reviewReturnsList.size())*100%>%">
                            <span class="sr-only">80% Complete (danger)</span>
                        </div>
                    </div>
                </div>
                <div class="pull-right" style="margin-left:10px;"><%= reviewReturnsList.stream().filter(x -> x.getRate() == 2).count() %></div>
            </div>
            <div class="pull-left">
                <div class="pull-left" style="width:35px; line-height:1;">
                    <div style="height:9px; margin:5px 0;">1 <span class="glyphicon glyphicon-star"></span></div>
                </div>
                <div class="pull-left" style="width:180px;">
                    <div class="progress" style="height:9px; margin:8px 0;">
                        <div class="progress-bar progress-bar-danger" role="progressbar" aria-valuenow="1" aria-valuemin="0" aria-valuemax="5" style="width: <%= ( (float)reviewReturnsList.stream().filter(x -> x.getRate() == 1).count() / reviewReturnsList.size())*100%>%">
                            <span class="sr-only">80% Complete (danger)</span>
                        </div>
                    </div>
                </div>
                <div class="pull-right" style="margin-left:10px;"><%= reviewReturnsList.stream().filter(x -> x.getRate() == 1).count() %></div>
            </div>
        </div>

    </div>
    <%
        for (ReviewReturn r: reviewReturnsList)
        {  %>
    <div class="row">
        <div class="col-sm-7">
            <hr/>
            <div class="review-block">
                <div class="row">
                    <div class="col-sm-3">
                        <img src="http://dummyimage.com/60x60/666/ffffff&text=No+Image" class="img-rounded">
                        <div class="review-block-name"><a href="#"><%= r.getUsername() %></a></div>
                    </div>
                    <div class="col-sm-9">
                        <div class="review-block-rate">
                            <% for(int i = 0; i < r.getRate(); i++) { %>
                            <button type="button" class="btn btn-warning btn-xs" aria-label="Left Align">
                                <span class="glyphicon glyphicon-star" aria-hidden="true"></span>
                            </button>
                            <% } %>
                            <% for(int i = 0; i < 5 - r.getRate(); i++) { %>
                            <button type="button" class="btn btn-default btn-grey btn-xs" aria-label="Left Align">
                                <span class="glyphicon glyphicon-star" aria-hidden="true"></span>
                            </button>
                            <% } %>

                        </div>
                        <div class="review-block-title"><%= r.getShortReview() %></div>
                        <div class="review-block-description"><%= r.getDetailReview() %></div>
                    </div>
                </div>
                <hr/>


            </div>
        </div>
    </div>
    <%}%>
    <div class="row" id="post-review-box">
        <div class="col-md-12">
            <form accept-charset="UTF-8" action="" method="post">
                <div class="form-group">
                    <label class="col-md-3 control-label" >Your rating</label>
                    <fieldset class="rating-star pl-5 pb-5">
                        <input type="radio" id="star5" name="rating" value="5" /><label class = "full" for="star5" title="Awesome - 5 stars"></label>
                        <input type="radio" id="star4" name="rating" value="4" /><label class = "full" for="star4" title="Pretty good - 4 stars"></label>
                        <input type="radio" id="star3" name="rating" value="3" /><label class = "full" for="star3" title="Meh - 3 stars"></label>
                        <input type="radio" id="star2" name="rating" value="2" /><label class = "full" for="star2" title="Kinda bad - 2 stars"></label>
                        <input type="radio" id="star1" name="rating" value="1" /><label class = "full" for="star1" title="Sucks big time - 1 star"></label>
                    </fieldset>
                </div>
                <div>
                    <input id="headlineReview" name="headlineReview" type="text" size="100" placeholder="Input your headline review">
                    </br>
                </div>
                <input id="ratings-hidden" name="rating" type="hidden">
                <textarea class="form-control animated" cols="20" id="new-review" name="new-review" placeholder="Enter your review here..." rows="7"></textarea>

                <div class="text-left">

                    <button id="save-button" class="btn btn-success btn-lg" type="submit">Save</button>
                </div>
            </form>
        </div>
    </div>
</div> <!-- /container -->


</body>
</html>
