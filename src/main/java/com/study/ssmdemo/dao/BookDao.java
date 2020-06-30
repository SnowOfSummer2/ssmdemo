package com.study.ssmdemo.dao;

import com.study.ssmdemo.domain.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookDao extends CrudRepository<Book, Integer> {
    List<Book> findByAuthor(String author);
}
