package ru.job4j.collection;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class JobSorterTest {

    @Test
    public void whenComparatorDescByName() {
        Comparator<Job> cmpNamePriority = new JobDescByName();
        int rsl = cmpNamePriority.compare(
                new Job("Ampl task", 1),
                new Job("Fix bug", 2)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenComparatorAscByName() {
        Comparator<Job> cmpNamePriority = new JobAscByName();
        int rsl = cmpNamePriority.compare(
                new Job("Ampl task", 1),
                new Job("Fix bug", 2)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenComparatorDescByPriority() {
        Comparator<Job> cmpNamePriority = new JobDescByPriority();
        int rsl = cmpNamePriority.compare(
                new Job("Ampl task", 6),
                new Job("Fix bug", 2)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenComparatorAscByPriority() {
        Comparator<Job> cmpNamePriority = new JobsAscByPriority();
        int rsl = cmpNamePriority.compare(
                new Job("Ampl task", 3),
                new Job("Fix bug", 0)
        );
        assertThat(rsl, equalTo(1));
    }

    @Test
    public void whenEqualPriorities() {
        Comparator<Job> cmpNamePriority = new JobDescByPriority();
        int rsl = cmpNamePriority.compare(
                new Job("Ampl task", 1),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, equalTo(0));
    }

    @Test
    public void whenComparatorByNameAndPriority() {
        Comparator<Job> cmpNamePriority = new JobDescByName().
                thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void anotherComparatorByNameAndPriority() {
        Comparator<Job> cmpNamePriority = new JobsAscByPriority()
                .thenComparing(new JobAscByName());
        int rsl = cmpNamePriority.compare(
                new Job("Get fpl task", 1),
                new Job("Get fixed bug", 1)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void yetAnotherComparatorByNameAndPriority() {
        Comparator<Job> cmpNamePriority = new JobDescByName()
                .thenComparing(new JobsAscByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Get bug fixed", 2),
                new Job("Get bug fixed", 3)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenListComparatorByNameAndPriority() {
        List<Job> list = Arrays.asList(
                new Job("Fix bug", 1),
                new Job("Fix bug", 4),
                new Job("Fix bug", 2),
                new Job("X task", 0)
        );
        Comparator<Job> comb = new JobDescByName()
                .thenComparing(new JobDescByPriority());
        Collections.sort(list, comb);
        List<Job> expected = Arrays.asList(
                new Job("X task", 0),
                new Job("Fix bug", 4),
                new Job("Fix bug", 2),
                new Job("Fix bug", 1)
        );
        assertThat(list, is(expected));
    }
}
