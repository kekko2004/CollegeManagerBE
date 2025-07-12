package com.api.appeal.service;

import com.api.appeal.entity.Appeal;
import com.api.appeal.repository.AppealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class AppealService {
    @Autowired
    private final AppealRepository appealRepository;

    public AppealService(AppealRepository appealRepository) {
        this.appealRepository = appealRepository;
    }

    public List<Appeal> getAll(){
        return appealRepository.findAll();
    }

    public Appeal getById(Long id){
        return appealRepository.findById(id).orElse(null);
    }

    public List<Appeal> getByCourse(Long id){
        return appealRepository.findByCourse(id);
    }

    public List<Appeal> getAppealAfter(Date date){
        return appealRepository.findByDateAfter(date);
    }

    public List<Appeal> getEndedAppeal(){
        return appealRepository.findByDateBefore(new Date());
    }

    public Appeal create(Appeal appeal){
        return appealRepository.save(appeal);
    }

    public Appeal update(Appeal appeal, Long id){
        if(id!=null){
            appeal.setId(id);
            return appealRepository.save(appeal);
        }
        return appealRepository.save(appeal);
    }
    public Date convertStringToDate(String dateString) {
        // Definisci il formato della tua stringa (modificalo secondo il tuo caso)
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

        try {
            return formatter.parse(dateString);
        } catch (ParseException e) {
            System.err.println("Formato data non valido: " + dateString);
            System.err.println("Il formato atteso è: " + formatter.toPattern());
            return null; // o lancia un'eccezione
        }
    }
    public void delete(Long id)
    {
        appealRepository.deleteById(id);
    }
}
