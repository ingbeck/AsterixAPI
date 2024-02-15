package com.github.ingbeck.asterixapi;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface AsterixCharacterRepo extends MongoRepository<AsterixCharacter, String> {
}
