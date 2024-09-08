package com.javaee6.webmvc.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.javaee6.webmvc.demo.model.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Long>  {

}
