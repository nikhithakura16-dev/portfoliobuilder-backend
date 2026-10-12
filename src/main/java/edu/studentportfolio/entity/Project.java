package edu.studentportfolio.entity;
import jakarta.persistence.*; import java.time.LocalDate;
@Entity @Table(name="projects")
public class Project {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @ManyToOne(optional=false) @JoinColumn(name="user_id") private User user;
 @Column(nullable=false) private String title; @Column(length=3000) private String description;
 private String technologies; private LocalDate startDate; private LocalDate completionDate; private String githubUrl; private String liveUrl;
 public Project(){} public Long getId(){return id;} public User getUser(){return user;} public void setUser(User v){user=v;}
 public String getTitle(){return title;} public void setTitle(String v){title=v;} public String getDescription(){return description;} public void setDescription(String v){description=v;}
 public String getTechnologies(){return technologies;} public void setTechnologies(String v){technologies=v;} public LocalDate getStartDate(){return startDate;} public void setStartDate(LocalDate v){startDate=v;}
 public LocalDate getCompletionDate(){return completionDate;} public void setCompletionDate(LocalDate v){completionDate=v;} public String getGithubUrl(){return githubUrl;} public void setGithubUrl(String v){githubUrl=v;}
 public String getLiveUrl(){return liveUrl;} public void setLiveUrl(String v){liveUrl=v;}
}
