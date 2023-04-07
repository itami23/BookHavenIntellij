package com.emsi.bookhaven.DAO;

import com.emsi.bookhaven.Models.Book;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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
}
