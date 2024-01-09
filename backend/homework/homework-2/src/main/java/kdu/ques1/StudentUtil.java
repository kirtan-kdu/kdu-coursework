package kdu.ques1;


import java.util.ArrayList;
import java.util.List;

public class StudentUtil {
    public static double[] calculateGPA(int[] studentIdList, char[][]
            studentsGrades) {
        int noOfStudents = studentIdList.length;
        double[] studentGPA = new double[noOfStudents];

        for(int student=0;student<noOfStudents;student++){
            double sum=0.0;
            for(int course=0;course<studentsGrades[student].length;course++){
                sum = sum + 4 - (studentsGrades[student][course] - 'A');
            }
            studentGPA[student] = sum / studentsGrades[student].length;
        }

        return studentGPA;
    }
    public static int[] getStudentsByGPA(double lower, double higher, int[]
            studentIdList, char[][] studentsGrades) {
        double[] studentGPA = calculateGPA(studentIdList, studentsGrades);

        List<Integer> studentsByGPA = new ArrayList<Integer>();
        System.out.println("GPAs are : ");

        for(int studentId=0;studentId<studentIdList.length;studentId++){
            System.out.println(studentGPA[studentId] + ", ");
            if (studentGPA[studentId] > lower && studentGPA[studentId] < higher){
                studentsByGPA.add(studentIdList[studentId]);
            }
        }

        return studentsByGPA.stream().mapToInt(i->i).toArray();
    }
}