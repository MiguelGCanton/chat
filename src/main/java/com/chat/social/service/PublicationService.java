package com.chat.social.service;

import java.util.List;

import com.chat.social.entity.Profile;
import com.chat.social.entity.Publication;
import com.chat.social.repository.PublicationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PublicationService {
    
    @Autowired 
    PublicationRepository publicationRepository;

    public List<Publication> getPublicationsByProfileId(Profile profile){
        return publicationRepository.findPublicationsByProfileId(profile);
    }

    public Publication createPublication(Publication publication){
        publicationRepository.save(publication);
        return publication;
    }

}
