package com.api.booklet.service;

import com.api.booklet.entity.Booklet;
import com.api.booklet.repository.BookletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BookletService {
    @Autowired
    private final BookletRepository bookletRepository;


    public BookletService(BookletRepository bookletRepository) {
        this.bookletRepository = bookletRepository;
    }

    public List<Booklet> getBookletByStudent(String freshman){
        return bookletRepository.findByFreshman(freshman);
    }

    public List<Booklet> getByAppeal(Long appeal_id){
        return bookletRepository.findByAppeal(appeal_id);
    }

    public Booklet createBooklet(Booklet booklet){
        return bookletRepository.save(booklet);
    }

    public Booklet updateBooklet(Booklet booklet, Long id){
        if(id!=null){
            booklet.setId(id);
            return bookletRepository.save(booklet);
        }
        return bookletRepository.save(booklet);
    }

    public void deleteBooklet(Long id){
        bookletRepository.deleteById(id);
    }
}
