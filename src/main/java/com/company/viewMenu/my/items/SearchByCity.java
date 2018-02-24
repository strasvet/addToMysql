package com.company.viewMenu.my.items;


import com.company.model.User;
import com.company.model.UserDetails;
import com.company.service.UserDetailsService;
import com.company.service.UserService;
import com.company.viewMenu.MenuEntry;
import com.company.viewMenu.my.Keyin;

/**
 * Created by dsrpc on 24.02.2018.
 */

public class SearchByCity extends MenuEntry {

    private UserDetailsService userDetailsService;
    private UserService userService;

    public SearchByCity(String title, UserService userService, UserDetailsService userDetailsService) {
        super(title);
        this.userService=userService;
        this.userDetailsService=userDetailsService;
    }

    @Override
    public void run() {
        System.out.println("Search by City");
        //User userf = userService.findById(Keyin.inInt("Please, enter user id"));
        UserDetails userDetails = userDetailsService.searchByCity(Keyin.inString("Please, enter city name: "));
        if(userDetails==null) {
            System.err.println("Not found!");
            return;
        }else{
            System.out.println(userDetails);
        }
    }
}
