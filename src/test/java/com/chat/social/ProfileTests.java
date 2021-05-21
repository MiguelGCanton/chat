package com.chat.social;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.chat.social.entity.Profile;
import com.chat.social.entity.Publication;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest
public class ProfileTests {
    @Test
	void addPublicationCorrectly(){
		Profile jorge = new Profile ("jorgeDiaz");
		Publication pub = new Publication("hello, world2", 4, jorge);
		jorge.addPublication(pub);
		assertTrue(jorge.getPublications().size()== 1);
	}

	@Test
	void removePublicationCorrectly(){
		Profile jorge = new Profile ("jorgeDiaz");
		Publication pub = new Publication("hello, world2", 4, jorge);
        jorge.addPublication(pub);
        Publication pub1= new Publication("hello, world1", 1, jorge);
        jorge.addPublication(pub);
        Publication pub2 = new Publication("hello, world3", 5, jorge);
        jorge.addPublication(pub2);
        System.out.println(jorge.getPublications().size());
		jorge.removePublications(1);
		assertTrue(jorge.getPublications().size()== 2);
	}

    @Test
	void removePublicationThrowsException(){
		Profile jorge = new Profile ("jorgeDiaz");
        Exception exception = assertThrows(IndexOutOfBoundsException.class, () -> {
            jorge.removePublications(1);
        });
		assertTrue(exception instanceof  IndexOutOfBoundsException );
	}


}
