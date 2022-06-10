package com.bridgelabz.BookServices.Service;

import java.util.List;

import com.bridgelabz.BookServices.dto.BookDTO;
import com.bridgelabz.BookServices.model.Book;

public interface IBookService {

    Book insertBook(BookDTO dto);

    List<Book> getAllBooks();

    Book getbookByID(Integer BookId);

    List<Book> retrieveBooks();

    Book updateById(Integer BookId, BookDTO dto);

    Book deleteById(Integer BookId);

    Book getbookByBookName(String bookName);

    List<Book> sortBooksAsc();

    List<Book> sortBooksDesc();

    Book updateBookQuantity(int bookId, int bookQuantity);

    Book getbookByIdAPI(Integer bookId);

}