package model;

public class UserMovie {
    private Integer movieId;
    private Integer status;

    public static final int WILL_WATCH = 0;
    public static final int WATCHED = 0;

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public UserMovie(Integer movieId, Integer status) {
        this.movieId = movieId;
        this.status = status;
    }

    @Override
    public String toString() {
        return "UserMovie{" +
                "movieId=" + movieId +
                ", status=" + status +
                '}';
    }

}
