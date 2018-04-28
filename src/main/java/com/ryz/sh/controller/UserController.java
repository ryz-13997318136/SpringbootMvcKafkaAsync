package com.ryz.sh.controller;

import com.ryz.sh.pojo.User;
import com.ryz.sh.repository.UserRepository;
import com.ryz.sh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value="/user/getUserById",method = RequestMethod.GET)
    @ResponseBody
    public User getUserById(@RequestParam String id){
        System.out.println("hello user");
        User u = userService.findUserById(id);
        System.out.println(u);
        return u;
    }
    @RequestMapping(value="/user/foundAll",method = RequestMethod.GET)
    public String getUserById(Model model){
        System.out.println("hello user");
        List<User> users = userService.findAll();
        System.out.println(users);
        model.addAttribute("Users", users );
        return "index";
    }

    @RequestMapping(value="/save",method = RequestMethod.GET)
    @ResponseBody
    public String getUserById(){
        userService.save();
        return "success";
    }
}
