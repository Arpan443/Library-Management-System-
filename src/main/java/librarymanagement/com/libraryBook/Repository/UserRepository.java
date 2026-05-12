package librarymanagement.com.libraryBook.Repository;

import librarymanagement.com.libraryBook.Enitity.users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<users, Long> {
    Optional<users> findByEmail(String email);
}