package ru.job4j.stream;

import javax.lang.model.element.Name;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Analyze {

    public static double averageScore(Stream<Pupil> stream) {
        return stream
                .flatMap(e -> e.getSubjects().stream())
                .mapToInt(Subject::getScore)
                .average()
                .orElse(0D);
    }

    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {
        return stream
                .map(Tuple::new)
                .flatMap(e -> e.getName())
                .mapToDouble(Tuple::getScore)
                .average()
                .collect(Collectors.toList());
    }

    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
        return stream
                .flatMap(e -> e.getSubjects().stream())
                .collect(Collectors.groupingBy(Pupil::getName,
                        Collectors.averagingDouble(Name::getSubjects))
                .entrySet().stream()
                .map(e -> new Tuple(e))
                .collect(Collectors.toList());
    }

    public static List<Tuple> bestPupil(Stream<Pupil> stream) {
        return stream
                .flatMap(e -> e.getSubjects().stream())
                .collect(Collectors.groupingBy(Pupil::getName,
                        Collectors.summingDouble(Name::getSubjects)
                .entrySet().stream()
                .map(e -> new Tuple(e))
                .max(Collectors.toList())
                .orElse(0D);
    }

    public static List<Tuple> bestSubject(Stream<Pupil> stream) {
        return stream
                .map(Tuple::new)
                .flatMap(e -> e.getName())
                .mapToInt(Tuple::getScore)
                .sum()
                .max(Collectors.toList())
                .orElse(null);

    }
}
