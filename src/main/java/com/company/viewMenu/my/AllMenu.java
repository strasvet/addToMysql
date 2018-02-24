package com.company.viewMenu.my;

import com.company.service.UserDetailsService;
import com.company.service.UserService;
import com.company.viewMenu.Menu;
import com.company.viewMenu.my.items.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by dsrpc on 24.02.2018.
 */
@Component
public class AllMenu {
    @Autowired
    UserService userService;
    @Autowired
    UserDetailsService userDetailsService;
    @Autowired
    Menu menu;

    public void getMenu() {
        //Menu menu = new Menu();
        menu.addEntry(new Add("Add new user", userService));
        menu.addEntry(new AddDetails("Add user details by ID", userService, userDetailsService));
        menu.addEntry(new SearchByCity("Search By City", userService, userDetailsService));
        menu.addEntry(new SearchByCountry("Search By Country", userService, userDetailsService));
        menu.addEntry(new Update("Update user by ID", userService));
        menu.addEntry(new Delete("Delete user by ID", userService));
        menu.addEntry(new PrintAll("Print All users", userService));
        menu.addEntry(new PrintAllAndInfo("Print All and Info users", userService));
        menu.addEntry(new PrintUserDetails("Print user details", userService, userDetailsService));
        menu.run();
    }
}