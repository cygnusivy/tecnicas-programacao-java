package br.com.letscode.java;

import br.com.letscode.java.Person.Sex;
import java.time.LocalDate;
import java.util.List;

public class Aplication {

    private static List<Person> getPersonList() {
        return List.of(
            Person.builder().name("José").birthday(LocalDate.of(1980, 2, 15)).gender(Sex.MALE).build(),
            Person.builder().name("Maria").birthday(LocalDate.of(1990, 8, 25)).gender(Sex.FEMALE).build(),
            Person.builder().name("Pedro").birthday(LocalDate.of(1997, 5, 5)).gender(Sex.MALE).build(),
            Person.builder().name("Paula").birthday(LocalDate.of(2010, 12, 30)).gender(Sex.FEMALE).build(),
            Person.builder().name("Ana").birthday(LocalDate.of(1978, 4, 12)).gender(Sex.FEMALE).build()
        );
    }

    public static void main(String[] args) {
        getPersonList().stream()
            .filter(person -> person.getGender() == Sex.FEMALE)
            .forEach(Person::printPerson);
    }
}
