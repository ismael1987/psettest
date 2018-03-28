package at.problemtest.problemtest.pset1.parser;


import at.problemtest.problemtest.pset1.model.Actor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ActorParser {
    public List<Actor> getActors() {
        String filePath = "src/main/java/at/problemtest/problemtest/pset1/data/actors.csv";
        try {
            Stream<String> lines = Files.lines(Paths.get(filePath));
            return lines.skip(1)
                    .map(line -> line.split(";"))
                    .filter(column -> column.length == 3)
                    .filter(field -> field != null)
                    .map(toActor())
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    private Function<String[], Actor> toActor() {
        return columns -> {
            Actor actor = new Actor();
            actor.setActotName(toRealActor(columns[0]));
            actor.setActorsMaleFemaleRatio(toGender(columns[0]));
            return actor;
        };
    }

    private String toRealActor(String column) {
        String objects = column.replaceAll("\\[", "").replaceAll("]", "");
        objects = objects.replaceAll("\\{", "").replaceAll("}", "");
        objects = objects.replaceAll("'", "");

        String[] words = objects.split(", ");
      //  Arrays.stream(words).forEach(word -> System.out.println(word));
        return Stream.of(words)
                //.filter(word -> !word.("character:"))
                .filter(word -> word.contains("name:"))
                //.map(word->word.replaceAll("name:",""))
                //.peek(word-> System.out.println(word))

                .map(word -> word.split(": "))
                //.filter(word -> word != null)
             //   .filter(line -> line.length == 2 )
                .map(word -> word[1])
                .collect(Collectors.joining(","));

    }
    private List<String> toGender(String column) {
        String objects = column.replaceAll("\\[", "").replaceAll("]", "");
        objects = objects.replaceAll("\\{", "").replaceAll("}", "");
        objects = objects.replaceAll("'", "");

        String[] words = objects.split(", ");
        return Stream.of(words)
                .filter(word -> word.contains("gender:"))
                .map(word -> word.split(": "))
                .filter(word -> !word[1].contains("0"))
                //.peek(word -> System.out.println(word[1]))
                .filter(word -> word != null)
                .filter(line -> line.length == 2 )
                .map(word -> word[1])
                //.peek(s -> System.out.println(s +" hooon"))
                .collect(Collectors.toList());

    }
}
