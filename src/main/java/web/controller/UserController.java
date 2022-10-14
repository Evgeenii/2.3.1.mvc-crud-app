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
    private final String USER_PAGE = "users-page";
    private final String USER_CREATE_PAGE = "user-create-page";
    private final String USER_UPDATE_PAGE = "user-update-page";
    private final String REDIRECT_TO_USER_PAGE = "redirect:/users";

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/")
    public String getHomePage() {
        return REDIRECT_TO_USER_PAGE;
    }

    @GetMapping(value = "/users")
    public String getAllUser(Model model) {
        model.addAttribute("listUsers", userService.getAllUsers());
        return USER_PAGE;
    }

    @GetMapping("/user-create")
    public String getUserFormForCreate(User user){
        return USER_CREATE_PAGE;
    }

    @GetMapping("/users-truncate")
    public String getTruncateTable(){
        userService.truncateTable();
        return  USER_PAGE;
    }

    @PostMapping("/touch-user")
    public String createUser(User user){
        userService.saveUser(user);
        return REDIRECT_TO_USER_PAGE;
    }

    @GetMapping("user-delete/{id}")
    public String deleteUser(@PathVariable("id") Long id){
        userService.removeUserById(id);
        return REDIRECT_TO_USER_PAGE;
    }

    @GetMapping("/user-update/{id}")
    public String getUserFormForUpdate(@PathVariable("id") Long id, Model model){
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return USER_UPDATE_PAGE;
    }

    @PostMapping("/user-update")
    public String updateUser(User user){
        userService.updateUser(user);
        return REDIRECT_TO_USER_PAGE;
    }
}