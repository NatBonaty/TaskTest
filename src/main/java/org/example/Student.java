package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Student {
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




    private Double gradeAvg;

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

    public Double getGradeAvg() {
        return gradeAvg;
    }

    public void setGradeAvg(Double gradeAvg) {
        this.gradeAvg = gradeAvg;
    }

    public Student(String name, int group, int course, Double gradeAvg) {
        this.name = name;
        this.group = group;
        this.course = course;
        this.gradeAvg = gradeAvg;
    }



    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", group=" + group +
                ", course=" + course +
                ", gradeAvg=" + gradeAvg +
                '}';
    }

    public Student() {
    }

    public static void main(String[] args) {
        ArrayList<Student> students;
        Stream.Builder<Object> builder = Stream.builder();

        builder.add(new Student("Наташа", 555, 3, 4.8))
                .add((new Student("Вова", 555, 1, 2.5)))
                .add(new Student("Катя", 577, 1, 4.9))
                .add((new Student("Вова", 555, 2, 2.5)))
                .add((new Student("Андрей", 558, 1, 4.5)))
                .add((new Student("Дима", 555, 1, 3.5)));
        Stream stream = builder.build();

        students = (ArrayList<Student>) stream.collect(Collectors.toCollection(ArrayList::new));
        System.out.println("Список студентов, до отчисления : ");
        for (Student s : students) {
            System.out.println(s);
        }
        printStudents(students, 1);

        System.out.println();

        students = removeStudent(students);

        System.out.println("Список студентов, после отчисления : ");
        for (Student s : students) {
            System.out.println(s);
        }
        System.out.println();

        printStudents(students, 2);

    }

    public static ArrayList<Student> removeStudent(ArrayList<Student> students) {
//        for (int i = students.size() - 1; i >= 0; --i) {
//            if (students.get(i).getGradeAvg() < 3) {
//                students.remove(students.get(i));
//            } else {
//                students.get(i).setCourse(students.get(i).getCourse() + 1);
//            }
//        }
//        return students;

        return students.stream()
                .filter(student -> student.getGradeAvg() >= 3.0)
                .peek(student -> student.setCourse(student.getCourse() +1))
                .collect(Collectors.toCollection(ArrayList::new)); // создается новый список, а не перезаписывается старый

    }

    public static void printStudents(List<Student> students, int course) {
        System.out.printf("Студенты, которые учатся на  %s курсе: ", course);

        students.stream().filter(student -> student.getCourse() == course).map(student -> student.getName() + ", ").forEach(System.out::print);

    }
}
