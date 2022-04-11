package com.goriant.stack_vs_heap;

public class Ben_StackVsHeap {

    public static void main(String[] args) {
        Person p = createPerson();
        System.out.println(p);
    }
    public static Person createPerson() {
//        for(StackTraceElement e: Thread.currentThread().getStackTrace())
//            System.out.println(e);
        Person p = new Person();
        p.name = "Ben";
        p.name = "lucas";
        return p;
    }

    public static class Person {
        public String name;

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

    // Problems solving skills
    //  - ko chịu do homework/R&D
    //  - stackoverflow copy paste
    //  - baeldung.com copy paste - Ben nói là resouce dc verified by ? - Ben sẽ show cho anh :D

    /*
    - Stackoverflow: tràn vùng nhớ Stack trong JVM
        - thread stack memory -> OS - JDK flags
        - complete a Block Code - a Function
        - đệ quy ko có break point: nó sẽ put a function to its Stack
            - nó cứ put cho đến khi tràn Stack Memory -> application crash by ERROR: java.lang.StackOverflowError
    - normal:
        - nó sẽ put từng blockcode vào Thread Stack và evaluate
            - Blockcode của mình ở đâu ra cho Thread Stack
                - 1. Execution Engine: convert bytecode thành Language Machine Instruction (CPU run cái lày) : run line by line
                - 2. Execution Engine: execute blockcode of function dc put vào stack đó
                - 3. how?
                    - STACK: 1 cái kệ
                        - Execution Engine: sẽ pop từng line ra và execute
                        - Sau khi nó POP từ Stack ra - thì nó sẽ vứt cái line này trong Stack của nó đi
                            1. là nó sẽ clear cái Thread Stack data của nó
                            2. là GC sẽ lắng nghe và tất cả Local Variable trong blockcode này - sẽ dc dọn gần như ngay lập tức
                                - avoid Stackoverflow - Stack Memory
                                - GC có info để dọn dẹp Heap Memory cho mình

    - NOTES: ngoại trừ docs của Oracle JAVA tất cả đều ko dc verified
    */
}
