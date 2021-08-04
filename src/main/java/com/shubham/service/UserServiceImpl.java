package com.shubham.service;

import com.shubham.model.User;
import com.shubham.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserRepo userRepo;

    @Autowired
    public void setUserRepo(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public User getUserById(Integer id) {
        return userRepo.getOne(id);
    }

    @Override
    public void deleteUserss(Integer id) {
        userRepo.deleteById(id);
    }

    @Override
    public User saveUsers(User users) {
        return userRepo.save(users);
    }
}
