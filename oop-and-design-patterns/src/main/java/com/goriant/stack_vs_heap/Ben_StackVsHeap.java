package com.goriant.stack_vs_heap;

public class Ben_StackVsHeap {

    /*
        - Fundamentals of JVM
        - memory: java memory model (JMM)
        - Byte code: JVM is cross OS
        - Class Loader:
        - CPU/RAM/DISK:
            - CPU: execute byte code instruction
            - RAM (Random access memory): store data state
            - DISK:
                - JAVA source code
                - Java byte code

        - Stack and Heap:
            - Heap: store data state
            - Stack: store byte code instruction
                - Thread:
                    - each thread has a seperated stack
                    - CPU: sẻ đọc cái stack của cái thread line by line and execute
                        - Main Thead STACK of cái Class này:
                            - nó đã dc push/put line code của cái Class này vào
                            - nó run line by line từ trên xuống

                            Lucas's statement:
                                - từ Perm gen: JVM copy class Ben_StackVsHeap metadata vào Main Thread Stack và run line by line
                                - Stack - Main Thread Stack - ThreadLocal : CPU sẽ đọc instruction từ Thread Stack và evaluate line by line (anh ko quan tâm là FIFO, LIFO)


        - JVM architecture nó sẻ có 3 thành phần chính
        - Class Loader
        - Data Area
        - Execution Engine

        1. how does jvm execute line by line
        - JVM's compiler nó sẻ load những cái file .java thành file .class
        - JVM's ClassLoader nó sẻ convert file .class thành byte code lên vùng nhớ permgem
        - JVM's Exution Engine thằng này nó sẻ convert thanh Languge Machine instruction
        - CPU sẻ execute mấy cái byte code dựa trên instruction

        - đầu tiên khi hàm main chạy lên sẻ execute line code Person person = new Person();
        -  khi một thread mainc hạy lên sẻ được JVM cung cấp cho 1 cái stack
        - biến person sẻ được lưu ở trong stack chứa địa chỉ vùng nhớ trỏ tới object "new Person()"
        - "new Person()" nó sẻ tạo 1 vùng ở trong Heap để lưu data
        - vì Class Person có 1 field là "name" với dataType la String,
         thì tại cái vùng nhớ "new Person()" field "name" nó sẻ trỏ tới null vì chưa có giá trị được gán.

         - đến line code person.setName("Ben");
         - biến person vẫn được lưu ở trong stack và vẫn trỏ tới vùng nhớ ban đầu
         - "Ben" nó là 1 cái literal String và khi mình khai báo "Ben" là nó tạo 1 vùng nhớ ở String Pool để chứa giá trị này
         - và nó là immutable mình sẻ discuss cái này sau vì không nằm trong session này
         - field "name" trong object person sẻ đổi từ null sang vùng nhớ của "Ben" trong heap.

         - đến line code "person.setName("Lucas");" thì cũng tương tự như line code "person.setName("Ben");"
         - field "name" chỉ đổi địa chỉ vùng nhớ.

         - Call/ Thread Stack
         - một cái thread main khi được tạo, JVM sẻ cấp cho nó 1 vùng nhớ Stack, và cái này là độc lập giữa các thread main.
         -
         - Stack: Last In First Out
         - function sẻ được bỏ vào stack khi mà nó gọi execute
         - vì sao nó lại bỏ vào stack:
         - thì để cái thằng Execution Engine, nó đánh dấu lại cái vị trí khi gọi execute cái function đó
         */

    /*
    STACK
    *******
     */
    public static void main(String[] args) {
        Person person = new Person();
        person.setName("Ben");
        person.setName("Lucas");
    }

    public static class Person {
        private String name;

        public Person() {
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    static void methodA() {

    }

    static void methodB() {

    }

    static void methodC() {

    }
}
