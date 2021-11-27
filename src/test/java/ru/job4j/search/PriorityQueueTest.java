package ru.job4j.search;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class PriorityQueueTest {

    @Test
    public void whenHigherPriority() {
        PriorityQueue queue = new PriorityQueue();
        queue.put(new Task("low", 3));
        queue.put(new Task("urgent", 5));
        queue.put(new Task("middle", 1));
        Task result = queue.take();
        assertThat(result.getDesc(), is("middle"));
    }

    @Test
    public void whenEqualPriority() {
        PriorityQueue queue = new PriorityQueue();
        queue.put(new Task("low", 5));
        queue.put(new Task("urgent", 5));
        queue.put(new Task("middle", 5));
        Task result = queue.take();
        assertThat(result.getDesc(), is("low"));
    }

    @Test
    public void whenNoElements() {
        PriorityQueue queue = new PriorityQueue();
        Task result = queue.take();
        assertNull(result);
    }
}
