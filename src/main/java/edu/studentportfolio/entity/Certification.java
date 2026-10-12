package edu.studentportfolio.entity;
import jakarta.persistence.*; import java.time.LocalDate;
@Entity @Table(name="certifications")
public class Certification {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @ManyToOne(optional=false) @JoinColumn(name="user_id") private User user;
 @Column(nullable=false) private String name; private String organization; private LocalDate issueDate; private String credentialUrl;
 public Certification(){} public Long getId(){return id;} public User getUser(){return user;} public void setUser(User v){user=v;}
 public String getName(){return name;} public void setName(String v){name=v;} public String getOrganization(){return organization;} public void setOrganization(String v){organization=v;}
 public LocalDate getIssueDate(){return issueDate;} public void setIssueDate(LocalDate v){issueDate=v;} public String getCredentialUrl(){return credentialUrl;} public void setCredentialUrl(String v){credentialUrl=v;}
}
