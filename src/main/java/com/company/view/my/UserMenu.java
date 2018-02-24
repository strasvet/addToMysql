package com.company.view.my;

import com.company.service.UserDetailsService;
import com.company.service.UserService;
import com.company.view.Menu;
import com.company.view.MenuEntry;
import com.company.view.my.items.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by dsrpc on 24.02.2018.
 */

public class UserMenu extends MenuEntry {

    UserService userService;

    UserDetailsService userDetailsService;

    public UserMenu(String title, UserService userService, UserDetailsService userDetailsService) {
        super(title);
        this.userService=userService;
        this.userDetailsService=userDetailsService;
    }
    @Override
    public void run() {
        Menu menu = new Menu();
        menu.addEntry(new Add("Add new user", userService));
        menu.addEntry(new AddDetails("Add user details by ID", userService, userDetailsService));
        menu.addEntry(new Update("Update user by ID", userService));
        menu.addEntry(new Delete("Delete user by ID", userService));
        menu.addEntry(new Exit("Return to main menu"));
        menu.run();
    }
}
