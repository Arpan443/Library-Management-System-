package librarymanagement.com.libraryBook.DTO.Response;

import lombok.Data;

@Data
public class BookResponse {
    private String id;
    private String genre ;
    private String name;
    private  int total_copies;
    private int available_copies;

}
