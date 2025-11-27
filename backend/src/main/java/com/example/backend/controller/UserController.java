package com.example.backend.controller;

import com.example.backend.dto.ApiResponse;
import com.example.backend.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private List<User> users = new ArrayList<>();

    // GET 1
    @GetMapping
    public ApiResponse<List<User>> getUsers() {
        return ApiResponse.success(users);
    }

    // GET 2
    @GetMapping("/{id}")
    public ApiResponse<User> getUserById(@PathVariable Integer id) {

        for (User u : users) {
            if (u.getId().equals(id)) {
                return ApiResponse.success(u);
            }
        }

        return ApiResponse.error("User not found");
    }

    // POST 1
    @PostMapping
    public ApiResponse<User> createUser(@RequestBody User user) {
        if (user.getName() == null || user.getName().isBlank()) {
            return ApiResponse.error("Name is required");
        }

        // Simple ID generator
        int newId = users.size() + 1;
        user.setId(newId);

        users.add(user);

        return ApiResponse.success(user);
    }

    // Post 2
    @PostMapping("/crash")
    public ApiResponse<String> crashServer() {
        throw new RuntimeException("Simulated server crash");
    }

    // PUT 1
    @PutMapping("/{id}")
    public ApiResponse<User> updateUser(@PathVariable Integer id, @RequestBody User updatedUser) {

        for (User u : users) {
            if (u.getId().equals(id)) {
                u.setName(updatedUser.getName());
                return ApiResponse.success(u);
            }
        }

        return ApiResponse.error("User not found");
    }

    // PUT 2
    @PutMapping("/validate")
    public ApiResponse<String> validateUser(@RequestBody User user) {

        if (user.getName() == null || user.getName().isBlank()) {
            return ApiResponse.error("Invalid user: name field is missing");
        }

        return ApiResponse.success("User is valid");
    }


    // DELETE 1
    @DeleteMapping("/{id}")
    public ApiResponse<String> deleteUser(@PathVariable Integer id) {

        for (User u : users) {
            if (u.getId().equals(id)) {
                users.remove(u);
                return ApiResponse.success("User deleted");
            }
        }

        return ApiResponse.error("User not found");
    }

    // DELETE 2
    @DeleteMapping("/crash")
    public ApiResponse<String> deleteCrash() {
        throw new RuntimeException("Simulated delete crash");
    }


}
