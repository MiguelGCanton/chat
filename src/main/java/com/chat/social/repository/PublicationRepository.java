package com.chat.social.repository;

import java.util.List;

import com.chat.social.entity.Profile;
import com.chat.social.entity.Publication;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PublicationRepository extends JpaRepository<Publication, Integer> {
    
    @Query("SELECT p FROM Publication p WHERE p.profile = :Profile")
    public List<Publication> findPublicationsByProfileId(@Param("Profile") Profile profileId);
}