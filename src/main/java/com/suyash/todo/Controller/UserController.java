package com.suyash.todo.Controller;

import com.suyash.todo.DTO.UserDTO;
import com.suyash.todo.Entity.User;
import com.suyash.todo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    // create new user
    @PostMapping("/register")
    public ResponseEntity<User> addUser(@RequestBody UserDTO userDTO) {
        return new ResponseEntity<>(userService.addUser(userDTO), HttpStatus.CREATED);
    }

    // get all users
    @GetMapping
    public ResponseEntity<Iterable<User>> getAllUsers() {
        return new ResponseEntity<Iterable<User>>(userService.getAllUsers(), HttpStatus.OK);
    }

    // get specific user by id
    @GetMapping("/{userId}")
    public UserDTO getUserById(@PathVariable Long userId) {
        return userService.getUserById(userId);
    }

    // edit user by id
    @PutMapping("/edit/{userId}")
    public ResponseEntity<User> editUserById(@PathVariable Long userId, @RequestBody User user) {
        return new ResponseEntity<User>(userService.editUserById(userId, user), HttpStatus.OK);
    }

    // delete specific user by id
    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<User> deleteUserById(@PathVariable Long userId) {
        return new ResponseEntity<User>(userService.deleteUserById(userId), HttpStatus.OK);
    }

}
