package com.company.view.my.items;


import com.company.model.User;
import com.company.service.UserService;
import com.company.view.MenuEntry;
import com.company.view.my.Keyin;

/**
 * Created by dsrpc on 24.02.2018.
 */

public class Delete extends MenuEntry {

    private UserService userService;

    public Delete(String title, UserService userService) {
        super(title);
        this.userService=userService;
    }

    @Override
    public void run() {
        System.out.println("Delete User");
        User userd = userService.findById(Keyin.inInt("Please, enter user id"));
        if(userd==null) {
            System.err.println("User by ID not found!");
           return;
        }else{
            userService.deleteUser(userd);
        }
    }
}
