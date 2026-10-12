package edu.studentportfolio.entity;
import jakarta.persistence.*;
@Entity @Table(name="student_profiles")
public class StudentProfile {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @OneToOne(optional=false) @JoinColumn(name="user_id",unique=true) private User user;
 @Column(length=3000) private String summary; private String photoUrl; private String degree; private String phone; private String location; private String linkedinUrl; private String githubUrl;
 @Column(length=2000) private String careerObjective;
 public StudentProfile(){} public Long getId(){return id;} public User getUser(){return user;} public void setUser(User v){user=v;}
 public String getSummary(){return summary;} public void setSummary(String v){summary=v;} public String getPhotoUrl(){return photoUrl;} public void setPhotoUrl(String v){photoUrl=v;}
 public String getDegree(){return degree;} public void setDegree(String v){degree=v;} public String getPhone(){return phone;} public void setPhone(String v){phone=v;}
 public String getLocation(){return location;} public void setLocation(String v){location=v;} public String getLinkedinUrl(){return linkedinUrl;} public void setLinkedinUrl(String v){linkedinUrl=v;}
 public String getGithubUrl(){return githubUrl;} public void setGithubUrl(String v){githubUrl=v;} public String getCareerObjective(){return careerObjective;} public void setCareerObjective(String v){careerObjective=v;}
}
