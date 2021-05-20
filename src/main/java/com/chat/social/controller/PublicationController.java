package com.chat.social.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.chat.social.entity.Profile;
import com.chat.social.entity.Publication;
import com.chat.social.service.ProfileService;
import com.chat.social.service.PublicationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController()
@RequestMapping("/profiles/{profileId}/publications")
public class PublicationController {
    @Autowired 
    PublicationService publicationService;
    @Autowired
    ProfileService profileService;

    @GetMapping
    public ResponseEntity<List<Publication>> listAllPublications(@PathVariable("profileId") int id) {
        Optional<Profile> profile = profileService.getProfileById(id);
        if(profile.isPresent()){
            List<Publication> publications = publicationService.getPublicationsByProfileId(profile.get());
            return  ResponseEntity.ok(publications);
        }else{
            return ResponseEntity.notFound().build();
        }

    }

    @PostMapping
    public ResponseEntity<Publication> createpublication(@PathVariable("profileId") int id, @Valid @RequestBody Publication publication) {
        
        Optional<Profile> profile = profileService.getProfileById(id);
        if(profile.isPresent()){
            publication.setProfile(profile.get());
        }else{
            return ResponseEntity.notFound().build();
        }
        Publication newPublication = publicationService.createPublication(publication);
        return  ResponseEntity.status( HttpStatus.CREATED).body(newPublication);
    }



}
