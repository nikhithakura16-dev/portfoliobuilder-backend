package edu.studentportfolio.entity;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.Instant;

@Entity @Table(name="users")
public class User {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
    @Column(nullable=false) private String name;
    @Column(nullable=false, unique=true) private String email;
    @JsonIgnore @Column(nullable=false) private String password;
    private String collegeName; private String branch; private Integer graduationYear;
    private Instant createdAt = Instant.now();
    public User() {}
    public Long getId(){return id;} public String getName(){return name;} public void setName(String v){name=v;}
    public String getEmail(){return email;} public void setEmail(String v){email=v;}
    public String getPassword(){return password;} public void setPassword(String v){password=v;}
    public String getCollegeName(){return collegeName;} public void setCollegeName(String v){collegeName=v;}
    public String getBranch(){return branch;} public void setBranch(String v){branch=v;}
    public Integer getGraduationYear(){return graduationYear;} public void setGraduationYear(Integer v){graduationYear=v;}
    public Instant getCreatedAt(){return createdAt;}
}
