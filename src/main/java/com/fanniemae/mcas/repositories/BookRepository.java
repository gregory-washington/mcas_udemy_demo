package com.fanniemae.mcas.repositories;

import com.fanniemae.mcas.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
