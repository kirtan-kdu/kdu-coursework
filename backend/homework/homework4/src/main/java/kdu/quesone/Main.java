package kdu.quesone;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        int[] studentIdList = {1001, 1002};
        char[][] studentsGrades = { { 'A', 'A', 'A', 'B' }, {'A', ' ', 'B'} };
        int[] studentByGPA = StudentUtil.getStudentsByGPA(3.2,3.5,studentIdList, studentsGrades);
        System.out.println(studentByGPA[0]);
        System.out.println(studentByGPA[1]);
    }
}