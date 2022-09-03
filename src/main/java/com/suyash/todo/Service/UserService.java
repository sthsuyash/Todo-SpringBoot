package com.suyash.todo.Service;

import com.suyash.todo.Entity.User;
import com.suyash.todo.Exception.UserNameAlreadyTakenException;
import com.suyash.todo.Exception.UserNameNotFoundException;
import com.suyash.todo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // create new user
    public User addUser(User user) {
        User userToFind = userRepository.findByUsername(user.getUsername());
        if (userToFind != null) {
            throw new UserNameAlreadyTakenException("User already exists");
        }
        return userRepository.save(user);
    }

    // get specific user by id
    public User getUserById(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNameNotFoundException("User not found"));
        return user;
    }

    // edit user by id
    public User editUserById(Long userId, User user) {
        User userToEdit = userRepository.findById(userId)
                .orElseThrow(() -> new UserNameNotFoundException("User not found"));

        if (userRepository.findByUsername(userToEdit.getUsername()) != null) {
            throw new UserNameAlreadyTakenException("User already exists");
        }

        userToEdit.setUsername(user.getUsername());
        userToEdit.setPassword(user.getPassword());

        return userRepository.save(userToEdit);
    }

    // delete specific user by id
    public User deleteUserById(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNameNotFoundException("User not found"));
        userRepository.delete(user);
        return user;
    }
}
