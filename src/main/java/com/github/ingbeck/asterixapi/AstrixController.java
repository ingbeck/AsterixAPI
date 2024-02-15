package com.github.ingbeck.asterixapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.chrono.ChronoLocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/asterix/characters")
public class AstrixController {

    List<AsterixCharacter> characters = new ArrayList<>();

    @GetMapping
    public  List<AsterixCharacter> getCharacters(){
        return List.of(
                new AsterixCharacter("1", "Asterix", 35, "Krieger"),
                new AsterixCharacter("2", "Obelix", 35, "Lieferant"),
                new AsterixCharacter("3", "Miraculix", 60, "Druide"),
                new AsterixCharacter("4", "Majestix", 60, "Häuptling"),
                new AsterixCharacter("5", "Troubadix", 25, "Barde"),
                new AsterixCharacter("6", "Gutemine", 35, "Häuptlingsfrau"),
                new AsterixCharacter("7", "Idefix", 5, "Hund"),
                new AsterixCharacter("8", "Geriatrix", 70, "Rentner"),
                new AsterixCharacter("9", "Automatix", 35, "Schmied"),
                new AsterixCharacter("10", "Grockelix", 35, "Fischer")
        );
    }
}
