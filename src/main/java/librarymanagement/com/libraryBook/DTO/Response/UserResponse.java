package librarymanagement.com.libraryBook.DTO.Response;

import lombok.Data;

@Data
public class UserResponse {
    private long id;
    private String name;
    private String password;
    private String email;
}
