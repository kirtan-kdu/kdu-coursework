package kdu.quesone;

public class MissingGradeException extends RuntimeException {
    
    private int studentId;

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public MissingGradeException(int id){
        studentId = id;
    }
}
