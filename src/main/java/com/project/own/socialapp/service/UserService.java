package com.project.own.socialapp.service;

import com.project.own.socialapp.model.User;
import com.project.own.socialapp.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class UserService {
    private UserRepository userRepository;

    private User saveUser(User user) {
        return userRepository.save(user);
    }

    @Transactional
    public void deleteUserById(Integer userId) {
        userRepository.delete(Objects.requireNonNull(userRepository.findById(userId).orElse(null)));
    }

    public User findById(Integer userId) {
        return userRepository.findById(userId).orElse(null);
    }

}
