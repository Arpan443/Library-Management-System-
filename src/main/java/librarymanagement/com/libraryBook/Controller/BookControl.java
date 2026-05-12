package librarymanagement.com.libraryBook.Controller;

import jakarta.validation.Valid;
import librarymanagement.com.libraryBook.DTO.Request.BookRequest;
import librarymanagement.com.libraryBook.DTO.Response.BookResponse;
import librarymanagement.com.libraryBook.Service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookControl {

    private final BookService bookService;

    @PostMapping("/add")
    public ResponseEntity<BookResponse> addBook(@Valid @RequestBody BookRequest request) {
        return ResponseEntity.ok(bookService.addBook(request));
    }

    @GetMapping("/all")
    public ResponseEntity<List<BookResponse>> getAllBooks() {
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookResponse> getBookById(@PathVariable String id) {
        return ResponseEntity.ok(bookService.getBookById(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<BookResponse> updateBook(@PathVariable String id,
                                                   @Valid @RequestBody BookRequest request) {
        return ResponseEntity.ok(bookService.updateBook(id, request));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable String id) {
        return ResponseEntity.ok(bookService.deleteBook(id));
    }
}