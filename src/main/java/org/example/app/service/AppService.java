package org.example.app.service;

import org.example.app.controller.StudentController;
import org.example.app.util.AppStarter;
import org.example.app.util.ERROR;
import org.example.app.view.AppView;

public class AppService {
    public void getOperation(int operation){
        StudentController studentController = new StudentController();
switch(operation){
    case 1 -> studentController.create();
    case 2 -> studentController.delete();
    case 3 -> studentController.read();
    case 4 -> studentController.update();
    case 5 -> studentController.findById();
    case 6 -> new AppView().displayInfo(Integer.toString(operation));
    default -> {
        try{
            throw new Exception();
        } catch (Exception e) {
            new AppView().displayInfo(ERROR.INCORRECT_OPERATOR.getMessage() + "\n");
            AppStarter.startApp();
        }
    }
}
    }
}
