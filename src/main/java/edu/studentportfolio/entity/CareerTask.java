package edu.studentportfolio.entity;
import jakarta.persistence.*; import java.time.LocalDate;
@Entity @Table(name="career_tasks")
public class CareerTask {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @ManyToOne(optional=false) @JoinColumn(name="user_id") private User user;
 @Column(nullable=false) private String title; @Column(length=2000) private String description; private String category; private LocalDate deadline;
 @Column(nullable=false) private String status="Not Started"; @Column(nullable=false) private String priority="Medium";
 public CareerTask(){} public Long getId(){return id;} public User getUser(){return user;} public void setUser(User v){user=v;}
 public String getTitle(){return title;} public void setTitle(String v){title=v;} public String getDescription(){return description;} public void setDescription(String v){description=v;}
 public String getCategory(){return category;} public void setCategory(String v){category=v;} public LocalDate getDeadline(){return deadline;} public void setDeadline(LocalDate v){deadline=v;}
 public String getStatus(){return status;} public void setStatus(String v){status=v;} public String getPriority(){return priority;} public void setPriority(String v){priority=v;}
}
