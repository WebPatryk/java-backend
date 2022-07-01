//package com.example.demo.controller;
//
//import com.example.demo.model.Profile;
//import com.example.demo.service.ProfileService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;


//@RestController
//@RequestMapping("/profile")
//@CrossOrigin
//public class ProfileController {
//    @Autowired
//    private ProfileService profileService;
//
//
//
//    @GetMapping("/")
//    public ResponseEntity<Profile> getUserData () {
//        Profile profile = profileService.profileData();
//        return new ResponseEntity(profile, HttpStatus.OK);
//    }
//
//}
