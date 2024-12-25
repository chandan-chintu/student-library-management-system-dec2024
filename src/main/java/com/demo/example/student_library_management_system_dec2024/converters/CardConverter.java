package com.demo.example.student_library_management_system_dec2024.converters;

import com.demo.example.student_library_management_system_dec2024.model.Card;
import com.demo.example.student_library_management_system_dec2024.requestdto.CardRequestDto;

public class CardConverter {

    public static Card convertCardRequestDtoToCard(CardRequestDto cardRequestDto) {
        Card card  = new Card();
        card.setCardStatus(cardRequestDto.getCardStatus());
        return card;
    }
}
