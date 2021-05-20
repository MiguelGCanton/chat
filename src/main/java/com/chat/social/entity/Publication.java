package com.chat.social.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

public class Publication {
    @Column
    @NotNull(message = "message should not be empty")
    private String message;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @NotNull(message = "profileId should not be empty")
    @Column
    private int publicationId;
    @Column
    @ManyToOne
    private Profile profile;

    public Publication(){

    } 

    public Publication( String message,int publicationId, Profile profile) {
        this.message = message;
        this.publicationId = publicationId;
        this.profile = profile;
    }

    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public int getPublicationId() {
        return publicationId;
    }
    public void setPublicationId(int publicationId) {
        this.publicationId = publicationId;
    }
    public Profile getProfile() {
        return profile;
    }


    




}
