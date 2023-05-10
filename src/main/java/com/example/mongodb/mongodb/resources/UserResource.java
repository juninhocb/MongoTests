package com.example.mongodb.mongodb.resources;


import com.example.mongodb.mongodb.domain.User;
import com.example.mongodb.mongodb.dto.UserDTO;
import com.example.mongodb.mongodb.services.UserServices;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value ="/users")
public class UserResource {

    @Autowired
    private UserServices userServices;
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<UserDTO>> findAll(){

        List<User> listUser = userServices.findAll();
        List<UserDTO> listUserDto = new ArrayList<>();
        listUser.forEach(obj -> {
            UserDTO user = new UserDTO(obj);
            listUserDto.add(user);
        });

        return ResponseEntity.ok().body(listUserDto);
    }

    @RequestMapping(value ="/{id}", method = RequestMethod.GET)
    public ResponseEntity<UserDTO> findById(@PathVariable String id){
        User user = userServices.findById(id);
        UserDTO userDto = new UserDTO(user);
        return ResponseEntity.ok().body(userDto);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insertUser(@RequestBody UserDTO userDto){
        User user = userServices.getUserFromDto(userDto);
        userServices.create(user);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(user.getId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteUser(@PathVariable String id){
        userServices.delete(id);
        return ResponseEntity.ok().build();
    }

}
