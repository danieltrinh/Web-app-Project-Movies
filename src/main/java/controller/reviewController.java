package controller;

import dao.ReviewDao;
import model.Review;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class reviewController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String headline = req.getParameter("headline");
        String detailReview = req.getParameter("detailReview");
        String rating = req.getParameter("rating");
        String movieId = req.getParameter("movieId");
        ReviewDao reviewDb = new ReviewDao();
        Review newReview;
        newReview = reviewDb.createNewReview(new Review(0, (Integer) (session.getAttribute("User")), Integer.parseInt(movieId) , detailReview, headline, Integer.parseInt(rating) ));
        String objectToReturn = "{ key1: '', key2: 'value2' }";

    }
}
