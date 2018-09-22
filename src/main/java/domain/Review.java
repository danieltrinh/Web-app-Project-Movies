package domain;

public class Review {
    private Integer id;
    private Integer userId;
    private Integer movieId;
    private String detailReview;
    private String shortReview;
    private Integer rate;

    public Review(Integer id, Integer userId, Integer movieId, String detailReview, String shortReview, Integer rate) {
        this.id = id;
        this.userId = userId;
        this.movieId = movieId;
        this.detailReview = detailReview;
        this.shortReview = shortReview;
        this.rate = rate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    public String getDetailReview() {
        return detailReview;
    }

    public void setDetailReview(String detailReview) {
        this.detailReview = detailReview;
    }

    public String getShortReview() {
        return shortReview;
    }

    public void setShortReview(String shortReview) {
        this.shortReview = shortReview;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }
}
