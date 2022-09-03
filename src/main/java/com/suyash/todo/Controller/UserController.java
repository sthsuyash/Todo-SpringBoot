package com.suyash.todo.Controller;

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
    public ResponseEntity<User> addUser(@RequestBody User user) {
        return new ResponseEntity<User>(userService.addUser(user), HttpStatus.CREATED);
    }

    // get specific user by id
    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable Long userId) {
        return new ResponseEntity<User>(userService.getUserById(userId), HttpStatus.OK);
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
