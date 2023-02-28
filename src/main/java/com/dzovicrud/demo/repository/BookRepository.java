package com.dzovicrud.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.dzovicrud.demo.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}
