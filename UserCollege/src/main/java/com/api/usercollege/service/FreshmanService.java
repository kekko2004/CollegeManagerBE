package com.api.usercollege.service;

import com.api.usercollege.model.User;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class FreshmanService extends UserService {

    //per quanto riguarda l'update abbiamo bisogno di una funzione che ci ricosca la matricola
    public Boolean freshmanPrefixResolver(User user){
        String code = user.getFreshman();
        if(code.equalsIgnoreCase("st")){
            return true;
        }else if(code.equalsIgnoreCase("pr")){
            return false;
        }
        return null;
    }

    public String generateFreshmanCode( String prefix) {
        String randomChars = generateRandomChars(14); // Genera 14 caratteri casuali (numeri e lettere)
        return prefix + randomChars;
    }

    // Metodo per generare una stringa di caratteri casuali (numeri e lettere maiuscole)
    public String generateRandomChars(int length) {
        String allowedChars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ"; // Caratteri consentiti
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(allowedChars.length()); // Indice casuale
            sb.append(allowedChars.charAt(index)); // Aggiunge un carattere casuale
        }
        //matching della matricola, nel caso in cui il random dia un output gia esistente
        if(this.findByFreshman(sb.toString()).isPresent()){
            return generateRandomChars(length);
        }
        return sb.toString();
    }
}
