package edu.studentportfolio.controller;
import edu.studentportfolio.entity.User; import edu.studentportfolio.repository.UserRepository; import edu.studentportfolio.security.JwtService; import jakarta.validation.Valid; import jakarta.validation.constraints.*; import org.springframework.http.*; import org.springframework.security.crypto.password.PasswordEncoder; import org.springframework.web.bind.annotation.*; import java.util.Map;
@RestController @RequestMapping("/api/auth") public class AuthController {
 private final UserRepository users; private final PasswordEncoder encoder; private final JwtService jwt;
 public AuthController(UserRepository users,PasswordEncoder encoder,JwtService jwt){this.users=users;this.encoder=encoder;this.jwt=jwt;}
 public record Register(@NotBlank String name,@Email @NotBlank String email,@NotBlank @Size(min=8) String password,@NotBlank String collegeName,@NotBlank String branch,@NotNull @Min(2020) @Max(2100) Integer graduationYear){}
 public record Login(@Email @NotBlank String email,@NotBlank String password){}
 @PostMapping("/register") public ResponseEntity<?> register(@Valid @RequestBody Register in){if(users.existsByEmail(in.email().toLowerCase()))return ResponseEntity.status(409).body(Map.of("message","Email is already registered"));User u=new User();u.setName(in.name());u.setEmail(in.email().toLowerCase());u.setPassword(encoder.encode(in.password()));u.setCollegeName(in.collegeName());u.setBranch(in.branch());u.setGraduationYear(in.graduationYear());users.save(u);return ResponseEntity.status(201).body(response(u));}
 @PostMapping("/login") public ResponseEntity<?> login(@Valid @RequestBody Login in){var u=users.findByEmail(in.email().toLowerCase()).orElse(null);if(u==null||!encoder.matches(in.password(),u.getPassword()))return ResponseEntity.status(401).body(Map.of("message","Invalid email or password"));return ResponseEntity.ok(response(u));}
 private Map<String,Object> response(User u){return Map.of("token",jwt.create(u.getEmail()),"name",u.getName(),"email",u.getEmail());}
}
