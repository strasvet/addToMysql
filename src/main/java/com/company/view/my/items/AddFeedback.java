package com.company.view.my.items;


import com.company.model.Feedback;
import com.company.model.User;
import com.company.repository.FeedbackRepository;
import com.company.service.UserService;
import com.company.view.MenuEntry;
import com.company.view.my.Keyin;

import java.util.Date;

/**
 * Created by dsrpc on 24.02.2018.
 */

public class AddFeedback extends MenuEntry {

    private FeedbackRepository feedbackRepository;
    private UserService userService;

    public AddFeedback(String title, FeedbackRepository feedbackRepository, UserService userService) {
        super(title);
        this.feedbackRepository=feedbackRepository;
        this.userService=userService;
    }

    @Override
    public void run() {
        System.out.println("Add new feedback");

        User userf = userService.findById(Keyin.inInt("Please, enter user id"));
        if(userf==null) {
            System.err.println("User by ID not found!");
            return;
        }else {
            Feedback feedback = new Feedback();
            feedback.setTitle(Keyin.inString("Please, write your title of feedback "));
            feedback.setContent(Keyin.inString("Please, write your feedback "));
            feedback.setCreatedOn(new Date());
            feedback.setRate(Keyin.inInt("Please, rate you feedback"));
            feedback.setUser(userf);
            feedbackRepository.save(feedback);
        }
        /*User user = new User();
        user.setFirstName(Keyin.inString("Please, enter first name: "));
        user.setLastName(Keyin.inString("Please, enter last name: "));
        user.setUsername(Keyin.inString("Please, enter your username: "));
        userService.save(user);*/
    }
}
