package ru.job4j.additional;

import java.util.Objects;

public class Cinema {

    public static Place checkEmptyPlace(Place[][] places) {
        for (int i = 0; i < places.length; i++) {
            for (int y = 0; y < places[i].length; y++) {
                if ((i == y || i + y == places.length - 1) && places[i][y] == null) {
                    return new Place(i, y);
                }
            }
        }
        return null;
    }

    public static class Place {
        private int row;

        private int cell;

        public Place(int row, int cell) {
            this.row = row;
            this.cell = cell;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Place place = (Place) o;
            return row == place.row &&
                    cell == place.cell;
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, cell);
        }
    }
}
