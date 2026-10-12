package edu.studentportfolio.repository;
import edu.studentportfolio.entity.CareerTask; import org.springframework.data.jpa.repository.JpaRepository; import java.util.List;
public interface CareerTaskRepository extends JpaRepository<CareerTask,Long>{ List<CareerTask> findByUserEmailOrderByDeadlineAsc(String email); }
