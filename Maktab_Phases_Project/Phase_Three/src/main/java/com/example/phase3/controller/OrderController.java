package com.example.phase3.controller;

import com.example.phase3.entity.Order;
import com.example.phase3.exception.AuthenticationNotFoundException;
import com.example.phase3.exception.BaseHttpException;
import com.example.phase3.exception.NullPointerException;
import com.example.phase3.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/controller")
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/saveOrder")
    public void saveOrder(@RequestBody Order order) throws NullPointerException {
        orderService.saveOrder(order);
    }

    @GetMapping("/getOrder/{id}")
    public ResponseEntity<?> getOrder(@PathVariable("id") long id){
        try{
            Order order = orderService.getOrderById(id);
            return ResponseEntity.ok(order);
        } catch (BaseHttpException e) {
            return ResponseEntity.status(e.getStatus()).body(e.getMessage());
        }
    }

    @GetMapping("/getAllOrder")
    public ResponseEntity<?> getAllOrder(){
        try{
            List<Order> orders = orderService.getAllOrder();
            return ResponseEntity.ok(orders);
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PutMapping("/updateOrder/{id}")
    public void updateOrder(@PathVariable("id") long id, @RequestBody Order order) throws NullPointerException {
        orderService.updateOrder(id, order);
    }

    @DeleteMapping("/deleteOrder/{id}")
    public void deleteOrder(@PathVariable("id") long id) throws AuthenticationNotFoundException {
        orderService.deleteOrder(id);
    }
}
