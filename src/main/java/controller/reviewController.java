package controller;

import dao.ReviewDao;
import dao.UserDao;
import model.Review;
import model.ReviewReturn;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
@WebServlet({"/review"})
public class reviewController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String headline = req.getParameter("headline");
        String detailReview = req.getParameter("newReview");
        String rating = req.getParameter("rating");
        String movieId = req.getParameter("movieId");
        ReviewDao reviewDb = new ReviewDao();
        UserDao userDb = new UserDao();
        Review newReview;
        newReview = reviewDb.createNewReview(new Review(0, (Integer) (session.getAttribute("userId")), Integer.parseInt(movieId) , detailReview, headline, Integer.parseInt(rating) ));
        List<ReviewReturn> newReviewList = new ArrayList<>();
        List<Review> currentReviewList;
        if (session.getAttribute("listReview") != null) {
            currentReviewList = (List<Review>) session.getAttribute("listReview");
            currentReviewList.add(newReview);
        } else
            currentReviewList = reviewDb.getReviewByMovie(Integer.parseInt(movieId));
        for (Review item: currentReviewList) {
            ReviewReturn value = new ReviewReturn(item.getId(),item.getUserId(),item.getMovieId(), item.getDetailReview(),item.getShortReview(),item.getRate(), userDb.getUserById(item.getUserId()).getFullname());
            newReviewList.add(value);
        }
        session.setAttribute("listReview", newReviewList);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
