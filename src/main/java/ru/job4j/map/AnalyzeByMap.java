package ru.job4j.map;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        double result = 0D;
        int sum = 0;
        int a = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.getSubjects()) {
                sum += subject.getScore();
                a++;
                result = (double) sum / a;
            }
        }
        return result;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> result = new ArrayList<>();
        for (Pupil pupil : pupils) {
            double scorePupil = 0D;
            for (Subject subject : pupil.getSubjects()) {
                scorePupil += subject.getScore();
            }
            Label label = new Label(pupil.getName(),
                    scorePupil / pupil.getSubjects().size());
            result.add(label);
        }
        return result;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        List<Label> result = new ArrayList<>();
        Map<String, Double> map = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.getSubjects()) {
                map.merge(subject.getName(), (double) subject.getScore(), Double::sum);
            }
        }
        for (String key : map.keySet()) {
            Label label = new Label(key, map.get(key) / pupils.size());
            result.add(label);
        }
        return result;
    }

    public static Label bestSubject(List<Pupil> pupils) {
        List<Label> result = new ArrayList<>();
        Map<String, Double> map = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.getSubjects()) {
                map.merge(subject.getName(), (double) subject.getScore(), Double::sum);
            }
        }
        for (String key : map.keySet()) {
            Label label = new Label(key, map.get(key));
            result.add(label);
        }
        result.sort(Comparator.naturalOrder());
        return result.get(result.size() - 1);
    }

    public static Label bestPupil(List<Pupil> pupils) {
        List<Label> result = new ArrayList<>();
        for (Pupil pupil : pupils) {
            double scorePupil = 0D;
            for (Subject subject : pupil.getSubjects()) {
                scorePupil += subject.getScore();
            }
            Label label = new Label(pupil.getName(), scorePupil);
            result.add(label);
        }
        result.sort(Comparator.naturalOrder());
        return result.get(result.size() - 1);
    }
}
