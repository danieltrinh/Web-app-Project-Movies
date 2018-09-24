package model;

public class UserMovie {
    private Integer movieId;
    private Integer status;

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
