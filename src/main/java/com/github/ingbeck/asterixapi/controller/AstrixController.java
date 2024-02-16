package com.github.ingbeck.asterixapi.controller;

import com.github.ingbeck.asterixapi.model.AsterixCharacter;
import com.github.ingbeck.asterixapi.repository.AsterixCharacterRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/asterix/characters")
@RequiredArgsConstructor
public class AstrixController {

    private final AsterixCharacterRepo asterixCharacterRepo;

    @GetMapping
    public  List<AsterixCharacter> getCharacters(){
        return asterixCharacterRepo.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AsterixCharacter saveNewAsterixCharacter(@RequestBody AsterixCharacter asterixCharacter){
        return asterixCharacterRepo.save(asterixCharacter);
    }

    @DeleteMapping("/{id}")
    public List<AsterixCharacter> deleteCharacterByID(@PathVariable String id){
        asterixCharacterRepo.delete(asterixCharacterRepo.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Element with Id: " + id + "not present")));
        return asterixCharacterRepo.findAll();
    }

    @PutMapping("/{id}")
    public AsterixCharacter updateCharacter(@PathVariable String id, @RequestBody AsterixCharacter asterixCharacter){
        AsterixCharacter existingCharacter = asterixCharacterRepo
                .findById(id)
                .orElseThrow(() -> new NoSuchElementException("Element with Id: " + id + "not present"));
        existingCharacter.setAge(asterixCharacter.getAge());
        existingCharacter.setName(asterixCharacter.getName());
        existingCharacter.setProfession(asterixCharacter.getProfession());
        return asterixCharacterRepo.save(existingCharacter);
    }

}
