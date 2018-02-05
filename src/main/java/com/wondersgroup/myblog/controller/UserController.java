package com.wondersgroup.myblog.controller;

import com.wondersgroup.myblog.domain.User;
import com.wondersgroup.myblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.jws.WebParam;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @GetMapping("/index")
    public String index(Model model){
        List<User> query = userService.query();
        model.addAttribute("users", query);
        return "index";
    }
    @GetMapping("/query/{page}")
    public  String queryPage(Model model,@PathVariable("page")Integer page){
        Page<User> page1 = userService.queeryPage(page);
        model.addAttribute("page",page1);
        return "index";
    }

    /**
     * 根据id查询一条数据
     * @param model
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public  String getById(Model model,@PathVariable("id")Integer id){
        model.addAttribute("user",userService.getById(id));
        return "view";
    }
    @PostMapping
    public String saveOrUpdate(User user){
        userService.save(user);
       return "redirect:/user/query/0";
    }

    @GetMapping("/form")
    public  String form(Model model){
        model.addAttribute("user",new User());
        return "edit";
    }

    @GetMapping("/form/{id}")
    public  String edit(Model model,@PathVariable("id")Integer id){
        model.addAttribute("user",userService.getById(id));
        return "edit";
    }



}
