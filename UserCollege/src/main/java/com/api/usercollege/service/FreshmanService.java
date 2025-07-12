package com.api.usercollege.service;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class FreshmanService {
    public String generateRandomChars(int length) {
        String allowedChars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ"; // Caratteri consentiti
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(allowedChars.length()); // Indice casuale
            sb.append(allowedChars.charAt(index)); // Aggiunge un carattere casuale
        }

        return sb.toString();
    }
    public String generateFreshmanCode( String prefix) {
        String randomChars = generateRandomChars(14);
        return prefix + randomChars;
    }
}
