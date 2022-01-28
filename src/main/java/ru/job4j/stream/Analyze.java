package ru.job4j.stream;

import java.security.Key;
import java.util.*;
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
                .map(pupil -> new Tuple(
                        pupil.getName(),
                        pupil.getSubjects()
                        .stream()
                        .mapToInt(Subject::getScore)
                        .average()
                        .orElse(0D)
                )
        )
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

    public static Tuple bestPupil(List<Pupil> list) {
        Map<String, List<Subject>> map = new LinkedHashMap<>();
        for (Pupil pupil : list) {
            map.put(pupil.getName(), pupil.getSubjects());
            List<Tuple> tupleList = new ArrayList<>();
            for (Subject subject : pupil.getSubjects()) {
                for (Tuple tuple : tupleList) {
                    tuple.setName(subject.getName());
                    tuple.setScore(subject.getScore());
                    tuple.setScore(tuple.getValue());
                    Math.max(this.getValue(), tuple.getValue());
                }
            }
        }
    }

    public static Tuple bestSubject(Stream<Pupil> stream) {

}
