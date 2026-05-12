package librarymanagement.com.libraryBook.Controller;

import librarymanagement.com.libraryBook.DTO.Request.RegisterRequest;
import librarymanagement.com.libraryBook.DTO.Response.UserResponse;
import librarymanagement.com.libraryBook.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserControl {

    private final UserService userService;

    // Add user
    @PostMapping("/add")
    public ResponseEntity<UserResponse> addUser(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(userService.addUser(request));
    }

    // Get all users
    @GetMapping("/all")
    public ResponseEntity<List<UserResponse>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    // Get user by id
    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    // Update user
    @PutMapping("/update/{id}")
    public ResponseEntity<UserResponse> updateUser(@PathVariable Long id,
                                                   @RequestBody RegisterRequest request) {
        return ResponseEntity.ok(userService.updateUser(id, request));
    }

    // Delete user
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        return ResponseEntity.ok(userService.deleteUser(id));
    }
}