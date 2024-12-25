package com.demo.example.student_library_management_system_dec2024.converters;

import com.demo.example.student_library_management_system_dec2024.model.Author;
import com.demo.example.student_library_management_system_dec2024.requestdto.AuthorRequestDto;

public class AuthorConverter {

    public static Author convertAuthorRequestDtoToAuthor(AuthorRequestDto authorRequestDto) {
        Author  author = new Author();
        author.setName(authorRequestDto.getName());
        author.setCountry(authorRequestDto.getCountry());
        author.setEmail(authorRequestDto.getEmail());
        author.setRating(authorRequestDto.getRating());
        return author;

    }
}
