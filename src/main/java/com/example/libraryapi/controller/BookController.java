package com.example.libraryapi.controller;

import com.example.libraryapi.dto.BookDto;
import com.example.libraryapi.model.Book;
import com.example.libraryapi.service.BookService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    // GET all books
    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    // GET one book by id
    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id) {
        return bookService.getBookById(id);
    }

    // POST add a new book
    @PostMapping
    public ResponseEntity<Book> addBook(@Valid @RequestBody BookDto dto) {
        Book book = bookService.addBook(dto);
        return ResponseEntity.ok(book);
    }

    // PUT update an existing book
    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @Valid @RequestBody BookDto dto) {
        Book book = bookService.updateBook(id, dto);
        return ResponseEntity.ok(book);
    }

    // DELETE a book
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return ResponseEntity.noContent().build();
    }

    // PATCH mark a book as rented (decreases available copies by 1)
    @PatchMapping("/{id}/rent")
    public ResponseEntity<Book> rentBook(@PathVariable Long id) {
        Book book = bookService.rentBook(id);
        return ResponseEntity.ok(book);
    }
}
