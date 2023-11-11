package com.example.phase3.dto;

import com.example.phase3.entity.Specialist;
import com.example.phase3.enumeration.SpecialistStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SpecialistDTO {
    private long id;
    private String name;
    private String lastName;
    private String email;
    private String password;
    private byte[] profilePicture;
    private SpecialistStatus specialistStatus;
    private long creditId;
    private List<ProposalDTO> proposalsDTOs;
    private List<OrderDTO> orderDTOS;

    public static SpecialistDTO fromSpecialistDTO(Specialist specialist) {
        SpecialistDTO specialistDTO = new SpecialistDTO();
        specialistDTO.setId(specialist.getId());
        specialistDTO.setName(specialist.getFirstName());
        specialistDTO.setLastName(specialist.getLastName());
        specialistDTO.setEmail(specialist.getEmail());
        specialistDTO.setProfilePicture(specialist.getProfilePicture());
        specialistDTO.setCreditId(specialist.getCredit().getId());
        if(specialist.getProposals() != null){
            specialistDTO.setProposalsDTOs(
                    specialist.getProposals().stream()
                            .map(ProposalDTO::fromProposal)
                            .collect(Collectors.toList())
            );
        }
        if (specialist.getOrders() != null) {
            specialistDTO.setOrderDTOS(
                    specialist.getOrders().stream()
                            .map(OrderDTO::fromOrder)
                            .collect(Collectors.toList())
            );
        }
        return specialistDTO;
    }
}
