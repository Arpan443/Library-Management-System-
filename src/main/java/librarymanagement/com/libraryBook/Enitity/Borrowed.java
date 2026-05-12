package librarymanagement.com.libraryBook.Enitity;




import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import librarymanagement.com.libraryBook.Enitity.Enum.BorrowRecord;

@Entity
@Data
@Table(name = "borrowed")
public class Borrowed {

    @Id

    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private users user;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    private LocalDate borrowDate;

    private LocalDate returnDate;

    @Enumerated(EnumType.STRING)
    private BorrowRecord status;
}