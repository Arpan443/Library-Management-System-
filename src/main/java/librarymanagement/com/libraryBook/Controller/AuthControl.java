package librarymanagement.com.libraryBook.Controller;

import jakarta.validation.Valid;
import librarymanagement.com.libraryBook.DTO.Request.LoginRequest;
import librarymanagement.com.libraryBook.DTO.Request.RegisterRequest;
import librarymanagement.com.libraryBook.DTO.Response.AuthResponse;
import librarymanagement.com.libraryBook.Service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthControl {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@Valid @RequestBody RegisterRequest request) {
        return ResponseEntity.ok(authService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@Valid @RequestBody LoginRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }
}