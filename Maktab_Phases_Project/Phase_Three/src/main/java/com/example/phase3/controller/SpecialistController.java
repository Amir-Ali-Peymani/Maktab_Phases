package com.example.phase3.controller;


import com.example.phase3.entity.Specialist;
import com.example.phase3.exception.*;
import com.example.phase3.exception.NullPointerException;
import com.example.phase3.service.SpecialistService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/specialist")
public class SpecialistController {

    private final SpecialistService specialistService;

    @PostMapping("/saveSpecialist")
    public void saveSpecialist(@RequestBody Specialist specialist) throws NullPointerException {
        specialistService.saveSpecialist(specialist);
    }

    @GetMapping("/login/{email}/{password}")
    public ResponseEntity<?> specialistLogin(@PathVariable("email") String email,
                                             @PathVariable("password") String password){
        try{
            Specialist specialist = specialistService.getCustomerByEmailAndPassword(email, password);
            return ResponseEntity.ok(specialist);
        } catch (InvalidUserNameAndPasswordException e) {
            throw new RuntimeException(e);
        } catch (BaseHttpException e) {
            return ResponseEntity.status(e.getStatus()).body(e.getMessage());
        }
    }

    @GetMapping("/getAllSpecialist")
    public ResponseEntity<?> getAllSpecialist(){
        try {
            List<Specialist> specialists = specialistService.getAllSpecialists();
            return ResponseEntity.ok(specialists);
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PutMapping("/updateSpecialist/{email}")
    public void updateSpecialist(@PathVariable("email") String email,
                                 @RequestBody Specialist specialist) throws NullPointerException, InvalidEmailException {
        specialistService.updateSpecialist(email, specialist);
    }

    @DeleteMapping("/deleteSpecialist/{id}")
    public void deleteSpecialist(@PathVariable("id") Long id) throws AuthenticationNotFoundException {
        specialistService.deleteSpecialist(id);
    }



}
