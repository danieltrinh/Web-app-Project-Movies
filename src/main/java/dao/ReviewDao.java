package dao;

import model.Review;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ReviewDao {
    private Map<Integer, Review> reviewDb = new HashMap<>();
    {
        reviewDb.put(1, new Review(1,1,1, "I love this movie so much", "Good movie", 4));
        reviewDb.put(2, new Review(2,2,1, "I hate this movie so much", "Bad movie", 2));
    }
    public List<Review> getReviewByMovie(Integer movieId){
        return reviewDb.entrySet().stream()
                .filter(p -> p.getValue().getMovieId() == movieId)
                .map(p -> p.getValue()).collect(Collectors.toList());
    }
    public List<Review> getReviewByUser(Integer userId){
        return reviewDb.entrySet().stream()
                .filter(p -> p.getValue().getUserId() == userId)
                .map(p -> p.getValue()).collect(Collectors.toList());
    }
    public Review createNewReview(Review review){
        review.setId(getMaxID() + 1);
        reviewDb.put(getMaxID() + 1, review);
        return review;
    }
    public List<Review> getReviewsDB(){
        return new ArrayList<Review>(reviewDb.values());
    }
    public int getMaxID(){
        return reviewDb.entrySet().stream().max((entry1, entry2) -> entry1.getKey() > entry2.getKey() ? 1 : -1).get().getKey();
    }
}
