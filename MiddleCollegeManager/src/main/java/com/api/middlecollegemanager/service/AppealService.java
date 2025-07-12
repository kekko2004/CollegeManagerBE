package com.api.middlecollegemanager.service;

import com.api.middlecollegemanager.model.base.school.Appeal;
import com.api.middlecollegemanager.service.func.AppealFunction;
import com.api.middlecollegemanager.service.path.Path;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static com.fasterxml.jackson.databind.cfg.CoercionInputShape.Array;

@Service
public class AppealService extends Path {
    private final AppealFunction appealFunction;
    public AppealService(AppealFunction appealFunction) {
        this.appealFunction = appealFunction;
    }

    public Appeal getById(Long id){
        Appeal appeal =  restTemplate.getForObject(getAppeal() +"/" + id, Appeal.class);
        return appealFunction.fillAppeal(appeal);
    }
    @SuppressWarnings("unchecked")
    public List<Appeal> getAll(){
        return appealFunction.BindingList(restTemplate.getForObject(getAppeal(), List.class));
    }
    @SuppressWarnings("unchecked")
    public List<Appeal> getAppealByCourse(Long course){
        Appeal[] appeals = restTemplate.getForObject(
                getAppeal()+"/course/" + course
                , Appeal[].class);

        if(appeals.length == 0){
            return Collections.emptyList();
        }
        return new ArrayList<>(appealFunction.BindingList(Arrays.asList(appeals)));
    }
    @SuppressWarnings("unchecked")
    public List<Appeal> getEndedAppeals(){
        Appeal[] appeals = restTemplate.getForObject(
                getAppeal()+"/ended"
                , Appeal[].class);

        if(appeals.length == 0){
            return Collections.emptyList();
        }
        return new ArrayList<>(appealFunction.BindingList(Arrays.asList(appeals)));

    }
    public List<Appeal> getAppealsAfter(String date){
         Appeal[] appeals = restTemplate.getForObject(
                getAppeal()+"/after/" + date
                , Appeal[].class);

         if(appeals.length == 0){
             return Collections.emptyList();
         }
        return new ArrayList<>(appealFunction.BindingList(Arrays.asList(appeals)));
    }
    private Date convertStringToDate(String dateString) {
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

}
