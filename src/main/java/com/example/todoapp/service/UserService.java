package com.example.todoapp.service;

import com.example.todoapp.entity.User;
import com.example.todoapp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.NonUniqueResultException;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User getUser(User user) {
        System.out.println("Service Password");
        return userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
    }
    public boolean getUserByUsername(String username, String password) {
        boolean username_present;
        boolean password_present;
        try {
            username_present = userRepository.findTopByUsername(username) != null ? true : false;
            System.out.println("Username: " + username_present);
            password_present = userRepository.findTopByPassword(password) != null ? true : false;
            System.out.println("Password: " + password_present);
        } catch(NonUniqueResultException nre) {
            return true;
        }
        return username_present && password_present;
    }

    public boolean findUserByUsername(String username) {
        boolean username_present;
        try {
            username_present = userRepository.findTopByUsername(username) != null ? true : false;
            System.out.println("Username (U): " + username_present);
        } catch(NonUniqueResultException nre) {
            return true;
        }
        return username_present;
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }
}
