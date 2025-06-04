package org.example.app.view;

import org.example.app.util.AppStarter;
import org.example.app.util.ERROR;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AppView {
    public <T> void displayInfo(T info){
        if(info.equals("6")){
            System.out.print("");//TODO
            System.exit(0);
        }else {
            System.out.print(info);
        }
    }
    public int chooseOperation(){
        Scanner sc = new Scanner(System.in);
        int operation = 0;
        showMenu();
        try{
            System.out.print("Choose correct operator for continue: ");
             operation = sc.nextInt();
        }catch(InputMismatchException e){
            System.out.print(ERROR.INCORRECT_OPERATOR.getMessage() + "\n");
            AppStarter.startApp();
        }
        return operation;
    }
    private void showMenu(){
        System.out.println("""
                ~~Choose operation~~
                1 - create student;
                2 - delete student by id;
                3 - show all students;
                4 - update student by id;
                5 - find student by id;
                6 - finish the program;
                """);
    }
}
