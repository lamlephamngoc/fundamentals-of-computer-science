package com.goriant.stack_vs_heap;

public class StackVsHeap {
    public static void main(String[] args) {
        Person p = new Person();
        p.setName("ben");
        p.setName("lucas");
    }

    public static class Person {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
