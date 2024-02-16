package com.github.ingbeck.asterixapi.service;

import com.github.ingbeck.asterixapi.model.AsterixCharacter;
import com.github.ingbeck.asterixapi.model.AsterixCharacterDto;
import com.github.ingbeck.asterixapi.repository.AsterixCharacterRepo;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
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

    public AsterixCharacterDto saveNewAsterixCharacterWithoutId(AsterixCharacter asterixCharacter){
        AsterixCharacterDto dto = new AsterixCharacterDto(asterixCharacter.getName(), asterixCharacter.getAge(), asterixCharacter.getProfession());
        repo.save(new AsterixCharacter(nextId(), dto.getName(), dto.getAge(), dto.getProfession()));
        return dto;
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

    public String nextId(){
        int[] allIds = new int[repo.findAll().size()];
        int lastId = 0;
        int count = 0;

        for(AsterixCharacter character : repo.findAll()){
            allIds[count] = Integer.parseInt(character.getId());
            count ++;
        }

        for(int i = 1; i<allIds.length; i++){
            if (allIds[i] > allIds[i-1]){
                lastId = allIds[i];
            }
        }

        return "" + (lastId + 1);
    }
}
