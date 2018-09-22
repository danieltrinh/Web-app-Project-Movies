package domain;

public class UserMovie {
  private Integer UserId;
  private Integer MovieId;
  private Integer Status;

    public Integer getUserId() {
        return UserId;
    }

    public void setUserId(Integer userId) {
        UserId = userId;
    }

    public Integer getMovieId() {
        return MovieId;
    }

    public void setMovieId(Integer movieId) {
        MovieId = movieId;
    }

    public Integer getStatus() {
        return Status;
    }

    public void setStatus(Integer status) {
        Status = status;
    }

    public UserMovie(Integer userId, Integer movieId, Integer status) {
        UserId = userId;
        MovieId = movieId;
        Status = status;
    }
}
