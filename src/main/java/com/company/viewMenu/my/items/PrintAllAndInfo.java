package com.company.viewMenu.my.items;


import com.company.model.User;
import com.company.service.UserService;
import com.company.viewMenu.MenuEntry;

import java.util.List;

/**
 * Created by dsrpc on 24.02.2018.
 */

public class PrintAllAndInfo extends MenuEntry {

    private UserService userService;

    public PrintAllAndInfo(String title, UserService userService) {
        super(title);
        this.userService=userService;
    }

    @Override
    public void run() {
        System.out.println("Print All and all info about all Users");
        //List<User> users = userService.findAll();
        //System.out.println(users);
        //System.out.println(result);
        /*for(String str:result.toArray()){

        }*/
        //System.out.println(userService.findAllAndInfo());
        List result = userService.findAllAndInfo();
        result.stream().forEach(x->System.out.println(x.toString()));
        return ;
    }
}
