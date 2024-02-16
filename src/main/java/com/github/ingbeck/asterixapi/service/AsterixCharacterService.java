package com.github.ingbeck.asterixapi.service;

import com.github.ingbeck.asterixapi.model.AsterixCharacter;
import com.github.ingbeck.asterixapi.repository.AsterixCharacterRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class AsterixCharacterService {

    private final AsterixCharacterRepo repo;

    public List<AsterixCharacter> getCharacters(){
        return repo.findAll();
    }

    public AsterixCharacter saveNewAsterixCharacter(AsterixCharacter asterixCharacter){
        return repo.save(asterixCharacter);
    }

    public List<AsterixCharacter> deleteCharacterByID(String id){
        repo.delete(repo.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Element with Id: " + id + "not present")));
        return repo.findAll();
    }

    public AsterixCharacter updateCharacter(String id, AsterixCharacter asterixCharacter){
        AsterixCharacter existingCharacter = repo
                .findById(id)
                .orElseThrow(() -> new NoSuchElementException("Element with Id: " + id + "not present"));
        existingCharacter.setAge(asterixCharacter.getAge());
        existingCharacter.setName(asterixCharacter.getName());
        existingCharacter.setProfession(asterixCharacter.getProfession());
        return repo.save(existingCharacter);
    }
}
