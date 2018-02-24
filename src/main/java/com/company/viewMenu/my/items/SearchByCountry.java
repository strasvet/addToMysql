package com.company.viewMenu.my.items;


import com.company.model.UserDetails;
import com.company.service.UserDetailsService;
import com.company.service.UserService;
import com.company.viewMenu.MenuEntry;
import com.company.viewMenu.my.Keyin;

/**
 * Created by dsrpc on 24.02.2018.
 */

public class SearchByCountry extends MenuEntry {

    private UserDetailsService userDetailsService;
    private UserService userService;

    public SearchByCountry(String title, UserService userService, UserDetailsService userDetailsService) {
        super(title);
        this.userService=userService;
        this.userDetailsService=userDetailsService;
    }

    @Override
    public void run() {
        System.out.println("Search by Country");
        //User userf = userService.findById(Keyin.inInt("Please, enter user id"));
        UserDetails userDetails = userDetailsService.searchByCountry(Keyin.inString("Please, enter country name: "));
        if(userDetails==null) {
            System.err.println("Not found!");
            return;
        }else{
            System.out.println(userDetails);
        }
    }
}
