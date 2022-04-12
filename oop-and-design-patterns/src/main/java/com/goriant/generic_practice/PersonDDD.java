package com.goriant.generic_practice;

@SuppressWarnings("unchecked")
public class PersonDDD {
    interface EmployeeDomain extends PersonDomain {}
    interface ManagerDomain extends PersonDomain {}
    interface PersonService<T extends PersonDomain> {
        String getFullName(T e);
    }
    // immutable class
    static class Person implements EmployeeDomain, ManagerDomain {
        private final String firstName;
        private final String lastName;
        public Person(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }
        public String lastName() {
            return lastName;
        }
        public String firstName() {
            return this.firstName;
        }
    }
    interface PersonDomain {
        String lastName();
        String firstName();
    }

    @SuppressWarnings("unchecked")
    static class PersonServiceImpl implements PersonService {
        public String getFullName(PersonDomain p) {
            return p.firstName() + " " + p.lastName();
        }
    }

    public static void main(String[] args) {
        EmployeeDomain p = new Person("andy", "bui");
        PersonService<EmployeeDomain> s = new PersonServiceImpl();
        System.out.println(s.getFullName(p));
    }
}
