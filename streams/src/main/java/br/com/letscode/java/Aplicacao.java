package br.com.letscode.java;

import br.com.letscode.java.Person.Sex;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Aplicacao {

    public static void main(String[] args) {
        Aplicacao app = new Aplicacao();
        List<Person> myPersonList = List.of(
            new Person(
                "Jessé",
                LocalDate.of(1995, 9, 30),
                Sex.MALE,
                "jesse.haniel@letscode.com.br")
        );
        app.printPersonsOlderThan(myPersonList, 30);
        CheckPerson tester = new CheckPersonEligibleForSelectiveService();
        app.printPersons(myPersonList, tester);
        app.printPersons(myPersonList, (Person p) -> Person.Sex.FEMALE.equals(p.getGender())
            && p.getEmailAddress().contains("@letscode.com.br"));
        app.printPersonsWithPredicate(myPersonList, p -> p.getGender().equals(Sex.MALE));

        System.out.println(">>>> Pipelines e Streams");
        Predicate<Person> personPredicate = p -> p.getGender().equals(Sex.MALE);
        app.printPersonsWithPipeline(myPersonList, personPredicate);

        double avg = app.averageAge(myPersonList);
        System.out.println("Average age: " + avg);
        avg = myPersonList.stream()
            .filter(p -> p.getGender().equals(Sex.MALE))
            .mapToInt(Person::getAge)
            .average()
            .getAsDouble();
        System.out.println("Average age: " + avg);
    }

    private double averageAge(List<Person> myPersonList) {
        List<Integer> ages = new ArrayList<>();
        for (Person p : myPersonList) {
            if (p.getGender().equals(Person.Sex.MALE)){
                ages.add(p.getAge());
            }
        }
        double sum = 0;
        for (Integer age : ages) {
            sum += age;
        }
        return sum/ages.size();
    }

    private void printPersonsWithPipeline(List<Person> myPersonList, Predicate<Person> personPredicate) {
        myPersonList.stream()
            .filter(personPredicate)//predicate
            .forEach(p -> p.printPerson());//consumer
        //supplier -> get, construtor padrão
        //consumer -> void = set, println
    }

    public void printPersonsOlderThan(List<Person> roster, int age) {
        for (Person p : roster) {
            if (p.getAge() >= age) {
                p.printPerson();
            }
        }//alto acoplamento
    }

    public void printPersons(List<Person> roster, CheckPerson tester) {
        for (Person p : roster) {
            if (tester.test(p)) {
                p.printPerson();
            }
        }
    }

    public void printPersonsWithPredicate(List<Person> roster, Predicate<Person> tester) {
        for (Person p : roster) {
            if (tester.test(p)) {
                p.printPerson();
            }
        }
    }

}
