package com.company.viewMenu.my;

import com.company.model.User;
import com.company.service.UserService;
import com.company.viewMenu.Menu;
import com.company.viewMenu.MenuEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by dsrpc on 24.02.2018.
 */
@Component
public class MMM {
    @Autowired
    UserService userService;

    @Autowired
    Menu menu;
    public void getMenu() {

        //Menu menu = new Menu();

        menu.addEntry(new Prints("MYMENUS"));
        menu.addEntry(new MenuEntry("22222") {
            @Override
            public void run() {
                System.out.println("MY MENUS DEISTVIE!");

                User user = new User();
                user.setFirstName(Keyin.inString("Please, enter first name: "));
                user.setLastName(Keyin.inString("Please, enter last name: "));
                user.setUsername(Keyin.inString("Please, enter your username: "));
                userService.save(user);
            }
        });
        menu.run();
    }
}
