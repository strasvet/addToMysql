package com.company.service;

import com.company.model.User;
import com.company.model.UserDetails;
import com.company.repository.UserDetailsRepository;
import com.company.repository.UserRepository;
import com.company.view.main.DemoMenu;
import com.company.viewMenu.Menu;
import com.company.viewMenu.my.MMM;
import com.company.viewMenu.my.Prints;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class ApplicationRunner {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserDetailsRepository userDetailsRepository;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    DemoMenu demoMenu;

    @Autowired
    MMM mmm;


    @Transactional
    @SneakyThrows
  public void Menu()  {
    //    demoMenu.main();
 /*       Menu menu = new Menu();
        menu.addEntry(new Prints("MYMENUS"));
        menu.run();*/
        mmm.getMenu();
    }

    @Transactional
    public void save() {
        User user_1 = User.builder()
                .firstName("Peter")
                .lastName("Dale")
                .username("peter_dale")
                .build();

        User user_2 = User.builder()
                .firstName("Martin")
                .lastName("Yale")
                .username("martin_yale")
                .build();

        //userRepository.save(user_1);
        userService.save(user_1);

        user_1.setUsername("tel-ran");
        userService.save(user_2);
        //userRepository.save(user_2);

        System.out.println(user_1);
        System.out.println(user_2);

        UserDetails userDetails = UserDetails.builder()
                .user(user_1)
                .city("Rehovot")
                .country("Israel")
                .address("PLAUT STREET 7")
                .build();

        //userDetailsRepository.save(userDetails);
        userDetailsService.save(userDetails);
        UserDetails userDetails2 = UserDetails.builder()
                .user(user_2)
                .city("Petah Tikva")
                .country("Israel")
                .address("Djabotinsky 78")
                .build();

        //userDetailsRepository.save(userDetails);
        userDetailsService.save(userDetails2);



        UserDetails userDetails1 = userDetailsService.getByUserId(1);
        System.out.println(userDetails1);
    }

    @Transactional
    public void updateUser() {
        //todo COMMENT THIS OUT TO SEE HOW IT WORKS

//        User user_1 = userRepository.findById(1);
//        user_1.setFirstName("David");
//        user_1.setLastName("Davids");
//        user_1.setUsername("david_davids");

//        userRepository.update(user_1);

//        System.out.println(user_1);
    }

    @Transactional
    public void printAll() {
        //List<User> users = userRepository.findAll();
        List<User> users = userService.findAll();
        System.out.println(users);
    }


}
