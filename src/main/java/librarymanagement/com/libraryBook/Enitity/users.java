package librarymanagement.com.libraryBook.Enitity;

import jakarta.persistence.*;
import librarymanagement.com.libraryBook.Enitity.Enum.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor

public class users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String password;
    @Column(unique = true)
    private String email;

    @Enumerated(EnumType.STRING)
    private Role role;
}
