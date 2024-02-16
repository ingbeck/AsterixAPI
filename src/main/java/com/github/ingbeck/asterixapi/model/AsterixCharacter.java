package com.github.ingbeck.asterixapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AsterixCharacter{
    private String id;
    private String name;
    private int age;
    private String profession;
}
