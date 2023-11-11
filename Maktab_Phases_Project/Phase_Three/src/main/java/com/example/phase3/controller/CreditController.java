package com.example.phase3.controller;

import com.example.phase3.dto.CreditDTO;
import com.example.phase3.entity.Credit;
import com.example.phase3.exception.AuthenticationNotFoundException;
import com.example.phase3.exception.BaseHttpException;
import com.example.phase3.exception.NullPointerException;
import com.example.phase3.service.CreditService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/credit")
public class CreditController {

    private final CreditService creditService;

    @PostMapping("/saveCredit")
    public void saveCredit(@RequestBody Credit credit) throws NullPointerException {
        creditService.saveCredit(credit);
    }

    @GetMapping("/getCredit/{id}")
    public ResponseEntity<?> getCredit(@PathVariable("id") long id){
        try{
            CreditDTO creditDTO = creditService.getCreditById(id);
            return ResponseEntity.ok(creditDTO);
        }catch (BaseHttpException e) {
            return ResponseEntity.status(e.getStatus()).body(e.getMessage());
        }
    }

    @GetMapping("/getAllCredit")
    public ResponseEntity<?> getAllCredit(){
        try{
            List<CreditDTO> credits = creditService.getAllCredit();
            return ResponseEntity.ok(credits);
        } catch(Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PutMapping("/updateCredit/{id}")
    public void updateCredit(@PathVariable("id") long id,@RequestBody Credit credit) throws NullPointerException {
        creditService.updateCredit(id,credit);
    }

    @DeleteMapping("/deleteCredit/{id}")
    public void deleteCredit(@PathVariable("id") long id) throws AuthenticationNotFoundException {
        creditService.deleteCredit(id);
    }
}
