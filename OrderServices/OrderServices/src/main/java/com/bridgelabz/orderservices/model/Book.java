package com.bridgelabz.orderservices.model;

import com.bridgelabz.orderservices.dto.BookDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Book {

    @Id
    @GeneratedValue
    private Integer bookId;
    private String authoreName;
    private String  bookName;
    private String bookImg;
    private Integer price;
    private Integer quantity;

    public Book(Book book) {
        super();
        this.bookId = book.getBookId();
        this.authoreName = book.getAuthoreName();
        this.bookName = book.getBookName();
        this.bookImg = book.getBookImg();
        this.price = book.getPrice();
        this.quantity = book.getQuantity();
    }

    public Book() {
        super();
    }

}
