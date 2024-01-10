package org.JFPart1;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

public class StudentRepository {
    ArrayList<Student> ListOfStudents;

    public StudentRepository(ArrayList<Student> listOfStudents) {
        ListOfStudents = listOfStudents;
    }

    public StudentRepository(){
        ListOfStudents = new ArrayList<>();
    }

    // method overloading to retrieve students based on student id and name
    public Student getStudent(int id){
        return ListOfStudents.stream().filter(student -> student.getId() == id).findAny().orElse(null);
    }

    public List<Student> getStudent(String name){
        return ListOfStudents.stream().filter(student -> Objects.equals(student.getName(), name)).toList();
    }


    // add student object
    public boolean addStudent(Student student){

        // id should be unique check
        boolean alreadyExists = ListOfStudents.stream().anyMatch(currStudent -> currStudent.getId() == student.getId());

        if(alreadyExists)return false;

        ListOfStudents.add(student);
        return true;
    }

    // Update student based on its id
    public boolean updateStudent(Student s){

        AtomicBoolean isUpdated = new AtomicBoolean(false);

        ListOfStudents.forEach(student -> {
            if(student.getId() == s.getId()){
                student.setName(s.getName());
                student.setAge(s.getAge());
                student.setGrade(s.getGrade());
                isUpdated.set(true);
            }
        });

        return isUpdated.get();
    }

    public ArrayList<Student> getAllStudents(){
        return ListOfStudents;
    }
}