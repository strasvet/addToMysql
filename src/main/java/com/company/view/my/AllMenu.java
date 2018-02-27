package com.company.view.my;

import com.company.repository.FeedbackRepository;
import com.company.service.UserDetailsService;
import com.company.service.UserService;
import com.company.view.Menu;
import com.company.view.my.items.*;
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
    FeedbackRepository feedbackRepository;


    @Autowired
    Menu menu;

    public void getMenu() {
        //Menu menu = new Menu();
        /*menu.addEntry(new Add("Add new user", userService));
        menu.addEntry(new Update("Update user by ID", userService));
        menu.addEntry(new Delete("Delete user by ID", userService));
        menu.addEntry(new PrintAll("Print All users", userService));
        menu.addEntry(new AddDetails("Add user details by ID", userService, userDetailsService));
        menu.addEntry(new SearchByCity("Search By City", userService, userDetailsService));
        menu.addEntry(new SearchByCountry("Search By Country", userService, userDetailsService));
        menu.addEntry(new PrintAllAndInfo("Print All and Info users", userService));
        menu.addEntry(new PrintUserDetails("Print user details", userService, userDetailsService));*/
        menu.addEntry(new UserMenu("User Menu", userService, userDetailsService));
        menu.addEntry(new PrintMenu("Print & Search Menu", userService, userDetailsService));
        menu.addEntry(new FeedbackMenu("Feedback menu", userService, userDetailsService, feedbackRepository));
        menu.addEntry(new Exit("Exit"));
        menu.run();
    }
}
