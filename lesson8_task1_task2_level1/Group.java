package lesson8_task1_task2_level1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

public class Group {
    private String groupName;
    private Student[] students;



    public Group() {
        students = new Student[10];
        this.groupName = null;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Student[] getStudents() {
        return students;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }

    public void addStudent(Student student) throws GroupOverflowException {

        for(int i = 0; i < students.length; i++){
            if(student.equals(students[i])){
                System.out.println("Cтудент " + student.getName() +" уже есть, количество студентов осталось тоже!");
                return;
            }
        }

        if(!(student.getGroupName().equals(this.groupName))){
            System.out.println("Студент "+ student.getName() +" не может быть в этой группе!");
            return;
        }
       for(int i = 0; i < students.length; i++){
           if(students[i] == null){
               students[i] = student;
               return;
           }
       }
       throw new GroupOverflowException("В группу нельзя добавить больше 10 студентов");
    }

    public Student searchStudentByLastName(String lastName) throws StudentNotFoundException {
        for(int i = 0; i < students.length; i++){
            if(students[i] != null && students[i].getLastName().equals(lastName)){
                return students[i];
            }
        }
        throw new StudentNotFoundException("Такого студента не найдено!");
    }

    public boolean removeStudentByID(int id) {
        for(int i = 0; i < students.length; i++){
            if(students[i] != null && students[i].getId() == id){
                students[i] = null;
                return true;
            }
        }
        return false;
    }
    public Student[] sortStudentsByLastName(){
       Arrays.sort(students, Comparator.nullsLast(new StudentLastNameComparator()));

       return students;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Group group = (Group) o;

        if (!Objects.equals(groupName, group.groupName)) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(students, group.students);
    }

    @Override
    public int hashCode() {
        int result = groupName != null ? groupName.hashCode() : 0;
        result = 31 * result + Arrays.hashCode(students);
        return result;
    }

    @Override
    public String toString() {
         String result = "Group" + System.lineSeparator();
         Student[] sortedStudentsForLastName = sortStudentsByLastName();

         for(int i = 0; i < sortedStudentsForLastName.length; i++){
             if(sortedStudentsForLastName[i] != null){
                 result +=  sortedStudentsForLastName[i].toString() + System.lineSeparator();
             }
         }
        return result;
    }
}
