package org.example.app.controller;

import org.example.app.service.StudentService;
import org.example.app.util.AppStarter;
import org.example.app.util.ERROR;
import org.example.app.util.SUCCESS;
import org.example.app.view.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StudentController {
    private static final Logger LOG = LoggerFactory.getLogger(StudentController.class);
    StudentService service = new StudentService();
    public void create(){
        CreateStudentView view = new CreateStudentView();
        String result = service.createStudent(view.getData());
        if(result.equals(SUCCESS.CREATED.getMessage())) {
            LOG.info("User create student");
        }
        view.getOutput(result);
        AppStarter.startApp();
    }
    public void read(){
        ReadStudentsView view = new ReadStudentsView();
        String result = service.readStudents();
        if(!result.equals(ERROR.ABSENT_DATA.getMessage())) {
            LOG.info("User read students list");
        }
        view.getOutput(result);
        AppStarter.startApp();
    }
    public void update(){
        UpdateStudentView view = new UpdateStudentView();
        String result = service.updateStudent(view.getData());
        if(result.equals(SUCCESS.UPDATED.getMessage())) {
            LOG.info("User Update student ");
        }
        view.getOutput(result);
        AppStarter.startApp();
    }
    public void delete(){
        DeleteStudentView  view = new DeleteStudentView();
        String result = service.deleteStudent(view.getData());
        if(result.equals(SUCCESS.CREATED.getMessage())) {
            LOG.info("User delete student");
        }
        view.getOutput(result);
        AppStarter.startApp();
    }
    public void findById(){
        FindStudentByIdView view = new FindStudentByIdView();
        String result = service.findStudentById(view.getData());
        if(!result.equals(ERROR.ABSENT_DATA.getMessage())) {
            LOG.info("User find student by id");
        }
        view.getOutput(result);
        AppStarter.startApp();
    }
}
