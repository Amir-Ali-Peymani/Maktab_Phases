package com.example.phase3.controller;


import com.example.phase3.entity.Service;
import com.example.phase3.exception.AuthenticationNotFoundException;
import com.example.phase3.exception.BaseHttpException;
import com.example.phase3.exception.NullPointerException;
import com.example.phase3.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/service")
public class ServiceController {


    private final ServiceService serviceService;

    @Autowired
    public ServiceController(ServiceService serviceService) {
        this.serviceService = serviceService;
    }

    @PostMapping("/saveService")
    public void saveService(@RequestBody Service service) throws NullPointerException {
        serviceService.saveService(service);
    }

    @GetMapping("/getService/{name}")
    public ResponseEntity<?> getService(@PathVariable("name") String name){
        try{
            Service service = serviceService.getServiceByName(name);
            return ResponseEntity.ok(service);
        }catch (BaseHttpException e) {
            return ResponseEntity.status(e.getStatus()).body(e.getMessage());
        }
    }

    @GetMapping("/getAllService")
    public ResponseEntity<?> getAllService(){
        try{
            List<Service> services = serviceService.getAllServices();
            return ResponseEntity.ok(services);
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
