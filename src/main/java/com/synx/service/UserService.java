package com.synx.service;

import com.synx.dao.UserRepository;
import com.synx.model.User;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        for(User user : userRepository.findAll()){
            users.add(user);
        }
        return users;
    }

    public User findUser(int id) {
        return userRepository.findOne(id);
    }

    public void save(User user){
        userRepository.save(user);
    }

    public void delete(int id){
        userRepository.delete(id);
    }
}
