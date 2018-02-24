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

public class PrintMenu extends MenuEntry {

    UserService userService;

    UserDetailsService userDetailsService;

    public PrintMenu(String title, UserService userService, UserDetailsService userDetailsService) {
        super(title);
        this.userService=userService;
        this.userDetailsService=userDetailsService;
    }
    @Override
    public void run() {
        Menu menu = new Menu();
        menu.addEntry(new SearchByCity("Search By City", userService, userDetailsService));
        menu.addEntry(new SearchByCountry("Search By Country", userService, userDetailsService));
        menu.addEntry(new PrintAll("Print All users", userService));
        //menu.addEntry(new PrintAllAndInfo("Print All and Info users", userService));
        menu.addEntry(new PrintUserDetails("Print user details", userService, userDetailsService));
        menu.addEntry(new Exit("Return to main menu"));
        menu.run();
    }
}
