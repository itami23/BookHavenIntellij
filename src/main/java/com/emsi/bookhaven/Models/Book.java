package com.emsi.bookhaven.Models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String author;
    private int length;
    private String genre;

    @Column(columnDefinition = "TEXT")
    private String summary;

    private int price;
    private int quantity;

    public Book(String title, String author, int length, String genre, String summary, int price, int quantity) {
        this.title = title;
        this.author = author;
        this.length = length;
        this.genre = genre;
        this.summary = summary;
        this.price = price;
        this.quantity = quantity;
    }
}
