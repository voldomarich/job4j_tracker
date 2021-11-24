package ru.job4j.search;

import org.junit.Test;
import java.util.ArrayList;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class PhoneDictionaryTest {

   @Test
        public void whenFindByName() {
            PhoneDictionary phones = new PhoneDictionary();
            phones.add(
                    new Person("Petr", "Arsentev", "534872", "Bryansk")
            );
            ArrayList<Person> persons = phones.find("Petr");
            assertThat(persons.get(0).getSurname(), is("Arsentev"));
            persons = phones.find("534872");
            assertThat(persons.get(0).getAddress(), is("Bryansk"));
            persons = phones.find("Igor");
            assertThat(persons.size(), is(0));
        }
    }
