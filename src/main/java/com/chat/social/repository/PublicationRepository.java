package com.chat.social.repository;

import com.chat.social.entity.Publication;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublicationRepository extends JpaRepository<Publication, Integer> {
    
    
}