package com.example.demo;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HomeController {

    public String getUsers(){
        return  "Patryk, Mateusz,Szymek";
    }


    @GetMapping("/api/users")
    @ResponseBody
    public Map<String,String> getApiUsers(@RequestParam(defaultValue = "1", required = false) Integer pageNumber, @RequestParam(required = false) Integer userAmount) {

        HashMap<String, String> map = new HashMap<>();
        map.put("key", "value");
        map.put("foo", "bar");
        map.put("aa", "bb");
        return map;



    }
}
