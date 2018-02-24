package com.company.view.main;

import com.company.model.User;
import com.company.model.UserDetails;
import com.company.service.UserDetailsService;
import com.company.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by dsrpc on 24.02.2018.
 */
@Component
public class DemoMenu {
    @Autowired
    private UserService userService;
    @Autowired
    private UserDetailsService userDetailsService;

    public void main() {

        // Local variable
        System.out.flush();

        // Switch construct
        boolean resume = true;
       // int swValue = printMenu();
        while(resume) {
            //int swValue = printMenu();
            switch (printMenu()) {
                case 1:
                    System.out.println("Option 1 selected");
//                Keyin.inString("Please, enter name");
                    User user = new User();
                    user.setFirstName(Keyin.inString("Please, enter first name: "));
                    user.setLastName(Keyin.inString("Please, enter last name: "));
                    user.setUsername(Keyin.inString("Please, enter your username: "));
                    userService.save(user);
                   // System.out.println(user);
                    //System.out.println();
                            // String noteX = Keyin.inString("You want to exit? ");
                            //if(noteX.equals("exit")) {resume = false;System.out.println("Bye");}
                    break;
                case 2:
                    System.out.println("Option 2 selected");
                    User userf = userService.findById(Keyin.inInt("Please, enter user id"));
                    if(userf==null) {
                        System.err.println("User by ID not found!");
                        break;
                    }else{
                        UserDetails userDetails = new UserDetails();
                                userDetails.setUser(userf);
                                userDetails.setCity(Keyin.inString("Please, enter city name: "));
                                userDetails.setCountry(Keyin.inString("Please, enter country name: "));
                        userDetails.setAddress(Keyin.inString("Please, enter street name: "));
                        userDetailsService.save(userDetails);
                    }
                    break;
                case 3:
                    System.out.println("Update User");
                    User useru = userService.findById(Keyin.inInt("Please, enter user id"));
                    if(useru==null) {
                        System.err.println("User by ID not found!");
                        break;
                    }else{
                        useru.setFirstName(Keyin.inString("Please, enter first name: "));
                        useru.setLastName(Keyin.inString("Please, enter last name: "));
                        useru.setUsername(Keyin.inString("Please, enter your username: "));
                        userService.update(useru);
                    }
                    break;

                case 4:
                    System.out.println("Delete User");
                    User userd = userService.findById(Keyin.inInt("Please, enter user id"));
                    if(userd==null) {
                        System.err.println("User by ID not found!");
                        break;
                    }else{
                        userService.deleteUser(userd);
                    }
                    break;
                case 5:
                    System.out.println("Print All Users");
                    List<User> users = userService.findAll();
                    System.out.println(users);
                    break;
                case 6:
                    System.out.println("Exit selected");
                    System.out.println("Bye! Bye!");
                    resume = false;
                    break;
                default:
                    System.out.println("Invalid selection");
                    break; // This break is not really necessary
            }
        }



    }

    private int printMenu() {
        int swValue;

        // Display menu graphics
        System.out.println("=========================================");
        System.out.println("|   MENU SELECTION DEMO                 |");
        System.out.println("=========================================");
        System.out.println("| Options:                              |");
        System.out.println("|        1. Adding user                 |");
        System.out.println("|        2. Add User Details By User Id |");
        System.out.println("|        3. Update User by User Id      |");
        System.out.println("|        4. Delete User                 |");
        System.out.println("|        5. Print All Users             |");
        System.out.println("|        6. Exit                        |");
        System.out.println("=========================================");
        swValue = Keyin.inInt(" Select option: ");
        return swValue;
    }
}

//**********************************************************
//**********************************************************
//Program: Keyin
//Reference: Session 20
//Topics:
// 1. Using the read() method of the ImputStream class
//    in the java.io package
// 2. Developing a class for performing basic console
//    input of character and numeric types
//**********************************************************
//**********************************************************

class Keyin {

    //*******************************
    //   support methods
    //*******************************
    //Method to display the user's prompt string
    public static void printPrompt(String prompt) {
        System.out.print(prompt + " ");
        System.out.flush();
    }

    //Method to make sure no data is available in the
    //input stream
    public static void inputFlush() {
        int dummy;
        int bAvail;

        try {
            while ((System.in.available()) != 0)
                dummy = System.in.read();
        } catch (java.io.IOException e) {
            System.out.println("Input error");
        }
    }

    //********************************
    //  data input methods for
    //string, int, char, and double
    //********************************
    public static String inString(String prompt) {
        inputFlush();
        printPrompt(prompt);
        return inString();
    }

    public static String inString() {
        int aChar;
        String s = "";
        boolean finished = false;

        while (!finished) {
            try {
                aChar = System.in.read();
                if (aChar < 0 || (char) aChar == '\n')
                    finished = true;
                else if ((char) aChar != '\r')
                    s = s + (char) aChar; // Enter into string
            }

            catch (java.io.IOException e) {
                System.out.println("Input error");
                finished = true;
            }
        }
        return s;
    }

    public static int inInt(String prompt) {
        while (true) {
            inputFlush();
            printPrompt(prompt);
            try {
                return Integer.valueOf(inString().trim()).intValue();
            }

            catch (NumberFormatException e) {
                System.out.println("Invalid input. Not an integer");
            }
        }
    }

    public static char inChar(String prompt) {
        int aChar = 0;

        inputFlush();
        printPrompt(prompt);

        try {
            aChar = System.in.read();
        }

        catch (java.io.IOException e) {
            System.out.println("Input error");
        }
        inputFlush();
        return (char) aChar;
    }

    public static double inDouble(String prompt) {
        while (true) {
            inputFlush();
            printPrompt(prompt);
            try {
                return Double.valueOf(inString().trim()).doubleValue();
            }

            catch (NumberFormatException e) {
                System.out
                        .println("Invalid input. Not a floating point number");
            }
        }
    }
}