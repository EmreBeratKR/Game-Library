package com.scpg.gamelibrary.api.controller;

import com.scpg.gamelibrary.business.abstracts.IUserService;
import com.scpg.gamelibrary.entities.concretes.User;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController @RequestMapping("api/users")
@RequiredArgsConstructor
public class UserController
{
    private final IUserService userService;


    @GetMapping("/getall")
    public List<User> getAll()
    {
        return this.userService.getAll();
    }

    @GetMapping("/getbyid")
    public User getById(@RequestParam int id)
    {
        return this.userService.getById(id);
    }

    @GetMapping("/getbyusername")
    public User getByUsername(@RequestParam String username)
    {
        return this.userService.getByUsername(username);
    }

    @GetMapping("/register")
    public User Register(@RequestParam int id, @RequestParam String name, @RequestParam String password)
    {
        return userService.add(new User(id, name, password));
    }

    @GetMapping("/deletebyid")
    public void DeleteById(@RequestParam int id)
    {
        userService.remove(userService.getById(id));
    }
}
