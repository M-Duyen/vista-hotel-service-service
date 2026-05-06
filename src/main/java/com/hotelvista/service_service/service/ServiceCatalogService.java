package com.hotelvista.service_service.service;

import com.hotelvista.service_service.dto.ServiceRequestDTO;
import com.hotelvista.service_service.dto.ServiceResponseDTO;
import com.hotelvista.service_service.entity.ServiceCategory;
import com.hotelvista.service_service.repository.ServiceRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import java.util.List;

@org.springframework.stereotype.Service
@RequiredArgsConstructor
@Transactional
public class ServiceCatalogService {
    private final ServiceRepository repository;

    public List<ServiceResponseDTO> findAll() {
        return repository.findAll().stream().map(this::toResponseDTO).toList();
    }

    public ServiceResponseDTO findById(String id) {
        return repository.findById(id).map(this::toResponseDTO).orElse(null);
    }

    public List<ServiceResponseDTO> findAllByAvailability(boolean availability) {
        return repository.findAllByAvailability(availability).stream().map(this::toResponseDTO).toList();
    }

    public List<ServiceResponseDTO> findAllByServiceNameContainingIgnoreCase(String serviceName) {
        return repository.findAllByServiceNameContainingIgnoreCase(serviceName).stream().map(this::toResponseDTO).toList();
    }

    public List<ServiceResponseDTO> findAllByServiceCategory(ServiceCategory serviceCategory) {
        return repository.findAllByServiceCategory(serviceCategory).stream().map(this::toResponseDTO).toList();
    }

    public ServiceResponseDTO save(ServiceRequestDTO request) {
        com.hotelvista.service_service.entity.Service service = new com.hotelvista.service_service.entity.Service();
        service.setServiceName(request.getServiceName());
        service.setDescription(request.getDescription());
        service.setPrice(request.getPrice());
        service.setAvailability(request.isAvailability());
        service.setServiceHours(request.getServiceHours());
        service.setServiceCategory(request.getServiceCategory());
        service.setImages(request.getImages());
        return toResponseDTO(repository.save(service));
    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }

    private ServiceResponseDTO toResponseDTO(com.hotelvista.service_service.entity.Service service) {
        return new ServiceResponseDTO(
                service.getServiceID(),
                service.getServiceName(),
                service.getDescription(),
                service.getPrice(),
                service.isAvailability(),
                service.getServiceHours(),
                service.getServiceCategory(),
                service.getImages()
        );
    }
}


