package com.github.ingbeck.asterixapi.service;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.github.ingbeck.asterixapi.model.AsterixCharacter;
import com.github.ingbeck.asterixapi.repository.AsterixCharacterRepo;
import org.junit.jupiter.api.Test;
import org.mockito.stubbing.Stubber;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AsterixCharacterServiceTest {

    private final AsterixCharacterRepo repo = mock(AsterixCharacterRepo.class);
    AsterixCharacterService service = new AsterixCharacterService(repo);
    @Test
    void getCharacters() {
        //GIVEN
        List<AsterixCharacter> expected = List.of(new AsterixCharacter("1", "Asterix", 35, "Krieger"),
                new AsterixCharacter("2", "Obelix", 35, "Lieferant"));
        when(repo.findAll()).thenReturn(expected);
        //WHEN
        List<AsterixCharacter> actual = service.getCharacters();
        //THEN
        assertEquals(expected, actual);
        verify(repo).findAll();
    }

    @Test
    void saveNewAsterixCharacter() {
        //GIVEN
        //WHEN
        //THEN
    }

    @Test
    void saveNewAsterixCharacterWithoutId() {
        //GIVEN
        //WHEN
        //THEN
    }

    @Test
    void deleteCharacterByID() {
        //GIVEN
        //WHEN
        //THEN
    }

    @Test
    void updateCharacter() {
        //GIVEN
        //WHEN
        //THEN
    }
}