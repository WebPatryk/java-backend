package com.example.demo;


import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class NewUser {

    @RequestMapping(
            value = "/api/user/create",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE

    )
    @ResponseBody
    public UserService createUser(@RequestBody UserService user) {
        //TODO: odwołanie do serwisu
        return user;
    }
}
