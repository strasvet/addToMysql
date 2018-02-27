package com.company.view.my.items;


import com.company.model.Feedback;
import com.company.model.User;
import com.company.repository.FeedbackRepository;
import com.company.service.UserService;
import com.company.view.MenuEntry;

import java.util.List;

/**
 * Created by dsrpc on 24.02.2018.
 */

public class PrintAllFeedback extends MenuEntry {


    private FeedbackRepository feedbackRepository;

    public PrintAllFeedback(String title, FeedbackRepository feedbackRepository) {
        super(title);
        this.feedbackRepository=feedbackRepository;
    }

    @Override
    public void run() {
        System.out.println("Print All Feedback");
        List<Feedback> feedbacks = feedbackRepository.findAll();
        System.out.println(feedbacks);
        return;
    }
}
