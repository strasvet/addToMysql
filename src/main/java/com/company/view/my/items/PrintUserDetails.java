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

public class PrintUserDetails extends MenuEntry {

    private UserDetailsService userDetailsService;
    private UserService userService;

    public PrintUserDetails(String title, UserService userService, UserDetailsService userDetailsService) {
        super(title);
        this.userService=userService;
        this.userDetailsService=userDetailsService;
    }

    @Override
    public void run() {
        System.out.println("Print user details");
        //List<User> users = userService.findAll();
        //System.out.println(users);
        User useru = userService.findById(Keyin.inInt("Please, enter user id"));
        if(useru==null) {
            System.err.println("User by ID not found!");
            return;
        }
        UserDetails ud = userDetailsService.getByUserId(useru.getId());
        if(ud==null){
            System.err.println("User not have user details");
            return;
        }else{
            System.out.println(ud);
        }
        return;
    }
}
