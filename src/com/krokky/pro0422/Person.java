package com.krokky.pro0422;

import java.util.Objects;

public class Person implements Comparable<Person> {
    private Integer personId;
    private String personName;
    private Integer personAge;

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }


    public Integer getPersonAge() {
        return personAge;
    }

    public void setPersonAge(Integer personAge) {
        this.personAge = personAge;
    }

    @Override
    public boolean equals(Object o) {
        Person person = (Person) o;
        return personAge.equals(person.personAge);
    }

    @Override
    public int hashCode() {
        return Objects.hash(personAge);
    }

    @Override

    public String toString() {
        return "Person{" +
                "personId=" + personId +
                ", personName='" + personName + '\'' +
                ", personAge=" + personAge +
                '}';
    }

    public Person(int i) {
        personId = i + 1;
        int k = (int) (Math.random() * 2 + 2);
        personName = "";
        for (int j = 0; j < k; j++) {
            char c = (char) ((int) (Math.random() * 1000 + 20000));
            personName += c;
        }
        personAge = (int) (Math.random() * 10 + 18);
    }

    @Override
    public int compareTo(Person o) {
        System.out.println("比较了自身和传递过来的o的年龄情况\t" + this.getPersonId() + "\t" + o.getPersonId());
        return this.personAge - o.getPersonAge();
    }
}
