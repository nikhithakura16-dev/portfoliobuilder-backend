package edu.studentportfolio.repository;
import edu.studentportfolio.entity.*; import org.springframework.data.jpa.repository.JpaRepository; import java.util.Optional;
public interface ProfileRepository extends JpaRepository<StudentProfile,Long>{ Optional<StudentProfile> findByUserEmail(String email); }
