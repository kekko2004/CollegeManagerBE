package com.api.middlecollegemanager.service;

import com.api.middlecollegemanager.model.advanced.Booklet;
import com.api.middlecollegemanager.model.base.school.Appeal;
import com.api.middlecollegemanager.service.func.BookletFunction;
import com.api.middlecollegemanager.service.path.Path;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class BookletService extends Path {
    private final BookletFunction bookletFunction;
    private final CourseService courseService;
    private final AppealService appealService;
    public BookletService(BookletFunction bookletFunction, CourseService courseService, AppealService appealService) {
        this.bookletFunction = bookletFunction;
        this.courseService = courseService;
        this.appealService = appealService;
    }
    @SuppressWarnings("unchecked")
    public List<Booklet> StudentBooklet(String freshman){
        Booklet[] studentBooklet = restTemplate.getForObject(
                getBooklet() + "/student/" + freshman,
                Booklet[].class);
        if(studentBooklet ==null){
            return Collections.emptyList();
        }
        return bookletFunction.BindingBooklet(Arrays.asList(studentBooklet));
    }


    public List<Booklet> register(Long course) {
        // 1. Configurazione di base

        List<Booklet> result = new ArrayList<>();
        // 2. Recupero tutti gli appelli del corso
        Appeal[] appeals = restTemplate.getForObject(
                getAppeal() + "/course/" + course,
                Appeal[].class
        );


        if(appeals == null || appeals.length == 0) {
            return result;
        }

        // 3. Per ogni appello, recupero i booklet
        for(Appeal appeal : appeals) {
            if (appeal != null && appeal.getId() != null) {
                Booklet[] booklets = restTemplate.getForObject(
                        getBooklet() + "/appeal/" + appeal.getId(),
                        Booklet[].class
                );
                if(booklets != null && booklets.length > 0) {

                    result.addAll(Arrays.asList(booklets));
                }
            }
        }
        return result;

    }

}
