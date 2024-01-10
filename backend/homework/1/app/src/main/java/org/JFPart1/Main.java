package org.JFPart1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        LoggingClass loggingClass = new LoggingClass();
        StudentRepository studentRepository = new StudentRepository();

        System.out.println("Hello! Its a simple application to manage student information");

        boolean continued = true;
        while (continued){

            System.out.println("Enter 1,2,3 or 4 based on below options:");
            System.out.println("1. Add new Student to repository");
            System.out.println("2. Update a Student information");
            System.out.println("3. Retrieve any Student information");
            System.out.println("4. Retrieve all Student information");
            System.out.println("5. Close program");

            int option = checkNumber(sc.nextLine());
            Student student;
            boolean isSuccessful = false;

            switch(option){
                case 1:
                    student = inputStudent();
                    isSuccessful = studentRepository.addStudent(student);
                    if(isSuccessful)loggingClass.addedSuccessfully(student);
                    else loggingClass.repeatedStudent(student);
                    break;

                case 2:
                    student = inputStudent();
                    isSuccessful = studentRepository.updateStudent(student);
                    if (isSuccessful)loggingClass.updatedStudent(student);
                    else loggingClass.studentNotFound(student.getId());
                    break;

                case 3:
                    System.out.println("\n\nEnter how do you wanna retrieve student,");
                    System.out.println("1 for using Student id");
                    System.out.println("2 for using Student name");
                    int input = checkNumber(sc.nextLine());
                    if(input == 1){
                        System.out.print("Enter id: ");
                        int id = checkNumber(sc.nextLine());
                        Student s = studentRepository.getStudent(id);
                        if(s == null)loggingClass.studentNotFound(id);
                        else {
                            System.out.println("Id: " + s.getId() + ", Name: " + s.getName() + ", Age: " + s.getAge() + ", Grade: " + s.getGrade());
                        }
                    }
                    else {
                        System.out.print("Enter name: ");
                        String name = sc.nextLine();
                        List<Student> studentList = studentRepository.getStudent(name);
                        if(studentList == null)loggingClass.studentNotFound(name);
                        else{
                            studentList.forEach(s -> System.out.println("Id: " + s.getId() + ", Name: " + s.getName() + ", Age: " + s.getAge() + ", Grade: " + s.getGrade()));
                        }
                    }
                    break;

                case 4:
                    System.out.println("This is the list of all students,\n");
                    studentRepository.getAllStudents().forEach(s -> {
                        System.out.println("Id: " + s.getId() + ", Name: " + s.getName() + ", Age: " + s.getAge() + ", Grade: " + s.getGrade());
                    });
                    System.out.println("\n\n");
                    break;

                case 5:
                    System.out.println("Thanks for playing around it!");
                    continued = false;
                    break;

                default:
                    System.out.println("Invalid input");
            }
        }

    }

    private static Student inputStudent() {
        Scanner sc = new Scanner(System.in);

        int id,age;
        String name,grade;

        System.out.println("Enter student details below,");
        System.out.print("Id: ");
        id = checkNumber(sc.nextLine());
        System.out.print("Name: ");
        name = sc.nextLine();
        System.out.print("Age: ");
        age = checkNumber(sc.nextLine());
        System.out.print("Grade: ");
        grade = sc.nextLine();

        return new Student(id,name,age,grade);
    }

    private static int checkNumber(String scannerinput) {
        try {
            return Integer.parseInt(scannerinput);
        } catch (Exception e) {
            System.out.println("Input is not a Number! Taking it as 1");
            return 1; // Just hardcoded this as there is not much logic
        }
    }
}