package com.example.demo.controller;

import com.example.demo.model.Profile;
import com.example.demo.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/profile")
@CrossOrigin
public class ProfileController {
    @Autowired
    private ProfileService profileService;



    @GetMapping("/getAll")
    public ResponseEntity<List<Profile>> getAllProfile () {
        List<Profile> profile = profileService.findAllProfile();
        return new ResponseEntity<>(profile, HttpStatus.OK);
    }


    @GetMapping("/find/{id}")
    public ResponseEntity<Profile> getCarPartById (@PathVariable("id") Long id) {
        Profile profile = profileService.findProfileById(id);
        return new ResponseEntity<>(profile, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Profile> addProfile(@RequestBody Profile profile) {
        Profile newProfile = profileService.addToProfile(profile);
        return new ResponseEntity<>(newProfile, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Profile> updateCarPart(@PathVariable("id") Long id,@RequestBody Profile carParts) {
        Profile updateCarPart = profileService.updateProfile(id, carParts);
        return new ResponseEntity<>(updateCarPart, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCarPart(@PathVariable("id") Long id) {
        profileService.deleteProfile(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }


}
