package edu.studentportfolio.repository;
import edu.studentportfolio.entity.Skill; import org.springframework.data.jpa.repository.JpaRepository; import java.util.List;
public interface SkillRepository extends JpaRepository<Skill,Long>{ List<Skill> findByUserEmail(String email); }
