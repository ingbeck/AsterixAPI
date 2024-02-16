package com.github.ingbeck.asterixapi.repository;

import com.github.ingbeck.asterixapi.model.AsterixCharacter;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AsterixCharacterRepo extends MongoRepository<AsterixCharacter, String> {
}
