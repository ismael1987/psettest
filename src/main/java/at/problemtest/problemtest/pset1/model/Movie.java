package at.problemtest.problemtest.pset1.model;

import java.util.List;

public class Movie {
 private String title;
 private Double voteAverage;
 private List<String> appearingMovieGenres;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setVoteAverage(Double voteAverage) {
        this.voteAverage = voteAverage;
    }

    public void setAppearingMovieGenres(List<String> appearingMovieGenres) {
        this.appearingMovieGenres = appearingMovieGenres;
    }

    public String getTitle() {

        return title;
    }

    public Double getVoteAverage() {
        return voteAverage;
    }

    public List<String> getAppearingMovieGenres() {
        return appearingMovieGenres;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", voteAverage=" + voteAverage +
                ", appearingMovieGenres=" + appearingMovieGenres +
                '}';
    }
}
