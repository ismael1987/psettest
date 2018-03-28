package at.problemtest.problemtest.pset1.model;


import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Summary {
    private List<String> topRatedMovies;

    private List<String> topMoviesGeners;

    private List<String> topMostHiredActors;

    private List<String> numberActorsMaleFemaleRatio;

    public void setTopRatedMovies(List<String> topRatedMovies) {
        this.topRatedMovies = topRatedMovies;
    }

    public void setTopMoviesGeners(List<String> topMoviesGeners) {
        this.topMoviesGeners = topMoviesGeners;
    }

    public List<String> getTopRatedMovies() {
        return topRatedMovies;
    }

    public List<String> getTopMoviesGeners() {
        return topMoviesGeners;
    }

    public void setTopMostHiredActors(List<String> topMostHiredActors) {
        this.topMostHiredActors = topMostHiredActors;
    }

    public void setNumberActorsMaleFemaleRatio(List<String> numberActorsMaleFemaleRatio) {
        this.numberActorsMaleFemaleRatio = numberActorsMaleFemaleRatio;
    }

    public List<String> getTopMostHiredActors() {

        return topMostHiredActors;
    }

    public List<String> getNumberActorsMaleFemaleRatio() {
        return numberActorsMaleFemaleRatio;
    }
}
