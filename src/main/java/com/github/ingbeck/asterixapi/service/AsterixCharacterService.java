package com.github.ingbeck.asterixapi.service;

import com.github.ingbeck.asterixapi.repository.AsterixCharacterRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AsterixCharacterService {

    private final AsterixCharacterRepo repo;

}
