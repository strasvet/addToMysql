package com.company.viewMenu.my.items;


import com.company.model.User;
import com.company.service.UserService;
import com.company.viewMenu.MenuEntry;
import com.company.viewMenu.my.Keyin;

import java.util.List;

/**
 * Created by dsrpc on 24.02.2018.
 */

public class PrintAll extends MenuEntry {

    private UserService userService;

    public PrintAll(String title, UserService userService) {
        super(title);
        this.userService=userService;
    }

    @Override
    public void run() {
        System.out.println("Print All Users");
        List<User> users = userService.findAll();
        System.out.println(users);
        return;
    }
}
