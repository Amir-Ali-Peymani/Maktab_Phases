package com.example.phase3.dto;

import com.example.phase3.entity.SubService;
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
public class SubServiceDTO {
    private long id;
    private String name;
    private double basePrice;
    private String description;
    private long serviceId;
    private List<SpecialistDTO> specialistDTOS;
    private List<OrderDTO> orderDTOS;

    public static SubServiceDTO fromSubService(SubService subService){
        SubServiceDTO subServiceDTO = new SubServiceDTO();
        subServiceDTO.setId(subServiceDTO.getId());
        subServiceDTO.setName(subService.getName());
        subServiceDTO.setBasePrice(subService.getBasePrice());
        subServiceDTO.setDescription(subService.getDescription());
        subServiceDTO.setServiceId(subService.getService().getId());
        if(subService.getSpecialist() != null) {
            subServiceDTO.setSpecialistDTOS(
                    subService.getSpecialist().stream()
                            .map(SpecialistDTO::fromSpecialistDTO)
                            .collect(Collectors.toList())
            );
        }
        if (subService.getOrderList() != null) {
            subServiceDTO.setOrderDTOS(
                    subService.getOrderList().stream()
                            .map(OrderDTO::fromOrder)
                            .collect(Collectors.toList())
            );
        }
        return subServiceDTO;
    }

}
