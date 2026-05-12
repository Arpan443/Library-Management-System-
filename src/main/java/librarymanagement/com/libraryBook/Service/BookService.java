package librarymanagement.com.libraryBook.Service;

import librarymanagement.com.libraryBook.DTO.Request.BookRequest;
import librarymanagement.com.libraryBook.DTO.Response.BookResponse;
import librarymanagement.com.libraryBook.Enitity.Book;
import librarymanagement.com.libraryBook.Exception.ResourceNotFoundException;
import librarymanagement.com.libraryBook.Repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    // Add book
    public BookResponse addBook(BookRequest request) {
        Book book = new Book();
        book.setName(request.getName());
        book.setGenre(request.getGenre());
        book.setTotal_copies(request.getTotal_copies());
        book.setAvailable_copies(request.getAvailable_copies());
        Book saved = bookRepository.save(book);
        return mapToResponse(saved);
    }

    // Get all books
    public List<BookResponse> getAllBooks() {
        return bookRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    // Get book by id
    public BookResponse getBookById(String id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found"));
        return mapToResponse(book);
    }

    // Update book
    public BookResponse updateBook(String id, BookRequest request) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));
        book.setName(request.getName());
        book.setGenre(request.getGenre());
        book.setTotal_copies(request.getTotal_copies());
        book.setAvailable_copies(request.getAvailable_copies());
        Book updated = bookRepository.save(book);
        return mapToResponse(updated);
    }

    // Delete book
    public String deleteBook(String id) {
        bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found"));
        bookRepository.deleteById(id);
        return "Book deleted successfully";
    }

    // Helper method
    private BookResponse mapToResponse(Book book) {
        BookResponse response = new BookResponse();
        response.setId(book.getId());
        response.setName(book.getName());
        response.setGenre(book.getGenre());
        response.setTotal_copies(book.getTotal_copies());
        response.setAvailable_copies(book.getAvailable_copies());
        return response;
    }
}