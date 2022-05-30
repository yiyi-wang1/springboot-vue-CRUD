package com.example.yiyi.javaspringbootdemo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;


    @GetMapping(value="/")
    List<User> finAll(){
        return userRepository.findAll();
    }

    @GetMapping(value="/{id}")
    User findById(@PathVariable int id){
        return userRepository.findById(id).orElse(null);
    }

    @PostMapping(value="/")
    User createUser(@RequestBody User user){
        return userRepository.save(user);
    }

    @PutMapping(value="/{id}")
    User updateUser(@PathVariable int id, @RequestBody User user){
        User oldUser = userRepository.findById(id).orElse(null);
        oldUser.setName(user.getName());
        oldUser.setEmail(user.getEmail());
        oldUser.setPassword(user.getPassword());
        return userRepository.save(oldUser);
    }

    @DeleteMapping(value="/{id}")
    Integer deleteUser(@PathVariable int id){
       userRepository.deleteById(id);
       return id;
    }

}
