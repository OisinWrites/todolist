package com.example.todolist.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.todolist.model.User;
import com.example.todolist.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // Show sign-up page
    @GetMapping("/signup")
    public String showSignupPage(Model model) {
        model.addAttribute("user", new User());
        return "index"; // Thymeleaf template for sign-up page
    }

    // Handle sign-up form submission
    @PostMapping("/signup")
    public String registerUser(
        @RequestParam String email,
        @RequestParam String username,
        @RequestParam String password,
        @RequestParam String passwordConfirm,
        Model model
    ) {
        // Check if username already exists
        if (userService.findByUsername(username) != null) {
            model.addAttribute("error", "Username already exists!");
            return "index"; // Stay on signup page
        }

        // Check if email already exists
        if (userService.findByEmail(email) != null) {
            model.addAttribute("error", "Email already registered!");
            return "index"; // Stay on signup page
        }

        // Check if passwords match
        if (!password.equals(passwordConfirm)) {
            model.addAttribute("error", "Passwords do not match!");
            return "index"; // Stay on signup page
        }

        // Register the user
        User newUser = new User(username, password, email);
        userService.save(newUser); // Use the save method from UserService

        return "redirect:/"; // Redirect to login page after successful registration
    }

    // Show login page
    @GetMapping("/login")
    public String showLoginPage() {
        return "index"; // Thymeleaf template for login page
    }

    // Handle login form submission
    @PostMapping("/login")
    public String loginUser(
        @RequestParam String email,
        @RequestParam String password,
        Model model,
        HttpSession session
    ) {
        User user = userService.findByEmail(email);

        // Check if user exists and password is correct
        if (user == null || !passwordEncoder.matches(password, user.getPassword())) {
            model.addAttribute("error", "Invalid email or password");
            return "index"; // Stay on login page in case of error
        }

        // Store user details in the session
        session.setAttribute("loggedInUser", user.getUsername());

        return "redirect:/"; // Redirect to home/dashboard page
    }

    // Handle request to get all users
    @GetMapping("/all")
    public ResponseEntity<Map<Long, User>> getAllUsers() {
        Map<Long, User> usersMap = userService.getAllUsersAsMap();
        return ResponseEntity.ok(usersMap);
    }

    @GetMapping("/users")
    public String showAllUsers(Model model) {
        Map<Long, User> usersMap = userService.getAllUsersAsMap();
        model.addAttribute("users", usersMap.values()); // Add the list of users to the model
        return "index"; // Redirect to Thymeleaf template "users.html"
}
}
