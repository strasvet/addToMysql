package com.company.view.my.items;


import com.company.model.User;
import com.company.service.UserService;
import com.company.view.MenuEntry;
import com.company.view.my.Keyin;

/**
 * Created by dsrpc on 24.02.2018.
 */

public class Add extends MenuEntry {

    private UserService userService;

    public Add(String title, UserService userService) {
        super(title);
        this.userService=userService;
    }

    @Override
    public void run() {
        System.out.println("Add new user");

        User user = new User();
        user.setFirstName(Keyin.inString("Please, enter first name: "));
        user.setLastName(Keyin.inString("Please, enter last name: "));
        user.setUsername(Keyin.inString("Please, enter your username: "));
        userService.save(user);
    }
}
