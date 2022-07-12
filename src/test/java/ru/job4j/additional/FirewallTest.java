package ru.job4j.additional;

import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

public class FirewallTest {

    @Test
    public void checkName() {
        Set<String> words = Set.of("instagram", "фото", "мем", "котик");
        String s = "Создание многомодульного Gradle проекта SpringBoot + Angular в IDEA";
        String rsl = Firewall.checkName(s, words);
        assertThat(rsl, is("Вы сделали правильный выбор!"));
    }

    @Test
    public void checkNameFalse() {
        Set<String> words = Set.of("instagram", "фото", "мем", "котик");
        String s = "Криштиану Роналду опубликовал новую фотографию с детьми в instagram";
        String rsl = Firewall.checkName(s, words);
        assertThat(rsl, is("Выберите другую статью..."));
    }
}
