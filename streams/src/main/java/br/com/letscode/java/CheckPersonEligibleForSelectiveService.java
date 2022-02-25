package br.com.letscode.java;

public class CheckPersonEligibleForSelectiveService implements CheckPerson {

    @Override
    public boolean test(Person p) {
        return p.getGender() == Person.Sex.MALE &&
            p.getAge() >= 18 &&
            p.getAge() <= 28;
    }

}
