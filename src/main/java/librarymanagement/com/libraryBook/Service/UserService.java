package librarymanagement.com.libraryBook.Service;

import librarymanagement.com.libraryBook.DTO.Request.RegisterRequest;
import librarymanagement.com.libraryBook.DTO.Response.UserResponse;
import librarymanagement.com.libraryBook.Enitity.users;
import librarymanagement.com.libraryBook.Exception.ResourceNotFoundException;
import librarymanagement.com.libraryBook.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserResponse addUser(RegisterRequest request) {
        users user = new users();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        users saved = userRepository.save(user);
        return mapToResponse(saved);
    }

    public List<UserResponse> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    public UserResponse getUserById(Long id) {
        users user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        return mapToResponse(user);
    }

    public UserResponse updateUser(Long id, RegisterRequest request) {
        users user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        users updated = userRepository.save(user);
        return mapToResponse(updated);
    }

    public String deleteUser(Long id) {
        userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        userRepository.deleteById(id);
        return "User deleted successfully";
    }

    private UserResponse mapToResponse(users user) {
        UserResponse response = new UserResponse();
        response.setId(user.getId());
        response.setName(user.getName());
        response.setEmail(user.getEmail());
        return response;
    }
}