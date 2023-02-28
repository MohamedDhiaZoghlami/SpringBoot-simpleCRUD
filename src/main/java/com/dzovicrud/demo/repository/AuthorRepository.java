package com.dzovicrud.demo.repository;

import com.dzovicrud.demo.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {

}
