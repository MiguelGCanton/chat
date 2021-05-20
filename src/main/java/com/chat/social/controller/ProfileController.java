package com.chat.social.controller;

import java.util.List;

import javax.validation.Valid;

import com.chat.social.entity.Profile;
import com.chat.social.service.ProfileService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController()
@RequestMapping("/profiles")
public class ProfileController {
    @Autowired 
    ProfileService profileService;

    @GetMapping
    public ResponseEntity<List<Profile>> listAllProfiles() {
        List<Profile> profiles = profileService.getProfiles();
        return  ResponseEntity.ok(profiles);
    }

    @PostMapping
    public ResponseEntity<Profile> createProfile(@Valid @RequestBody Profile profile) {
        Profile newProfile = profileService.createProfile(profile);
        return  ResponseEntity.status( HttpStatus.CREATED).body(newProfile);
    }

}
