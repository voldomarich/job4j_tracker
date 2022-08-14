package ru.job4j.stream;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class AnalyzeTest {

    @Test
    public void whenSinglePupil() {
        double average = Analyze.averageScore(
                List.of(
                        new Pupil("Ivanov", List.of(new Subject("Math", 100)))
                ).stream()
        );
        assertThat(average).isEqualTo(100D);
    }

    @Test
    public void whenPupilAverage() {
        double average = Analyze.averageScore(
                List.of(
                        new Pupil("Ivanov", List.of(new Subject("Math", 100))),
                        new Pupil("Petrov", List.of(new Subject("Math", 60)))
                ).stream()
        );
        assertThat(average).isEqualTo(80D);
    }

    @Test
    public void whenPupil() {
        double average = Analyze.averageScore(
                List.of(
                        new Pupil("Ivanov",
                                List.of(
                                        new Subject("Math", 100),
                                        new Subject("Lang", 80),
                                        new Subject("Philosophy", 80)
                                )
                        ),
                        new Pupil("Petrov",
                                List.of(
                                        new Subject("Math", 90),
                                        new Subject("Lang", 100)
                                )
                        )
                ).stream()
        );
        assertThat(average).isEqualTo(90D);
    }

    @Test
    public void whenListOfPupilAverage() {
        List<Tuple> average = Analyze.averageScoreByPupil(
                List.of(
                        new Pupil("Ivanov", List.of(new Subject("Math", 100),
                                new Subject("Lang", 100))),
                        new Pupil("Petrov", List.of(new Subject("Math", 60),
                                new Subject("Lang", 60)))
                ).stream()
        );
        assertThat(average).isEqualTo(List.of(
                new Tuple("Ivanov", 100D),
                new Tuple("Petrov", 60D)
        ));
    }

    @Test
    public void whenAnotherListOfSubjectAverage() {
        List<Tuple> average = Analyze.averageScoreBySubject(
                List.of(
                        new Pupil("Ivanov",
                                List.of(
                                        new Subject("Math", 100),
                                        new Subject("Lang", 100),
                                        new Subject("Philosophy", 100)
                                )
                        ),
                        new Pupil("Petrov",
                                List.of(
                                        new Subject("Math", 60),
                                        new Subject("Lang", 60),
                                        new Subject("Philosophy", 60)
                                )
                        ),
                        new Pupil("Safronov",
                                List.of(
                                        new Subject("Lang", 89),
                                        new Subject("Philosophy", 86)
                                )
                        )
                ).stream()
        );
        assertThat(average).hasSameElementsAs(List.of(
                new Tuple("Math", 80D),
                new Tuple("Lang", 83D),
                new Tuple("Philosophy", 82D)
        ));
    }

    @Test
    public void whenListOfSubjectAverage() {
        List<Tuple> average = Analyze.averageScoreBySubject(
                List.of(
                        new Pupil("Ivanov",
                                List.of(
                                        new Subject("Math", 100),
                                        new Subject("Lang", 100),
                                        new Subject("Philosophy", 100)
                                )
                        ),
                        new Pupil("Petrov",
                                List.of(
                                        new Subject("Math", 60),
                                        new Subject("Lang", 60),
                                        new Subject("Philosophy", 60)
                                )
                        )
                ).stream()
        );
        assertThat(average).isEqualTo(List.of(
                new Tuple("Math", 80D),
                new Tuple("Lang", 80D),
                new Tuple("Philosophy", 80D)
        ));
    }

    @Test
    public void whenBestSubject() {
        Tuple best = Analyze.bestSubject(
                List.of(
                        new Pupil("Ivanov", List.of(new Subject("Math", 100),
                                new Subject("Lang", 40))),
                        new Pupil("Petrov", List.of(new Subject("Math", 60),
                                new Subject("Lang", 60)))
                ).stream()
        );
        assertThat(best).isEqualTo(new Tuple("Math", 160D));
    }

    @Test
    public void whenBestPupil() {
        Tuple best = Analyze.bestPupil(
                List.of(
                        new Pupil("Ivanov", List.of(new Subject("Math", 100),
                                new Subject("Lang", 100))),
                        new Pupil("Petrov", List.of(new Subject("Math", 60),
                                new Subject("Lang", 60)))
                ).stream()
        );
        assertThat(best).isEqualTo(new Tuple("Ivanov", 200D));
    }

    @Test
    public void whenAnotherBestPupil() {
        Tuple best = Analyze.bestPupil(
                List.of(
                        new Pupil("Ivanov", List.of(new Subject("Math", 100),
                                new Subject("Lang", 80))),
                        new Pupil("Petrov", List.of(new Subject("Math", 80),
                                new Subject("Lang", 80))),
                        new Pupil("Novikov", List.of(new Subject("Math", 90),
                                new Subject("Lang", 100)))
                ).stream()
        );
        assertThat(best).isEqualTo(new Tuple("Novikov", 190D));
    }
}
