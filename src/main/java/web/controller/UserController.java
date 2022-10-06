package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import web.model.User;
import web.service.UserService;


@Controller
public class UserController {
    private final UserService userService;
    private final String HOME_PAGE = "redirect:/users";

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/")
    public String homePage() {
        return HOME_PAGE;
    }

    @GetMapping(value = "/users")
    public String getAllUser(Model model) {
        model.addAttribute("listUsers", userService.getAllUsers());
        return "users-page";
    }

    @GetMapping("/user-create")
    public String createUserForm(User user){
        return "user-create-page";
    }

    @GetMapping("/users-truncate")
    public String truncateTable(){
        userService.truncateTable();
        return "users-page";
    }

    @PostMapping("/touch-user")
    public String createUser(User user){
        userService.saveUser(user);
        return HOME_PAGE;
    }

    @GetMapping("user-delete/{id}")
    public String deleteUser(@PathVariable("id") Long id){
        userService.removeUserById(id);
        return HOME_PAGE;
    }

    @GetMapping("/user-update/{id}")
    public String updateUserForm(@PathVariable("id") Long id, Model model){
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "user-update-page";
    }

    @PostMapping("/user-update")
    public String updateUser(User user){
        userService.updateUser(user);
        return HOME_PAGE;
    }
}