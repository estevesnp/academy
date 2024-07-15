package com.ctw.workstation.booking.entity;

public class BookingMapper {
    public static Booking dtoToDomain(BookingDTO dto) {
        Booking book = new Booking();

        book.setId(dto.getId());
        book.setCreatedAt(dto.getCreatedAt());
        book.setModifiedAt(dto.getModifiedAt());
        book.setBookFrom(dto.getBookFrom());
        book.setBookTo(dto.getBookTo());
        book.setRackId(dto.getRackId());
        book.setRequesterId(dto.getRequesterId());

        return book;
    }

    public static BookingDTO domainToDTO(Booking book) {
        return new BookingDTO(book.getId(), book.getCreatedAt(),
                book.getModifiedAt(), book.getBookFrom(),
                book.getBookTo(), book.getRackId(), book.getRequesterId());
    }
}
