package com.example.libraryapi.service;

import com.example.libraryapi.dto.BookDto;
import com.example.libraryapi.exception.NoCopiesAvailableException;
import com.example.libraryapi.exception.ResourceNotFoundException;
import com.example.libraryapi.model.Author;
import com.example.libraryapi.model.Book;
import com.example.libraryapi.repository.AuthorRepository;
import com.example.libraryapi.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookService(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    // Get all books
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    // Get one book by id
    public Book getBookById(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found with id: " + id));
    }

    // Add a new book
    public Book addBook(BookDto dto) {
        Author author = authorRepository.findById(dto.getAuthorId())
                .orElseThrow(() -> new ResourceNotFoundException("Author not found with id: " + dto.getAuthorId()));

        Book book = new Book();
        book.setName(dto.getName());
        book.setCategory(dto.getCategory());
        book.setAuthor(author);
        book.setState(dto.getState());
        book.setAvailableCopies(dto.getAvailableCopies());
        return bookRepository.save(book);
    }

    // Update an existing book
    public Book updateBook(Long id, BookDto dto) {
        Book book = getBookById(id);

        Author author = authorRepository.findById(dto.getAuthorId())
                .orElseThrow(() -> new ResourceNotFoundException("Author not found with id: " + dto.getAuthorId()));

        book.setName(dto.getName());
        book.setCategory(dto.getCategory());
        book.setAuthor(author);
        book.setState(dto.getState());
        book.setAvailableCopies(dto.getAvailableCopies());
        return bookRepository.save(book);
    }

    // Delete a book
    public void deleteBook(Long id) {
        Book book = getBookById(id);
        bookRepository.delete(book);
    }

    // Mark a book as rented (decrease available copies by 1)
    public Book rentBook(Long id) {
        Book book = getBookById(id);

        if (book.getAvailableCopies() <= 0) {
            throw new NoCopiesAvailableException("No available copies for book: " + book.getName());
        }

        book.setAvailableCopies(book.getAvailableCopies() - 1);
        return bookRepository.save(book);
    }
}
