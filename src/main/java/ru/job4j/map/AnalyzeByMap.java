package ru.job4j.map;

import java.util.List;

public class AnalyzeByMap {

    public static double averageScore(List<Pupil> pupils) {
        int sum = 0;
        int a = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.getSubjects()) {
                sum += subject.getScore();
                a++;
            }
        }
        return (double) sum / a;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        List<Label> list = new ArrayList<>();
        int sum = 0;
        int a = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.getSubjects()) {
                sum += subject.getScore();
                a++;
                Label label = new Label(pupil.getName(), (double) (sum / a));
                list.add(label);
            }
        }
        return list;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        return List.of();
    }

    public static Label bestStudent(List<Pupil> pupils) {
        int sum = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.getSubjects()) {
                sum += subject.getScore();
                
                Label label = new Label(pupil.getName(), (double) (sum / a));
                list.add(label);
            }
        }
        return label;
    }

    public static Label bestSubject(List<Pupil> pupils) {
        return null;
    }
}
