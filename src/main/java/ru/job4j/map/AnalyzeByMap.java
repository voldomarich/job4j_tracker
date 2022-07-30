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
        double scorePupil = 0D;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.getSubjects()) {
                scorePupil += subject.getScore();
                Label label = new Label(pupil.getName(),
                        scorePupil / pupil.getSubjects().size());
                result.add(label);
            }
        }
        return result;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        List<Label> result = new ArrayList<>();
        Map<String, Double> map = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.getSubjects()) {
                map.put(subject.getName(), (double) subject.getScore());
                map.merge(subject.getName(), (double) subject.getScore(), Double::sum);
                Label label = new Label(subject.getName(), map.get(subject.getName()) / map.size());
                result.add(label);
                }
            }
        return result;
    }

    public static Label bestSubject(List<Pupil> pupils) {
        Label result = null;
        List<Label> list = new ArrayList<>();
        Map<String, Double> map = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.getSubjects()) {
                map.put(subject.getName(), (double) subject.getScore());
                map.merge(subject.getName(), (double) subject.getScore(), Double::sum);
                Label label = new Label(subject.getName(), map.get(subject.getName()));
                list.add(label);
                list.sort(Comparator.naturalOrder());
                result = list.get(list.size() - 1);
            }
        }
        return result;
    }

    public static Label bestPupil(List<Pupil> pupils) {
        Label result = null;
        List<Label> list = new ArrayList<>();
        double scorePupil = 0D;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.getSubjects()) {
                scorePupil += subject.getScore();
                Label label = new Label(pupil.getName(), scorePupil);
                list.add(label);
                list.sort(Comparator.naturalOrder());
                result = list.get(list.size() - 1);
            }
        }
        return result;
    }
}
