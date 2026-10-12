package edu.studentportfolio.controller;
import org.springframework.http.*; import org.springframework.web.bind.MethodArgumentNotValidException; import org.springframework.web.bind.annotation.*; import org.springframework.web.server.ResponseStatusException; import java.util.*;
import org.springframework.dao.DataIntegrityViolationException; import java.time.format.DateTimeParseException;
@RestControllerAdvice public class ApiExceptionHandler {
 @ExceptionHandler(MethodArgumentNotValidException.class) ResponseEntity<?> validation(MethodArgumentNotValidException e){var m=new LinkedHashMap<String,String>();e.getBindingResult().getFieldErrors().forEach(x->m.put(x.getField(),x.getDefaultMessage()));return ResponseEntity.badRequest().body(Map.of("message","Please check the submitted fields","errors",m));}
 @ExceptionHandler(ResponseStatusException.class) ResponseEntity<?> status(ResponseStatusException e){return ResponseEntity.status(e.getStatusCode()).body(Map.of("message",Objects.toString(e.getReason(),"Request failed")));}
 @ExceptionHandler(DataIntegrityViolationException.class) ResponseEntity<?> conflict(DataIntegrityViolationException e){return ResponseEntity.status(409).body(Map.of("message","A record with these details already exists"));}
 @ExceptionHandler({IllegalArgumentException.class,DateTimeParseException.class}) ResponseEntity<?> badInput(Exception e){return ResponseEntity.badRequest().body(Map.of("message","One or more submitted values are invalid"));}
 @ExceptionHandler(Exception.class) ResponseEntity<?> other(Exception e){return ResponseEntity.status(500).body(Map.of("message","An unexpected server error occurred"));}
}
