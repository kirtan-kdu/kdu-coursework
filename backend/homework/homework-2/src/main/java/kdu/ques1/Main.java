package kdu.ques1;

import kdu.LoggingClass;

import javax.script.ScriptEngine;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        LoggingClass.logger.info("Welcome to GPA calculator");
        LoggingClass.logger.info("Enter the number of student: ");
        int noOfStudent = sc.nextInt();


        int[] studentIdList = new int[noOfStudent];
        int[] noOfCourses = new int[noOfStudent];

        for(int i=1;i<=noOfStudent;i++){
            LoggingClass.logger.info("Enter id of student " + i + ": ");
            studentIdList[i-1] = sc.nextInt();

            LoggingClass.logger.info("Enter the number of courses for student" + i+ ": ");
            noOfCourses[i-1] = sc.nextInt();
        }


        char[][] studentsGrades = getAllGrades(studentIdList, noOfCourses);

        double lower=0;
        double higher=0;

        LoggingClass.logger.info("Enter lower range for GPA: ");
        lower = sc.nextDouble();
        LoggingClass.logger.info("Enter higher range for GPA: ");
        higher = sc.nextDouble();

        int[] studentsByGPA = (int[]) StudentUtil.getStudentsByGPA(lower, higher, studentIdList, studentsGrades);

        LoggingClass.logger.info("The following Ids are in the range of " + lower + " to " + higher);

        for(int i=0;i<studentsByGPA.length;i++){
            LoggingClass.logger.info(studentsByGPA[i] + "");
        }
    }

    private static char[][] getAllGrades(int[] ids, int[] noOfCourses) {
        char[][] gradesOfStudents = new char[ids.length][];

        for(int i=0;i<ids.length;i++){
            gradesOfStudents[i] = new char[noOfCourses[i]];
        }

        Scanner sc = new Scanner(System.in);

        for(int id=1;id<=ids.length;id++){
            for(int course=1;course<=noOfCourses[id-1];course++){
                LoggingClass.logger.info("Enter grade for id: " + id + " of course: " + course);
                gradesOfStudents[id-1][course-1] = sc.next().charAt(0);
            }
        }

        return gradesOfStudents;
    }
}