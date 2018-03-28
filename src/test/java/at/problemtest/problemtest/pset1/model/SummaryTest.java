package at.problemtest.problemtest.pset1.model;


import at.problemtest.problemtest.pset1.controller.MovieDatabaseSummarizer;
import at.problemtest.problemtest.pset1.parser.ActorParser;
import at.problemtest.problemtest.pset1.parser.MovieParser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SummaryTest {
    MovieParser parserMovie = new MovieParser();
    ActorParser parserActor = new ActorParser();

    List<Movie> movies = parserMovie.getMovies();
    List<Actor> actors = parserActor.getActors();

    MovieDatabaseSummarizer summarizerMovie = new MovieDatabaseSummarizer();
    MovieDatabaseSummarizer summarizerActor = new MovieDatabaseSummarizer();


    Summary summaryMovie = summarizerMovie.summarizeMovie(movies);
    Summary summaryActor = summarizerActor.summarizeActor(actors);


    @Test
    public void getTopRatedMovies()  {

        List<String> topRatedMovies = summaryMovie.getTopRatedMovies();
        assertEquals(Arrays.asList("Reckless (10.0)",
                "Girl in the Cadillac (10.0)",
                "The Haunted World of Edward D. Wood, Jr. (10.0)",
                "Carmen Miranda: Bananas Is My Business (10.0)",
                "Other Voices Other Rooms (10.0)"),topRatedMovies);


    }

    @Test
    public void getTopMoviesGeners() {
        List<String> topMoviesGeners = summaryMovie.getTopMoviesGeners();
        assertEquals(Arrays.asList("Drama (14495)","Comedy (8955)"),topMoviesGeners);




    }

    @Test
    public void getTopMostHiredActors()  {
        List<String> topMostHiredActors = summaryActor.getTopMostHiredActors();
        assertEquals(Arrays.asList("Bess Flowers (82)","Christopher Lee (69)"
                ,"Grey Griffin (58)","Danny Trejo (54)","Eric Roberts (52)"),topMostHiredActors);

    }

    @Test
    public void getNumberActorsMaleFemaleRatio()  {
        List<String> numberActorsMaleFemaleRatio = summaryActor.getNumberActorsMaleFemaleRatio();
        assertEquals(Arrays.asList("Male (34.271343392958265 %)", "Female (65.72865660704174 %)"),numberActorsMaleFemaleRatio);

    }

   

}