package com.fanniemae.mcas.bootstrap;

import com.fanniemae.mcas.model.Author;
import com.fanniemae.mcas.model.Book;
import com.fanniemae.mcas.model.Publisher;
import com.fanniemae.mcas.repositories.AuthorRepository;
import com.fanniemae.mcas.repositories.BookRepository;
import com.fanniemae.mcas.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {
        //Eric
        Publisher publisher = new Publisher();
        publisher.setName("Harper Collins");
        publisher.setAddress("2120 Jack Street");
        publisherRepository.save(publisher);
        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "1234", publisher);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        //Rod
        Publisher publisher1 = new Publisher();
        publisher1.setName("Worx");
        publisher1.setAddress("1918 N. Belt Rd");
        publisherRepository.save(publisher1);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "23444", publisher1);
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);
        authorRepository.save(rod);
        bookRepository.save(noEJB);

    }
}
