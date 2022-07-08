package com.example.demo.repository;

import com.example.demo.model.CarParts;
import com.example.demo.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {

    void deleteProfileById(Long id);

    @Override
    Optional<Profile> findById(Long aLong);

    Optional<Profile> getProfileById(Long id);
}
