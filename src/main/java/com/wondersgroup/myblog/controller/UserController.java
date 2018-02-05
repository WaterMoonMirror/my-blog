package com.wondersgroup.myblog.controller;

import com.wondersgroup.myblog.domain.User;
import com.wondersgroup.myblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;
    @GetMapping("/index")
    public String index(Model model){


        init();

        List<User> query = userService.query();
        model.addAttribute("users", query);
        return "index";
    }
    @GetMapping("/query/{page}")
    public  String queryPage(Model model,@PathVariable("page")Integer page){
        init();
        Page<User> page1 = userService.queeryPage(page);
        model.addAttribute("page",page1);
        return "index";
    }

    public void  init(){
        List<User> users=new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            users.add(new User("test"+1,100-i));
        }
        userService.save(users);
    }

}
