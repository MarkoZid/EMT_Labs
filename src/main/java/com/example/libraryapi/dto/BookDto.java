package com.example.libraryapi.dto;

import com.example.libraryapi.model.BookState;
import com.example.libraryapi.model.Category;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookDto {

    @NotBlank(message = "Book name is required")
    private String name;

    @NotNull(message = "Category is required")
    private Category category;

    @NotNull(message = "Author ID is required")
    private Long authorId;

    @NotNull(message = "State is required")
    private BookState state;

    @NotNull(message = "Available copies is required")
    @Min(value = 0, message = "Available copies cannot be negative")
    private Integer availableCopies;
}
