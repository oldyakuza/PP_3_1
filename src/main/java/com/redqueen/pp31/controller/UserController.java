package com.redqueen.pp31.controller;

import com.redqueen.pp31.model.User;
import com.redqueen.pp31.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    private final UserService userService;
    public UserController(UserService userService) { this.userService = userService; }

    @GetMapping("/")
    public String viewIndex(Model model) {
        model.addAttribute("allUsers", userService.getAllUsers());
        return "index";
    }

    @GetMapping("/showNewUserForm")
    public String showNewUserForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "new_user";
    }

    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/";
    }

    @GetMapping("/showUpdateForm/{id}")
    public String showUpdateForm(@PathVariable(value = "id") long id, Model model) {
        User user = userService.getUser(id);
        model.addAttribute("user", user);
        return "update_user";
    }

    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable(value = "id") long id) {
        userService.deleteUser(id);
        return "redirect:/";
    }
}
