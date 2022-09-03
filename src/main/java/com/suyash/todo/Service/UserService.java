package com.suyash.todo.Service;

import com.suyash.todo.DTO.UserDTO;
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
    public User addUser(UserDTO userDTO) {
        User userToFind = userRepository.findByUsername(userDTO.getUsername());
        if (userToFind != null) {
            throw new UserNameAlreadyTakenException("User already exists");
        }

        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());

        return userRepository.save(user);
    }

    // get specific user by id
    public UserDTO getUserById(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNameNotFoundException("User not found"));

        UserDTO userDTO = new UserDTO();
        userDTO.setUsername(user.getUsername());
        userDTO.setPassword(user.getPassword());
        return userDTO;
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

    // get all users
    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }
}
