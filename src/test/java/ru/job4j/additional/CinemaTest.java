package ru.job4j.additional;

import org.junit.Test;

import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

public class CinemaTest {

    @Test
    public void checkEmptyPlace() {
        Cinema.Place[][] places = {
                {null, null, new Cinema.Place(0, 2)},
                {null, new Cinema.Place(1, 1), new Cinema.Place(1, 2)},
                {new Cinema.Place(2, 0), new Cinema.Place(2, 1), new Cinema.Place(2, 2)}
        };
        Cinema.Place rsl = Cinema.checkEmptyPlace(places);
        Cinema.Place expected = new Cinema.Place(0, 0);
        assertThat(rsl, is(expected));
    }

    @Test
    public void checkEmptyPlaceIsNotNull() {
        Cinema.Place[][] places = {
                {new Cinema.Place(0, 0), null, new Cinema.Place(0, 2), null,
                        new Cinema.Place(0, 4)},
                {null, new Cinema.Place(1, 1), null, new Cinema.Place(1, 3), null},
                {new Cinema.Place(2, 0), null, null, null, new Cinema.Place(2, 4)},
                {null, new Cinema.Place(3, 1), null, new Cinema.Place(3, 3), null},
                {new Cinema.Place(4, 0), new Cinema.Place(4, 1),
                        new Cinema.Place(4, 2), null, null}
        };
        Cinema.Place rsl = Cinema.checkEmptyPlace(places);
        Cinema.Place expected = new Cinema.Place(2, 2);
        assertThat(rsl, is(expected));
    }

    @Test
    public void checkEmptyPlaceIsNull() {
        Cinema.Place[][] places = {
                {new Cinema.Place(0, 0), null, new Cinema.Place(0, 2), null,
                        new Cinema.Place(0, 4)},
                {null, new Cinema.Place(1, 1), null, new Cinema.Place(1, 3), null},
                {new Cinema.Place(2, 0), null, new Cinema.Place(2, 2), null,
                        new Cinema.Place(2, 4)},
                {null, new Cinema.Place(3, 1), null, new Cinema.Place(3, 3), null},
                {new Cinema.Place(4, 0), new Cinema.Place(4, 1),
                        new Cinema.Place(4, 2), null, new Cinema.Place(4, 4)}
        };
        Cinema.Place rsl = Cinema.checkEmptyPlace(places);
        assertThat(rsl, is(nullValue()));
    }
}
