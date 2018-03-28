package at.problemtest.problemtest.pset1.controller;



import at.problemtest.problemtest.pset1.model.Actor;
import at.problemtest.problemtest.pset1.model.Movie;
import at.problemtest.problemtest.pset1.model.Summary;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MovieDatabaseSummarizer {

        public Summary summarizeMovie(List<Movie> movies) {

            // the 3 most rated recipies
            List<String> topRatedMovies = movies.stream()
                    .sorted((e1, e2) -> e2.getVoteAverage().compareTo(e1.getVoteAverage()))
                    .limit(5)
                    .map(e -> e.getTitle() + " (" + e.getVoteAverage() + ")")
                    .collect(Collectors.toList());

            // 2 feedback words that were used the most
            Map<String, Long> appearances = movies.stream()
                    .map(movie -> movie.getAppearingMovieGenres())
                    .flatMap(geners -> geners.stream())
                    .collect(Collectors.groupingBy(e -> e, Collectors.counting()));


            List<String> topMoviesGeners = appearances.entrySet().stream()
                    .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                    .limit(3)
                    .skip(1)
                    .map(e -> e.getKey() + " " +"("+ e.getValue()+")")
                    .collect(Collectors.toList());


            Summary summary = new Summary();
            summary.setTopRatedMovies(topRatedMovies);
            summary.setTopMoviesGeners(topMoviesGeners);

            return summary;
        }
        public Summary summarizeActor(List<Actor> actors) {

            // 2 feedback words that were used the most
            Map<String, Long> appearances = actors.stream()
                    .map(actor -> actor.getActotName())
                    .map(actor ->actor.split(","))
                    .flatMap(hierd -> Arrays.stream(hierd))
                    .collect(Collectors.groupingBy(e -> e, Collectors.counting()));


            List<String> mostHiredActor = appearances.entrySet().stream()
                    /*.filter(name -> !name.getKey().contains("0"))
                    .filter(name -> !name.getKey().contains("1"))
                    .filter(name -> !name.getKey().contains("2"))
                    .filter(name -> !name.getKey().contains("3"))
                    .filter(name -> !name.getKey().contains("4"))
                    .filter(name -> !name.getKey().contains("5"))
                    .filter(name -> !name.getKey().contains("6"))
                    .filter(name -> !name.getKey().contains("7"))
                    .filter(name -> !name.getKey().contains("8"))
                    .filter(name -> !name.getKey().contains("9"))
                    .filter(name -> !name.getKey().contains("'"))
                    .filter(name -> !name.getKey().contains(")"))
                    .filter(name -> !name.getKey().contains("("))
                    .filter(name -> !name.getKey().contains("/"))
                    .filter(name -> !name.getKey().contains("\""))*/

                    //.peek(name-> System.out.println(name.getKey()))

                    .filter(name -> name.getKey().contains(" "))
                    .filter(name -> name.getKey() != null && name.getValue() != null)
                    .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                    //.skip(1)
                    .limit(5)
                    .map(e -> e.getKey() + " " +"("+ e.getValue()+")")
                    .collect(Collectors.toList());

            // the 3 most rated recipies
            Map<String, Long> ratio = actors.stream()
                    .map(actor -> actor.getActorsMaleFemaleRatio())
                    .flatMap(genders -> genders.stream())
                    .collect(Collectors.groupingBy(e -> e, Collectors.counting()));


            List<String> ActorsMaleFemaleRatio = ratio.entrySet().stream()
                    //.sorted()
                    .map(e -> toGender(e) + " " +"("+ toRatio(e) +")")
                    .collect(Collectors.toList());



            Summary summaryy = new Summary();
            summaryy.setTopMostHiredActors(mostHiredActor);
            summaryy.setNumberActorsMaleFemaleRatio(ActorsMaleFemaleRatio);

            return summaryy;
        }

        private String toRatio(Map.Entry<String, Long> e) {
            double ratioValue = e.getValue();
            String key = e.getKey();
            if (key.equals("1")){
                return String.valueOf((ratioValue /150105) * 100+" %");
            }
            return String.valueOf((ratioValue /150105) * 100 +" %");

        }

        private String toGender(Map.Entry<String, Long> e) {
            String key = e.getKey();
            if (key.equals("1")){
                return "Male";
            }
            return "Female";
        }

    }


