package com.example.small_rest_app.service;

import com.example.small_rest_app.entity.User;
import com.example.small_rest_app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Long id) {
       Optional<User> user =  userRepository.findById(id);
       if(user.isPresent()){
           return user.get();
       }
       //TODO Make exception
       return null;
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User update(User user,Long id) {
        User existingUser = findById(id);
        existingUser.setUserName(user.getUserName());
        existingUser.setId(user.getId());
        existingUser.setPassword(user.getPassword());
        return userRepository.save(existingUser);
    }

    @Override
    public User delete(Long id) {
        User user = findById(id);
        if (user != null){
            userRepository.delete(user);
        }
        //TODO Make Exception
        return null;
    }
}
