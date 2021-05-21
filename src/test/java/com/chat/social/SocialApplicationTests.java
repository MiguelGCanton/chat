package com.chat.social;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.chat.social.entity.Profile;
import com.chat.social.entity.Publication;
import com.chat.social.repository.PublicationRepository;
import com.chat.social.service.ProfileService;
import com.chat.social.service.PublicationService;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.event.annotation.BeforeTestClass;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class SocialApplicationTests {

    @Mock
    private PublicationService publicationService;

	@Mock
	private ProfileService profileService;

    @BeforeEach
    public void setup(){
        
		Profile juan = new Profile ("juanPerez");
		Profile jorge = new Profile ("jorgeDiaz");
		Profile luis = new Profile ("luisChan");

		Publication pub1 = new Publication("hello, world", 1, juan );
		Publication pub2 = new Publication("hello, world", 2, juan );
		Publication pub3 = new Publication("hello, world", 3, juan );
		Publication pub4 = new Publication("hello, world", 4, jorge );

		juan.addPublication(pub1);
		juan.addPublication(pub2);
		juan.addPublication(pub3);

		jorge.addPublication(pub4);
		

		List<Publication> juansPublications = new ArrayList();
		juansPublications.add(pub1); 
		juansPublications.add(pub2);
		juansPublications.add(pub3);  


		List<Publication> jorgesPublications = new ArrayList();
		jorgesPublications.add(pub4); 

	//	List<Publication> luisPublications = new ArrayList();

		//Mockito.when(publicationService.getPublicationsByProfileId(juan)).thenReturn(juansPublications);
		Mockito.when(profileService.getProfileById(1)).thenReturn(Optional.of(juan) );


    }

	@Test
	void basicTest(){
		Profile juan =profileService.getProfileById(1).get();
		
		Publication pub = new Publication("hello, world", 5, juan );
		juan.addPublication(pub);
		List<Publication> list = juan.getPublications();
		assertTrue(list.size()== 4);
	}


	@Test
	void removePublication(){
		Profile juan =profileService.getProfileById(1).get();

		juan.removePublications(1);
		List<Publication> list = juan.getPublications();
		assertTrue(list.size()== 2);
	}

	
}
