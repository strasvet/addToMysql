package com.company.view.my.items;


import com.company.model.User;
import com.company.model.UserDetails;
import com.company.service.UserDetailsService;
import com.company.service.UserService;
import com.company.view.MenuEntry;
import com.company.view.my.Keyin;

/**
 * Created by dsrpc on 24.02.2018.
 */

public class AddDetails extends MenuEntry {

    private UserDetailsService userDetailsService;
    private UserService userService;

    public AddDetails(String title, UserService userService, UserDetailsService userDetailsService) {
        super(title);
        this.userService=userService;
        this.userDetailsService=userDetailsService;
    }

    @Override
    public void run() {
        System.out.println("Add user details by id");
        User userf = userService.findById(Keyin.inInt("Please, enter user id"));
        if(userf==null) {
            System.err.println("User by ID not found!");
            return;
        }else{
            UserDetails userDetails = new UserDetails();
            userDetails.setUser(userf);
            userDetails.setCity(Keyin.inString("Please, enter city name: "));
            userDetails.setCountry(Keyin.inString("Please, enter country name: "));
            userDetails.setAddress(Keyin.inString("Please, enter street name: "));
            userDetailsService.save(userDetails);
        }
    }
}
