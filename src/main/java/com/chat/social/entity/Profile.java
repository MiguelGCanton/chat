
package com.chat.social.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Table(name = "profiles")
@Entity
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "profileId")
public class Profile {

    @Column
    @NotNull(message = "Profile Name should not be empty")
    private String name;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @NotNull(message = "profileId should not be empty")
    @Column
    private int profileId;
    @Column
    @OneToMany(mappedBy = "profile", cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Publication> publications;

    @Column
    @JoinColumn(name = "profile_profile_id")
    @ManyToMany(fetch = FetchType.LAZY)
  //  @JsonBackReference
    @JsonIgnoreProperties({"friends"})

    private List<Profile> friends;

    public Profile(String name, int orderId, List<Publication> publications) {
        this.name = name;
        this.profileId = orderId;
        this.publications = publications;
    }


    public Profile(String name, int orderId, List<Publication> publications, List<Profile> friends) {
        this.name = name;
        this.profileId = orderId;
        this.publications = publications;
        this.friends = friends;
    }

    public Profile(){
        this.publications = new ArrayList<Publication>();
        this.friends = new ArrayList<Profile>();
    }

    public Profile(String name){
        this.name = name;
        this.publications = new ArrayList<Publication>();
        this.friends = new ArrayList<Profile>();
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getProfileId() {
        return profileId;
    }

    public void setProfileId(int profileId) {
        this.profileId = profileId;
    }
    
    public List<Publication> getPublications() {

        if(this.publications==null){
            return new ArrayList<Publication>();
        }
        List<Publication> list = new ArrayList<>(this.publications.size());
        list.addAll(this.publications);
        return list;
    }

    public void addPublication(Publication publication){
        this.publications.add(publication);
    }

    // public void setPublications(List<Publication> publications) {
    //     this.publications = publications;
    // }

    public Publication removePublications(int index){
        if(index < publications.size() && index > 0){
            Publication publicationToDelete = publications.get(index);
            publications.remove(index);
            return publicationToDelete;
        }else {
            throw new IndexOutOfBoundsException();
        }
    }

    public void addFriend(Profile friend){
        this.friends.add(friend);
    }

    public Publication removeFriend(int index){
        if(index < publications.size() && index > 0){
            Publication publicationToDelete = publications.get(index);
            publications.remove(index);
            return publicationToDelete;
        }else {
            throw new IndexOutOfBoundsException();
        }
    }

    public List<Profile> getFriends() {

        if(this.friends==null){
            return new ArrayList<Profile>();
        }
        List<Profile> list = new ArrayList<>(this.friends.size());
        list.addAll(this.friends);
        return list;
    }

    @Override
    public boolean equals(Object obj){
    if(this == obj)
            return true;
        if(obj == null || obj.getClass()!= this.getClass())
            return false;
        Profile profile = (Profile) obj;
        return (profile.profileId == this.profileId && profile.name == this.name);
    }
    
}
