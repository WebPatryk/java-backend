package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.*;


@RestController
public class UserController {

    private HashMap<Integer, String> allUsers(){
        ArrayList<Object> al = new ArrayList<Object>();
        HashMap<Integer, String> map1 = new HashMap<Integer, String>();
        map1.put(1, "Antonio");
        map1.put(2, "Michael");

        al.add(map1);

        return map1;
    }
    @GetMapping("/users")
    public HashMap<Integer, String> getUsers() {
        return allUsers();
    }

    @GetMapping("/users/{id}/get")
    public String getUser(@PathVariable Integer id) {
        return allUsers().get(id);
    }

    @GetMapping("/users/{id}/remove")
    public String removeUser(@PathVariable Integer id) {
        return allUsers().remove(id);
    }
    @GetMapping("/user/add")
    @ResponseBody
    public String addUser(@PathVariable String name) {
         allUsers().put(3,name);
        return allUsers().get(3);

    }
}