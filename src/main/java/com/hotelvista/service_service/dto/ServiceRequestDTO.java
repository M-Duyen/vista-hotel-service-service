package com.hotelvista.service_service.dto;

import com.hotelvista.service_service.entity.ServiceCategory;

import java.util.List;

public class ServiceRequestDTO {
    private String serviceName;
    private String description;
    private Double price;
    private boolean availability;
    private String serviceHours;
    private ServiceCategory serviceCategory;
    private List<String> images;

    public ServiceRequestDTO() {
    }

    public ServiceRequestDTO(String serviceName, String description, Double price, boolean availability, String serviceHours, ServiceCategory serviceCategory, List<String> images) {
        this.serviceName = serviceName;
        this.description = description;
        this.price = price;
        this.availability = availability;
        this.serviceHours = serviceHours;
        this.serviceCategory = serviceCategory;
        this.images = images;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public String getServiceHours() {
        return serviceHours;
    }

    public void setServiceHours(String serviceHours) {
        this.serviceHours = serviceHours;
    }

    public ServiceCategory getServiceCategory() {
        return serviceCategory;
    }

    public void setServiceCategory(ServiceCategory serviceCategory) {
        this.serviceCategory = serviceCategory;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }
}


