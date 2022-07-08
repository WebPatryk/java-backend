package com.example.demo.service;

import com.example.demo.exception.UserNotFoundException;
import com.example.demo.model.Basket;
import com.example.demo.model.CarParts;
import com.example.demo.model.Profile;
import com.example.demo.repository.BasketRepository;
import com.example.demo.repository.CarPartsRepository;
import com.example.demo.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class ProfileService {

    private final ProfileRepository profileRepository;

    @Autowired
    public ProfileService(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    public Profile addToProfile(Profile profile) {


        profile.setName(profile.getName());
        profile.setPassword(profile.getPassword());
        profile.setEmail(profile.getEmail());
        return profileRepository.save(profile);
    }

    public List<Profile> findAllProfile() {
        return profileRepository.findAll();
    }

    public Profile updateProfile(Long id, Profile profile) {
        Profile profileUpdate = profileRepository.getProfileById(id).orElseThrow(() -> new UserNotFoundException("Profile by id " + id + " was not found"));

        profileUpdate.setName(profile.getName());
        profileUpdate.setPassword(profile.getPassword());
        profileUpdate.setEmail(profile.getEmail());

        return profileRepository.save(profileUpdate);

    }

    public Profile findProfileById(Long id) {
        return profileRepository.getProfileById(id)
                .orElseThrow(() -> new UserNotFoundException("Car part by id " + id + " was not found"));
    }

    public void deleteProfile(Long id){
        profileRepository.deleteProfileById(id);
    }

}
