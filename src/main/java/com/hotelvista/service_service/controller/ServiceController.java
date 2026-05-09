package com.hotelvista.service_service.controller;

import com.hotelvista.service_service.dto.ServiceRequestDTO;
import com.hotelvista.service_service.dto.ServiceResponseDTO;
import com.hotelvista.service_service.model.ServiceCategory;
import com.hotelvista.service_service.service.ServiceCatalogService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/services")
@CrossOrigin(origins = "http://localhost:5173")
public class ServiceController {
    private final ServiceCatalogService serviceCatalogService;

    @GetMapping
    public List<ServiceResponseDTO> findAll() {
        return serviceCatalogService.findAll();
    }

    @GetMapping("/{id}")
    public ServiceResponseDTO findById(@PathVariable String id) {
        return serviceCatalogService.findById(id);
    }

    @GetMapping("/availability")
    public List<ServiceResponseDTO> findAllByAvailability(@RequestParam boolean availability) {
        return serviceCatalogService.findAllByAvailability(availability);
    }

    @GetMapping("/name")
    public List<ServiceResponseDTO> findAllByServiceNameContainingIgnoreCase(@RequestParam String serviceName) {
        return serviceCatalogService.findAllByServiceNameContainingIgnoreCase(serviceName);
    }

    @GetMapping("/category")
    public List<ServiceResponseDTO> findAllByServiceCategory(@RequestParam ServiceCategory serviceCategory) {
        return serviceCatalogService.findAllByServiceCategory(serviceCategory);
    }

    @PostMapping
    public ServiceResponseDTO save(@RequestBody ServiceRequestDTO request) {
        return serviceCatalogService.save(request);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable String id) {
        serviceCatalogService.deleteById(id);
    }
}

