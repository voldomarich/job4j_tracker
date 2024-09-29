package ru.job4j.tracker.tracker;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

@Entity
@Table(name = "items")
@Data
public class Item implements Comparable<Item> {

    private static final DateTimeFormatter FORMATTER =
            DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @CreationTimestamp
    private LocalDateTime created = LocalDateTime.now().withNano(0);

    public Item() {
    }

    public  Item(String name) {
        this.name = name;
    }

    public Item(int id, String name, LocalDateTime date) {
        this.id = id;
        this.name = name;
        this.created = date;
    }

    @Override
    public String toString() {
        return String.format("id: %s, name: %s, created: %s", id, name, FORMATTER.format(created));
    }

    @Override
    public int compareTo(Item o) {
        return Integer.compare(id, o.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Item item = (Item) obj;
        return name.equals(item.name);
    }
}
