package com.example.phase3.controller;


import com.example.phase3.dto.ServiceDTO;
import com.example.phase3.entity.Service;
import com.example.phase3.exception.AuthenticationNotFoundException;
import com.example.phase3.exception.BaseHttpException;
import com.example.phase3.exception.NullPointerException;
import com.example.phase3.service.ServiceService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/service")
public class ServiceController {

    private final ServiceService serviceService;

    @PostMapping("/saveService")
    public void saveService(@RequestBody Service service) throws NullPointerException {
        serviceService.saveService(service);
    }

    @GetMapping("/getServiceByName/{name}")
    public ResponseEntity<?> getService(@PathVariable("name") String name){
        try{
            ServiceDTO serviceDTO = serviceService.getServiceByName(name);
            return ResponseEntity.ok(serviceDTO);
        }catch (BaseHttpException e) {
            return ResponseEntity.status(e.getStatus()).body(e.getMessage());
        }
    }

    @GetMapping("/getServiceById/{id}")
    public ResponseEntity<?> getService(@PathVariable("id") long id){
        try{
            ServiceDTO serviceDTO = serviceService.getServiceById(id);
            return ResponseEntity.ok(serviceDTO);
        }catch (BaseHttpException e) {
            return ResponseEntity.status(e.getStatus()).body(e.getMessage());
        }
    }

    @GetMapping("/getAllService")
    public ResponseEntity<?> getAllService(){
        try{
            List<ServiceDTO> servicesDTO = serviceService.getAllServices();
            return ResponseEntity.ok(servicesDTO);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PutMapping("/updateService/{id}")
    public void updateService(@PathVariable("id") long id, @RequestBody Service service) throws NullPointerException {
        serviceService.updateService(id, service);
    }

    @DeleteMapping("/deleteService/{id}")
    public void deleteService(@PathVariable("id") long id) throws AuthenticationNotFoundException {
        serviceService.deleteService(id);
    }
}
