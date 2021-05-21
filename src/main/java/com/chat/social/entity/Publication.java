package com.chat.social.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Table(name = "publications")
@Entity
public class Publication {
    @Column
    @NotNull(message = "message should not be empty")
    private String message;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @NotNull(message = "publicationId should not be empty")
    @Column
    private int publicationId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profileId")
    @JsonBackReference
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
    @JsonIgnoreProperties
    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    @Override
    public boolean equals(Object obj){
    if(this == obj)
            return true;
        if(obj == null || obj.getClass()!= this.getClass())
            return false;
        Publication publication = (Publication) obj;
        return (publication.publicationId == this.publicationId && publication.message == this.message);
    }
}
