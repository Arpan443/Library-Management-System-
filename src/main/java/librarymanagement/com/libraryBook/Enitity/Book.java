package librarymanagement.com.libraryBook.Enitity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@Table(name="Books")
@NoArgsConstructor
@AllArgsConstructor

public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private  String id;

    private String genre ;
    private String name;
    private  int total_copies;
    private int available_copies;


}
