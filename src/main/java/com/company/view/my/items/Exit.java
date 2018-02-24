package com.company.view.my.items;


import com.company.model.User;
import com.company.service.UserService;
import com.company.view.Menu;
import com.company.view.MenuEntry;
import com.company.view.my.Keyin;

/**
 * Created by dsrpc on 24.02.2018.
 */

public class Exit extends MenuEntry {

    public Exit(String title) {
        super(title);

    }

    @Override
    public void run() {
        System.out.println("Exit");
    }
    @Override
    public boolean isExit(){
        return true;
    }
}
