
package com.chat.social.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Table(name = "profiles")
@Entity
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
    @OneToMany(mappedBy = "profile", cascade=CascadeType.ALL)
    private List<Publication> publications;

    public Profile(String name, int orderId, List<Publication> publications) {
        this.name = name;
        this.profileId = orderId;
        this.publications = publications;
    }

    public Profile(){

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

    



    
}
