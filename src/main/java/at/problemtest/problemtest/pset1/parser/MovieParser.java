package at.problemtest.problemtest.pset1.parser;


import at.problemtest.problemtest.pset1.model.Movie;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MovieParser {
    public List<Movie> getMovies() {
        String filePath = "src/main/java/at/problemtest/problemtest/pset1/data/movies.csv";
        try {
            Stream<String> lines = Files.lines(Paths.get(filePath));
            return lines.skip(1)
                    .map(line -> line.split(";"))
                    .filter(column -> column.length == 24)
                    .filter(field -> field != null)
                    .map(toMovie())
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    private Function<String[], Movie> toMovie() {
        return columns -> {
            Movie movie = new Movie();
            movie.setTitle(columns[20]);
            movie.setVoteAverage(Double.parseDouble(columns[22]));
            movie.setAppearingMovieGenres(toRealMovie(columns[3]));
            return movie;
        };
    }

    private List<String> toRealMovie(String column) {
        String objects = column.replaceAll("\\[", "").replaceAll("]", "");
        objects = objects.replaceAll("\\{", "").replaceAll("}", "");
        objects = objects.replaceAll("'", "");

        String[] words = objects.split(", ");
        return Stream.of(words)
                .map(word -> word.split(": "))
                .filter(word -> word != null)
                .filter(word -> word.length == 2)
                .map(word -> word[1])
                .collect(Collectors.toList());

    }
}
