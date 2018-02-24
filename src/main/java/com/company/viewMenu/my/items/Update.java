package com.company.viewMenu.my.items;


import com.company.model.User;
import com.company.service.UserService;
import com.company.viewMenu.MenuEntry;
import com.company.viewMenu.my.Keyin;

/**
 * Created by dsrpc on 24.02.2018.
 */

public class Update extends MenuEntry {

    private UserService userService;

    public Update(String title, UserService userService) {
        super(title);
        this.userService=userService;
    }

    @Override
    public void run() {
        System.out.println("Update User");
        User useru = userService.findById(Keyin.inInt("Please, enter user id"));
        if(useru==null) {
            System.err.println("User by ID not found!");
            return;
        }else{
            useru.setFirstName(Keyin.inString("Please, enter first name: "));
            useru.setLastName(Keyin.inString("Please, enter last name: "));
            useru.setUsername(Keyin.inString("Please, enter your username: "));
            userService.update(useru);
        }
    }
}
