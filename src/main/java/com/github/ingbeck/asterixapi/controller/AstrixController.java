package com.github.ingbeck.asterixapi.controller;

import com.github.ingbeck.asterixapi.model.AsterixCharacter;
import com.github.ingbeck.asterixapi.model.AsterixCharacterDto;
import com.github.ingbeck.asterixapi.repository.AsterixCharacterRepo;
import com.github.ingbeck.asterixapi.service.AsterixCharacterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/asterix/characters")
@RequiredArgsConstructor
public class AstrixController {

    private final AsterixCharacterService service;

    @GetMapping
    public  List<AsterixCharacter> getCharacters(){
        return service.getCharacters();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AsterixCharacter saveNewAsterixCharacter(@RequestBody AsterixCharacter asterixCharacter){
        return service.saveNewAsterixCharacter(asterixCharacter);
    }

    @PostMapping("/new_character")
    @ResponseStatus(HttpStatus.CREATED)
    public AsterixCharacterDto aveNewAsterixCharacterWithoutId(@RequestBody AsterixCharacter asterixCharacter){
        return service.saveNewAsterixCharacterWithoutId(asterixCharacter);
    }

    @DeleteMapping("/{id}")
    public List<AsterixCharacter> deleteCharacterByID(@PathVariable String id){
        return service.deleteCharacterByID(id);
    }

    @PutMapping("/{id}")
    public AsterixCharacter updateCharacter(@PathVariable String id, @RequestBody AsterixCharacter asterixCharacter){
        return service.updateCharacter(id, asterixCharacter);
    }

}
