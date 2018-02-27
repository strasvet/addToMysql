package com.company.view.my;

import com.company.repository.FeedbackRepository;
import com.company.service.UserDetailsService;
import com.company.service.UserService;
import com.company.view.Menu;
import com.company.view.MenuEntry;
import com.company.view.my.items.*;

/**
 * Created by dsrpc on 24.02.2018.
 */

public class FeedbackMenu extends MenuEntry {

    UserService userService;

    UserDetailsService userDetailsService;

    FeedbackRepository feedbackRepository;

    public FeedbackMenu(String title, UserService userService, UserDetailsService userDetailsService, FeedbackRepository feedbackRepository) {
        super(title);
        this.userService=userService;
        this.userDetailsService=userDetailsService;
        this.feedbackRepository=feedbackRepository;
    }
    @Override
    public void run() {
        Menu menu = new Menu();
        menu.addEntry(new AddFeedback("Add Feedback", feedbackRepository, userService));
        menu.addEntry(new PrintAllFeedback("Print All Feedbacks", feedbackRepository));
        menu.addEntry(new Exit("Return to main menu"));
        /*menu.addEntry(new Add("Add new user", userService));
        menu.addEntry(new AddDetails("Add user details by ID", userService, userDetailsService));
        menu.addEntry(new Update("Update user by ID", userService));
        menu.addEntry(new Delete("Delete user by ID", userService));
        menu.addEntry(new Exit("Return to main menu"));
        */
        menu.run();
    }
}
