package com.hotelvista.service_service.repository;

import com.hotelvista.service_service.model.Service;
import com.hotelvista.service_service.model.ServiceCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ServiceRepository extends JpaRepository<Service, String> {
    List<Service> findAllByAvailability(boolean availability);

    List<Service> findAllByServiceNameContainingIgnoreCase(String serviceName);

    List<Service> findAllByServiceCategory(ServiceCategory serviceCategory);
}

