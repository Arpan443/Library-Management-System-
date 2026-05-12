package librarymanagement.com.libraryBook.Service;

import librarymanagement.com.libraryBook.DTO.Request.LoginRequest;
import librarymanagement.com.libraryBook.DTO.Request.RegisterRequest;
import librarymanagement.com.libraryBook.DTO.Response.AuthResponse;
import librarymanagement.com.libraryBook.Enitity.Enum.Role;
import librarymanagement.com.libraryBook.Enitity.users;
import librarymanagement.com.libraryBook.Repository.UserRepository;
import librarymanagement.com.libraryBook.Security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;

    // Register
    public AuthResponse register(RegisterRequest request) {
        users user = new users();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(Role.USER);
        userRepository.save(user);

        String token = jwtUtil.generateToken(user.getEmail());
        return new AuthResponse(token);
    }

    // Login
    public AuthResponse login(LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        users user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        String token = jwtUtil.generateToken(user.getEmail());
        return new AuthResponse(token);
    }
}