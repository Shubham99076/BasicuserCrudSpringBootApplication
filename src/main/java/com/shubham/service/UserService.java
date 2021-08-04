package com.shubham.service;

import com.shubham.model.User;
import java.util.List;

public interface UserService {

    List<User> getAllUsers();
    User getUserById(Integer id);
    public void deleteUserss(Integer id);
    public User saveUsers(User product);
}
