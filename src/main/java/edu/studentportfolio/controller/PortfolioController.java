package edu.studentportfolio.controller;

import edu.studentportfolio.entity.*; import edu.studentportfolio.service.PortfolioService; import jakarta.validation.Valid; import jakarta.validation.constraints.*; import org.springframework.http.*; import org.springframework.security.core.annotation.AuthenticationPrincipal; import org.springframework.security.core.userdetails.UserDetails; import org.springframework.web.bind.annotation.*; import java.util.*;

@RestController @RequestMapping("/api")
public class PortfolioController {
 private final PortfolioService service; public PortfolioController(PortfolioService service){this.service=service;}
 private String email(UserDetails u){return u.getUsername();}
 public record StatusUpdate(@NotBlank String status){}
 @GetMapping("/students/me") public Object profile(@AuthenticationPrincipal UserDetails u){return service.profile(email(u));}
 @PutMapping("/students/me") public Object updateProfile(@AuthenticationPrincipal UserDetails u,@RequestBody Map<String,Object>x){return service.updateProfile(email(u),x);}
 @GetMapping("/skills") public List<Skill> skills(@AuthenticationPrincipal UserDetails u,@RequestParam(required=false)String category){var v=service.skills(email(u));return category==null?v:v.stream().filter(s->category.equalsIgnoreCase(s.getCategory())).toList();}
 @PostMapping("/skills") public ResponseEntity<Skill> addSkill(@AuthenticationPrincipal UserDetails u,@RequestBody Map<String,Object>x){return ResponseEntity.status(201).body(service.saveSkill(email(u),x,null));}
 @PutMapping("/skills/{id}") public Skill updateSkill(@AuthenticationPrincipal UserDetails u,@PathVariable Long id,@RequestBody Map<String,Object>x){return service.saveSkill(email(u),x,id);}
 @DeleteMapping("/skills/{id}") public ResponseEntity<Void> deleteSkill(@AuthenticationPrincipal UserDetails u,@PathVariable Long id){service.deleteSkill(email(u),id);return ResponseEntity.noContent().build();}
 @GetMapping("/projects") public List<Project> projects(@AuthenticationPrincipal UserDetails u,@RequestParam(required=false)String search){var v=service.projects(email(u));return search==null?v:v.stream().filter(p->p.getTitle().toLowerCase().contains(search.toLowerCase())).toList();}
 @PostMapping("/projects") public ResponseEntity<Project> addProject(@AuthenticationPrincipal UserDetails u,@RequestBody Map<String,Object>x){return ResponseEntity.status(201).body(service.saveProject(email(u),x,null));}
 @PutMapping("/projects/{id}") public Project updateProject(@AuthenticationPrincipal UserDetails u,@PathVariable Long id,@RequestBody Map<String,Object>x){return service.saveProject(email(u),x,id);}
 @DeleteMapping("/projects/{id}") public ResponseEntity<Void> deleteProject(@AuthenticationPrincipal UserDetails u,@PathVariable Long id){service.deleteProject(email(u),id);return ResponseEntity.noContent().build();}
 @GetMapping("/certifications") public List<Certification> certifications(@AuthenticationPrincipal UserDetails u){return service.certifications(email(u));}
 @PostMapping("/certifications") public ResponseEntity<Certification> addCertification(@AuthenticationPrincipal UserDetails u,@RequestBody Map<String,Object>x){return ResponseEntity.status(201).body(service.saveCertification(email(u),x,null));}
 @PutMapping("/certifications/{id}") public Certification updateCertification(@AuthenticationPrincipal UserDetails u,@PathVariable Long id,@RequestBody Map<String,Object>x){return service.saveCertification(email(u),x,id);}
 @DeleteMapping("/certifications/{id}") public ResponseEntity<Void> deleteCertification(@AuthenticationPrincipal UserDetails u,@PathVariable Long id){service.deleteCertification(email(u),id);return ResponseEntity.noContent().build();}
 @GetMapping("/career-tasks") public List<CareerTask> tasks(@AuthenticationPrincipal UserDetails u,@RequestParam(required=false)String status,@RequestParam(required=false)String priority){var v=service.tasks(email(u));if(status!=null)v=v.stream().filter(t->status.equalsIgnoreCase(t.getStatus())).toList();if(priority!=null)v=v.stream().filter(t->priority.equalsIgnoreCase(t.getPriority())).toList();return v;}
 @PostMapping("/career-tasks") public ResponseEntity<CareerTask> addTask(@AuthenticationPrincipal UserDetails u,@RequestBody Map<String,Object>x){return ResponseEntity.status(201).body(service.saveTask(email(u),x,null));}
 @PutMapping("/career-tasks/{id}") public CareerTask updateTask(@AuthenticationPrincipal UserDetails u,@PathVariable Long id,@RequestBody Map<String,Object>x){return service.saveTask(email(u),x,id);}
 @PatchMapping("/career-tasks/{id}/status") public CareerTask taskStatus(@AuthenticationPrincipal UserDetails u,@PathVariable Long id,@Valid @RequestBody StatusUpdate x){return service.taskStatus(email(u),id,x.status());}
 @DeleteMapping("/career-tasks/{id}") public ResponseEntity<Void> deleteTask(@AuthenticationPrincipal UserDetails u,@PathVariable Long id){service.deleteTask(email(u),id);return ResponseEntity.noContent().build();}
 @GetMapping("/dashboard/summary") public Object dashboard(@AuthenticationPrincipal UserDetails u){return service.dashboard(email(u));}
}
