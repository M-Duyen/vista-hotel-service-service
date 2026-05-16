package com.hotelvista.service_service.dto;

import com.hotelvista.service_service.model.ServiceCategory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Setter
public class ServiceResponseDTO {
    private String serviceID;
    private String serviceName;
    private String description;
    private Double price;
    private String unit;
    private boolean availability;
    private String serviceHours;
    private ServiceCategory serviceCategory;
    private List<String> images;
    private List<String> allowedRoomTypes;

}


