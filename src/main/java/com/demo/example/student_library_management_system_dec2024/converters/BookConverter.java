package com.demo.example.student_library_management_system_dec2024.converters;

import com.demo.example.student_library_management_system_dec2024.model.Author;
import com.demo.example.student_library_management_system_dec2024.model.Book;
import com.demo.example.student_library_management_system_dec2024.requestdto.AuthorRequestDto;
import com.demo.example.student_library_management_system_dec2024.requestdto.BookRequestDto;

public class BookConverter {

    public static Book convertBookRequestDtoToBook(BookRequestDto bookRequestDto) {
        Book  book = new Book();
        book.setTitle(bookRequestDto.getTitle());
        book.setPages(bookRequestDto.getPages());
        book.setPublisherName(bookRequestDto.getPublisherName());
        book.setGenre(bookRequestDto.getGenre());
        book.setAvailable(bookRequestDto.isAvailable());
        return book;
    }
}
