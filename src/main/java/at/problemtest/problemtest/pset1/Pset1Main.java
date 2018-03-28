package at.problemtest.problemtest.pset1;


import at.problemtest.problemtest.pset1.controller.MovieDatabaseSummarizer;
import at.problemtest.problemtest.pset1.model.Actor;
import at.problemtest.problemtest.pset1.model.Movie;
import at.problemtest.problemtest.pset1.model.Summary;
import at.problemtest.problemtest.pset1.parser.ActorParser;
import at.problemtest.problemtest.pset1.parser.MovieParser;
import at.problemtest.problemtest.pset1.view.SummaryDisplayer;

import java.util.List;

public class Pset1Main {

    public static void main(String[] args) {
        MovieParser parserMovie = new MovieParser();
        ActorParser parserActor = new ActorParser();

        List<Movie> movies = parserMovie.getMovies();
        List<Actor> actors = parserActor.getActors();

        MovieDatabaseSummarizer summarizerMovie = new MovieDatabaseSummarizer();
        MovieDatabaseSummarizer summarizerActor = new MovieDatabaseSummarizer();

        SummaryDisplayer displayerMovie = new SummaryDisplayer();
        SummaryDisplayer displayerActor = new SummaryDisplayer();

        Summary summaryMovie = summarizerMovie.summarizeMovie(movies);
        Summary summaryActor = summarizerActor.summarizeActor(actors);
        displayerMovie.displayMovie(summaryMovie);
        displayerActor.displayActor(summaryActor);


    }
}
