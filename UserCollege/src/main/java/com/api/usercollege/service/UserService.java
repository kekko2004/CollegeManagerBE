package com.api.usercollege.service;

import com.api.usercollege.model.Professor;
import com.api.usercollege.model.Student;
import com.api.usercollege.model.User;
import com.api.usercollege.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;
@Service
public abstract class UserService <T extends User>{
    protected final UserRepository<T> userRepository;  // Usa l'interfaccia custom

    protected UserService(UserRepository<T> userRepository) {
        this.userRepository = userRepository;
    }

    //Metodo per trovare tutti gli student o professor o meglio ancora proprio tutti
    //n.b. implementare a finche possa essere utilizzata per ritornare tutti gli user
    public List<T> findAll(){
        return userRepository.findAll();
    }
    // Metodo per trovare un utente per email
    public Optional<T> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    // Metodo per trovare uno studente per freshman
    public Optional<T> findByFreshman(String freshman) {
        return userRepository.findByFreshman(freshman);
    }
    //t stand for t, if you don't know, you do know bow wow
    //T => student : professor
    //modificato t in user


   public T updateUser(String id,T user ){
        if(user == null){
            throw new IllegalArgumentException("user non valido.");
        }
        if(id == null){
            throw new IllegalArgumentException("id non valido.");
        }
        user.setFreshman(id);
        return userRepository.save(user);

   }

    public void deleteUser(String id) { // modifica effettuato dopo il cambio di PK in User
        if (id == null) {
            throw new IllegalArgumentException("L'ID non può essere nullo.");
        }
        userRepository.deleteById(id);
    }




}
