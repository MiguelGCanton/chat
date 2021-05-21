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

    public Profile addFriend(int profileId, int friendId) throws Exception{
        Optional<Profile> profile = getProfileById(profileId);
        Optional<Profile> friend  = getProfileById(friendId);

        if(profileId == friendId ){
            throw new Exception("user can not be his own friend");
        }

        if(!profile.isPresent()){
            throw new Exception("profile not found");
        }else if( !friend.isPresent()){
            throw new Exception("friend not found");
        }

        List<Profile> friends = profile.get().getFriends();

        boolean areAlreadyFriends = friends.stream().anyMatch( frie -> frie.getProfileId() == friendId );

        if(areAlreadyFriends){
            return profile.get();
        }

        profile.get().addFriend(friend.get());
        profileRepository.save(profile.get());
        return profile.get();
    }

}
