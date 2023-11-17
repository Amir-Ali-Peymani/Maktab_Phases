package com.example.phase3.controller;


import com.example.phase3.dto.SpecialistDTO;
import com.example.phase3.entity.Proposal;
import com.example.phase3.entity.Specialist;
import com.example.phase3.exception.*;
import com.example.phase3.exception.NullPointerException;
import com.example.phase3.service.SpecialistService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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

    @PostMapping("/savePicture/{id}")
    public ResponseEntity<?> uploadPicture(@PathVariable("id")long id,
                                           @RequestParam("image") MultipartFile file) throws IOException {
        String uploadImage = specialistService.uploadImage(id, file);
        return ResponseEntity.status(HttpStatus.OK)
                .body(uploadImage);
    }

    @Transactional
    @GetMapping("/downloadImage/{id}")
    public ResponseEntity<?> downloadImage(@PathVariable("id")long id){
        byte[] imageData = specialistService.downloadImage(id);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.valueOf("image/png"))
                .body(imageData);
    }

    @PostMapping("/saveProposal/{id}/{orderId}")
    public void saveProposal(@PathVariable("id") long id, @PathVariable("orderId") long orderId, @RequestBody
                             Proposal proposal) throws UnAuthorizedSpecialistException {
        specialistService.specialistsGiveProposal(id, orderId, proposal);
    }

    @GetMapping("/login/{email}/{password}")
    public ResponseEntity<?> specialistLogin(@PathVariable("email") String email,
                                             @PathVariable("password") String password){
        try{
            SpecialistDTO specialistDTO = specialistService.getCustomerByEmailAndPassword(email, password);
            return ResponseEntity.ok(specialistDTO);
        } catch (InvalidUserNameAndPasswordException e) {
            throw new RuntimeException(e);
        } catch (BaseHttpException e) {
            return ResponseEntity.status(e.getStatus()).body(e.getMessage());
        }
    }

    @GetMapping("/getAllSpecialist")
    public ResponseEntity<?> getAllSpecialist(){
        try {
            List<SpecialistDTO> specialistsDTO = specialistService.getAllSpecialists();
            return ResponseEntity.ok(specialistsDTO);
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
