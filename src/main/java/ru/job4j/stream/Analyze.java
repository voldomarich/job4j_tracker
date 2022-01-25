package ru.job4j.stream;

import java.security.Key;
import java.util.LinkedHashMap;
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
                .flatMap(Tuple::getValue)
                .mapToDouble(Subject::getScore)
                .average()
                .collect(Collectors.toList());
    }

    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
        return stream
                .flatMap(e -> e.getSubjects().stream())
                .collect(Collectors.groupingBy(Subject::getName, LinkedHashMap::new,
                        Collectors.averagingDouble(Subject::getScore)))
                .entrySet().stream()
                .map(e -> new Tuple(e.getKey(), e.getValue()))
                .collect(Collectors.toList());
    }

    public static Tuple bestPupil(Stream<Pupil> stream) {
        return stream
                .flatMap(e -> e.getSubjects().stream())
                .collect(Collectors.groupingBy(Subject::getName, LinkedHashMap::new,
                        Collectors.summingDouble(Subject::getScore)))
                .entrySet().stream()
                .map(e -> new Tuple(e.getKey(), e.getValue()))
                .max(Collectors.toList())
                .orElse(0D);
    }

    public static Tuple bestSubject(Stream<Pupil> stream) {
        return stream
                .map(Tuple::new)
                .flatMap(Tuple::getValue)
                .mapToInt(Subject::getScore)
                .sum()
                .max(Collectors.toList())
                .orElse(null);

    }
}
