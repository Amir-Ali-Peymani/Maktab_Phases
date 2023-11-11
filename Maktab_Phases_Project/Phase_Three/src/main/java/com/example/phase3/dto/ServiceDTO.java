package com.example.phase3.dto;

import com.example.phase3.entity.Service;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;
import java.util.stream.Collectors;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ServiceDTO {
    private long id;
    private String name;
    private Set<SubServiceDTO> subServices;

    public static ServiceDTO fromService(Service service) {
        ServiceDTO serviceDTO = new ServiceDTO();
        serviceDTO.setId(service.getId());
        serviceDTO.setName(service.getName());
        if (service.getSubServices() != null) {
            serviceDTO.setSubServices(
                    service.getSubServices().stream()
                            .map(SubServiceDTO::fromSubService)
                            .collect(Collectors.toSet())
            );
        }
        return serviceDTO;
    }
}
