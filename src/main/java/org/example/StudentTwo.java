package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StudentTwo {
//    2. Добавить студентов в коллекцию (реализовать с использованием Stream API)
//    Создать класс Student, содержащий следующие характеристики – имя, группа, курс, оценки по предметам.
//    Создать коллекцию, содержащую объекты класса Student.
//    Написать метод, который удаляет студентов со средним баллом <3.
//    Если средний балл>=3, студент переводится на следующий курс.
//    Напишите метод printStudents(List<Student> students, int course), который получает список студентов и номер курса.
//    А также печатает на консоль имена тех студентов из списка, которые обучаются на данном курсе.

    private String name;
    private int group;
    private int course;
    private ArrayList<Integer> grades;
    private Double avgGr;
    public ArrayList<Integer> getGrades() {
        grades = new ArrayList<>(Arrays.asList((int)(Math.random() * 5 + 1),(int)(Math.random() * 5 +1),(int)(Math.random() * 5+1)));
        return grades;
    }
    public Double getAvgGr() {
        int sum = 0;
        for(Integer i : grades){
            sum += i;
        }
        avgGr = (double) (sum / this.getGrades().size());
        return avgGr;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getCourse() {
        return course;
    }
    public void setCourse(int course) {
        this.course = course;
    }
    public StudentTwo(String name, int group, int course) {
        this.name = name;
        this.group = group;
        this.course = course;
        this.grades = getGrades();
        this.avgGr = getAvgGr();
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", group=" + group +
                ", course=" + course +
                ", grades=" + grades +
                ", avgGrade=" + avgGr +
                '}';
    }
    public StudentTwo() {
    }

    public static void main(String[] args) {
        ArrayList<StudentTwo> students;
        Stream.Builder<Object> builder = Stream.builder();

        builder.add(new StudentTwo("Наташа", 555, 3))
                .add(new StudentTwo("Вова", 555, 1))
                .add(new StudentTwo("Катя", 577, 1))
                .add(new StudentTwo("Катя", 577, 1))
                .add(new StudentTwo("Катя", 577, 1))
                .add(new StudentTwo("Катя", 577, 1))
                .add(new StudentTwo("Катя", 577, 1));

        Stream stream = builder.build();

        students = (ArrayList<StudentTwo>) stream.collect(Collectors.toCollection(ArrayList::new));
        System.out.println("Список студентов, до отчисления : ");
        for (StudentTwo s : students) {
            System.out.println(s);
        }
        printStudents(students, 1);

        System.out.println();

        students = removeStudent(students);

        System.out.println("Список студентов, после отчисления : ");
        for (StudentTwo s : students) {
            System.out.println(s);
        }
        System.out.println();

        printStudents(students, 2);

    }
    public static ArrayList<StudentTwo> removeStudent(ArrayList<StudentTwo> students) {
        return students.stream()
                .filter(student -> student.getAvgGr() > 3.0)
                .peek(student -> student.setCourse(student.getCourse() +1))
                .collect(Collectors.toCollection(ArrayList::new)); // создается новый список, а не перезаписывается старый

    }
    public static void printStudents(List<StudentTwo> students, int course) {
        System.out.printf("Студенты, которые учатся на  %s курсе: ", course);

        students.stream().filter(student -> student.getCourse() == course).map(student -> student.getName() + ", ").forEach(System.out::print);
    }
}
