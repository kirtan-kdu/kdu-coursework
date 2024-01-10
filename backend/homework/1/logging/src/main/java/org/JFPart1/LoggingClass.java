package org.JFPart1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class LoggingClass {

    private static final Logger logger = LoggerFactory.getLogger(LoggingClass.class);

    public void addedSuccessfully(Student student){
        logger.info("Successfully added a student with id: " + student.getId() + ", name: " + student.getName() + ", age: " + student.getAge() + ", grade: "+ student.getGrade());
    }

    public void repeatedStudent(Student student){
        logger.warn("Invalid input as Student with id - " + student.getId() + " is repeated");
    }

    public void updatedStudent(Student student){
        logger.info("Updated a student information of id: " + student.getId() + " as, name: " + student.getName() + ", age: " + student.getAge() + ", grade: "+ student.getGrade());
    }

    public void studentNotFound(int id){
        logger.error("Student does not exist with id: " + id);
    }

    public void studentNotFound(String name){
        logger.error("Student does not exist with name: " + name);
    }
}
