package kdu.quesone;

import kdu.ConsoleLogger;

import java.util.ArrayList;
import java.util.List;

public class StudentUtil {
    public static double[] calculateGPA(int[] studentIdList, char[][]
            studentsGrades) throws MissingGradeException {

        // Throwing RuntimeException

        if( studentIdList.length != studentsGrades.length ) {
            String exception = "studentIdList & studentsGrades are out-of-sync. studentIdList.length: " + studentIdList.length + ", studentsGrades.length: " + studentsGrades.length;
            throw new IllegalArgumentException(exception);
        }

        int noOfStudents = studentIdList.length;
        double[] studentGPA = new double[noOfStudents];

        for(int student=0;student<noOfStudents;student++){
            double sum=0.0;
            for(int course=0;course<studentsGrades[student].length;course++){

                // Checked Exception
                if(studentsGrades[student][course] == ' '){
                    throw new MissingGradeException(studentIdList[student]);
                }

                sum = sum + 4 - (studentsGrades[student][course] - 'A');
            }
            studentGPA[student] = sum / studentsGrades[student].length;
        }

        return studentGPA;
    }
    public static int[] getStudentsByGPA(double lower, double higher, int[]
            studentIdList, char[][] studentsGrades) {
        double[] studentGPA = new double[studentIdList.length];
        try {
            studentGPA = calculateGPA(studentIdList, studentsGrades);
            List<Integer> studentsByGPA = new ArrayList<>();
            ConsoleLogger.infoMethod("GPAs are : ");

            for(int studentId=0;studentId<studentIdList.length;studentId++){
                ConsoleLogger.infoMethod(studentGPA[studentId] + ", ");
                if (studentGPA[studentId] > lower && studentGPA[studentId] < higher){
                    studentsByGPA.add(studentIdList[studentId]);
                }
            }

            return studentsByGPA.stream().mapToInt(i->i).toArray();
        }
        catch (MissingGradeException ex){
            throw  new InvalidDataException("GPAs must be computed only after all students have received grades",ex);
        }


    }
}