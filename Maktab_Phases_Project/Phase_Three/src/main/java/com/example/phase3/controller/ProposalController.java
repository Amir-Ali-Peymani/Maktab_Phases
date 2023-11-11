package com.example.phase3.controller;

import com.example.phase3.dto.ProposalDTO;
import com.example.phase3.entity.Proposal;
import com.example.phase3.exception.AuthenticationNotFoundException;
import com.example.phase3.exception.BaseHttpException;
import com.example.phase3.exception.NullPointerException;
import com.example.phase3.service.ProposalService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/proposal")
public class ProposalController {

    private final ProposalService proposalService;

    @PostMapping("/saveProposal")
    public void saveProposal(@RequestBody Proposal proposal) throws NullPointerException {
        proposalService.saveProposal(proposal);
    }

    @GetMapping("/getProposal/{id}")
    public ResponseEntity<?> getProposal(@PathVariable("id")long id){
        try {
            ProposalDTO proposalDTO = proposalService.getProposalById(id);
            return ResponseEntity.ok(proposalDTO);
        }catch (BaseHttpException e){
            return ResponseEntity.status(e.getStatus()).body(e.getMessage());
        }
    }

    @GetMapping("/getAllProposal")
    public ResponseEntity<?> getAllProposals(){
        try {
            List<ProposalDTO> proposalsDTO = proposalService.getAllProposals();
            return ResponseEntity.ok(proposalsDTO);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PutMapping("/updateProposal/{id}")
    public void updateProposal(@PathVariable("id")long id, @RequestBody Proposal proposal) throws NullPointerException {
        proposalService.updateProposal(id, proposal);
    }

    @DeleteMapping("/deleteProposal/{id}")
    public void deleteProposal(@PathVariable("id") long id) throws AuthenticationNotFoundException {
        proposalService.deleteProposal(id);
    }
}
