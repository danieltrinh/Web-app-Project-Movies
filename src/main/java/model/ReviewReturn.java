package model;

public class ReviewReturn extends Review{
    public ReviewReturn(Integer id, Integer userId, Integer movieId, String detailReview, String shortReview, Integer rate, String username) {
        super(id, userId, movieId, detailReview, shortReview, rate);
        Username = username;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    private String Username;
}
