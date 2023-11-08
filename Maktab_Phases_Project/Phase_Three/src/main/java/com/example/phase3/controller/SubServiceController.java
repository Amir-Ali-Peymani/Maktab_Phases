package com.example.phase3.controller;


import com.example.phase3.entity.SubService;
import com.example.phase3.exception.AuthenticationNotFoundException;
import com.example.phase3.exception.BaseHttpException;
import com.example.phase3.exception.NullPointerException;
import com.example.phase3.service.SubServiceService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/subService")
public class SubServiceController {

    private final SubServiceService subServiceService;

    @PostMapping("/saveSubService")
    public void saveSubService(@RequestBody SubService subService) throws NullPointerException {
        subServiceService.saveSubService(subService);
    }

    @GetMapping("/getSubService/{name}")
    public ResponseEntity<?> getSubService(@PathVariable("name")String name){
        try{
            SubService subService = subServiceService.getSubServiceByName(name);
            return ResponseEntity.ok(subService);
        }catch (BaseHttpException e){
            return ResponseEntity.status(e.getStatus()).body(e.getMessage());
        }
    }

    @GetMapping("/getSubService/{id}")
    public ResponseEntity<?> getSubService(@PathVariable("id")long id){
        try{
            SubService subService = subServiceService.getSubServiceById(id);
            return ResponseEntity.ok(subService);
        }catch (BaseHttpException e){
            return ResponseEntity.status(e.getStatus()).body(e.getMessage());
        }
    }

    @GetMapping("/getAllSubService")
    public ResponseEntity<?> getAllSubService(){
        try{
            List<SubService> subServices = subServiceService.getAllSubServices();
            return ResponseEntity.ok(subServices);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PutMapping("/updateSubService/{id}")
    public void updateSubService(@PathVariable("id")long id, @RequestBody SubService subService) throws NullPointerException {
        subServiceService.updateSubService(id, subService);
    }

    @DeleteMapping("/deleteSubService/{id}")
    public void deleteSubService(@PathVariable("id")long id) throws AuthenticationNotFoundException {
        subServiceService.deleteSubService(id);
    }
}
