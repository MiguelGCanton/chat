package com.chat.social.service;

import java.util.List;
import java.util.Optional;

import com.chat.social.entity.Profile;
import com.chat.social.repository.ProfileRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {
    
    @Autowired 
    ProfileRepository profileRepository;

    public List<Profile> getProfiles(){
        return profileRepository.findAll();
    }

    public Optional<Profile> getProfileById(int id){
        return profileRepository.findById(id);
    }

    public Profile createProfile(Profile profile){
        profileRepository.save(profile);
        return profile;
    }

}
