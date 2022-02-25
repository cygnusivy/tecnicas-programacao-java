package br.com.letscode.java;

import java.time.LocalDate;
import java.time.Period;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    public enum Sex {
        MALE, FEMALE
    }
    private String name;
    private LocalDate birthday;
    private Sex gender;
    private String emailAddress;

    public int getAge() {
        return Period.between(this.birthday, LocalDate.now()).getYears();
    }

    public void printPerson() {
        System.out.println(this);
    }

}
