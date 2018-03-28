package at.problemtest.problemtest.pset1.view;


import at.problemtest.problemtest.pset1.model.Summary;

public class SummaryDisplayer {
    public void displayMovie(Summary summary) {

        // display 3 most rated recipies
        System.out.println("Most rated films: ");
        summary.getTopRatedMovies()
                .forEach(movie -> System.out.println(movie));

        System.out.println(" ------ ");

        // display the most feedback appearing word
        System.out.println("Most appearing movie genres: ");
        summary.getTopMoviesGeners()
                .forEach(word -> System.out.println(word));

    }
    public void displayActor(Summary summaryy) {

        // display 3 most rated recipies
        System.out.println(" ------ ");
        System.out.println("Most hired actors: ");
        summaryy.getTopMostHiredActors()
                .forEach(actor -> System.out.println(actor));
        //System.out.println("jjj");

        System.out.println(" ------ ");

        // display 3 most rated recipies
        System.out.println("Actors male-female ratio: ");
        summaryy.getNumberActorsMaleFemaleRatio()
                .forEach(wordd -> System.out.println(wordd));
        //System.out.println("dd FEMALE (64.06596302986145%) MALE (35.93403398990631%) dd");
        System.out.println(" ------ ");

    }
}
