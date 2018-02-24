package com.company.viewMenu.my.items;


import com.company.model.User;
import com.company.service.UserDetailsService;
import com.company.service.UserService;
import com.company.viewMenu.MenuEntry;
import com.company.viewMenu.my.Keyin;

import java.util.List;

/**
 * Created by dsrpc on 24.02.2018.
 */

public class PrintUserDetails extends MenuEntry {

    private UserDetailsService userDetailsService;
    private UserService userService;

    public PrintUserDetails(String title, UserService userService, UserDetailsService userDetailsService) {
        super(title);
        this.userService=userService;
        this.userDetailsService=userDetailsService;
    }

    @Override
    public void run() {
        System.out.println("Print user details");
        //List<User> users = userService.findAll();
        //System.out.println(users);
        User useru = userService.findById(Keyin.inInt("Please, enter user id"));
        if(useru==null) {
            System.err.println("User by ID not found!");
            return;
        }else{
            System.out.println(userDetailsService.getByUserId(useru.getId()));
        }
        return;
    }
}
