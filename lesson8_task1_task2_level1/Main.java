package lesson8_task1_task2_level1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Group group = new Group();

        Student st1 = new Student("Alex","Milevsky", Gender.MAN, 0, "Group-1");
        Student st2 = new Student("Masha","Olegor", Gender.MAN, 1, "Group-1");
        Student st3 = new Student("Alex","Milevsky", Gender.MAN, 0, "Group-1");

        group.setGroupName("Group-1");
        try {
            group.addStudent(st1);
            group.addStudent(st2);
            group.addStudent(st3);
        } catch (GroupOverflowException e) {
            throw new RuntimeException(e);
        }

        System.out.println(group);

        Group group2 = new Group();

        Student st11 = new Student("Alex","Milevsky", Gender.MAN, 0, "Group-1");
        Student st22 = new Student("Alex","Milevsky", Gender.MAN, 0, "Group-1");
        Student st33 = new Student("Masha","Olegor", Gender.MAN, 1, "Group-1");

        group2.setGroupName("Group-1");
        try {
            group2.addStudent(st11);
            group2.addStudent(st22);
            group2.addStudent(st33);
        } catch (GroupOverflowException e) {
            throw new RuntimeException(e);
        }

        System.out.println(group2);

        System.out.println(group.equals(group2));

        System.out.println(group.hashCode() == group2.hashCode());








    }


}
