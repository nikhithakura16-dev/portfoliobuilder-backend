package edu.studentportfolio.entity;
import jakarta.persistence.*;
@Entity @Table(name="skills")
public class Skill {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @ManyToOne(optional=false) @JoinColumn(name="user_id") private User user;
 @Column(nullable=false) private String name; private String category; private String proficiency;
 public Skill(){} public Long getId(){return id;} public User getUser(){return user;} public void setUser(User v){user=v;}
 public String getName(){return name;} public void setName(String v){name=v;} public String getCategory(){return category;} public void setCategory(String v){category=v;}
 public String getProficiency(){return proficiency;} public void setProficiency(String v){proficiency=v;}
}
