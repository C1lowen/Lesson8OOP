package lesson8_task1_level2;

import lesson8_task1_task2_level1.Gender;
import lesson8_task1_task2_level1.Student;

public class Main {
    public static void main(String[] args) {
        Student  st1 = new Student("Alex","Milevsky", Gender.MAN, 0, "Group-1");

        Stack stack = new Stack();

        stack.push('+');
        stack.push("Привет");
        stack.push(3);
        stack.push(4.0);
        stack.push(st1);


        int size = stack.getSize();
        System.out.println("size = " + stack.getSize());
        for(int i = 0; i < size; i++){
            System.out.println("===============================");
            System.out.println(stack.peek());
            stack.pop();
            System.out.println("size = " + stack.getSize());
        }

    }
}
