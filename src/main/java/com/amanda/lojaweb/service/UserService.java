package com.amanda.lojaweb.service;

import com.amanda.lojaweb.model.UserModel;
import com.amanda.lojaweb.model.UserRole;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.apache.catalina.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    private static List<UserModel> users = new ArrayList<>();

    private final PasswordEncoder passwordEncoder;

    @PostConstruct
    public void postConstruct() {
        UserModel user = new UserModel();
        user.setRole(UserRole.ADMIN);
        user.setUsername("admin");
        user.setPassword(passwordEncoder.encode("admin"));
        users.add(user);
    }

    public void register(UserModel user) {
        user.setRole(UserRole.USER);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        users.add(user);
    }

    public UserModel findByLogin(String login){
        return users.stream().filter(user -> user.getUsername().equals(login)).findFirst().orElse(null);
    }
}
