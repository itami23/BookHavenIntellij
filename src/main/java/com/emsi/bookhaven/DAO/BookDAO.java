package com.emsi.bookhaven.DAO;

import com.emsi.bookhaven.Models.Book;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class BookDAO {
    private EntityManager entityManager;
    private EntityManagerFactory entityManagerFactory;

    public BookDAO(EntityManager entityManager, EntityManagerFactory entityManagerFactory) {
        this.entityManager = entityManager;
        this.entityManagerFactory = entityManagerFactory;
    }

    public void createBook(Book book) {
        entityManager.getTransaction().begin();
        entityManager.persist(book);
        entityManager.getTransaction().commit();
    }

    public List<Book> getAllBooks() {
        TypedQuery<Book> query = entityManager.createQuery("SELECT b FROM Book b", Book.class);
        return query.getResultList();
    }

    public Book findBook(Long book_id)
    {
        Book book = entityManager.find(Book.class,book_id);
        return book;
    }

    public void updateBook(Book book)
    {
        entityManager.getTransaction().begin();
        entityManager.merge(book);
        entityManager.getTransaction().commit();
    }
}
