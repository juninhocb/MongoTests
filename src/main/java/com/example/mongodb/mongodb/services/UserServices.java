package com.example.mongodb.mongodb.services;

import com.example.mongodb.mongodb.domain.User;
import com.example.mongodb.mongodb.dto.UserDTO;
import com.example.mongodb.mongodb.repository.UserRepository;
import com.example.mongodb.mongodb.services.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class UserServices {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }
    public User findById(String id){
        Optional<User> user = userRepository.findById(id);
        return user.orElseThrow(() -> new UserNotFoundException("User was not found"));
    }

    public void create(User user){
        userRepository.save(user);
    }

    public void delete(String id){
        userRepository.deleteById(id);
    }

    public User getUserFromDto(UserDTO userDto){
        User user = new User(userDto.getId(), userDto.getName(), userDto.getEmail());
        return user;
    }


}
