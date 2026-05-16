package com.hotelvista.service_service.model;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "services")
public class Service {
    @Id
    @Column(name = "service_id")
    private String serviceID;

    @Column(name = "service_name")
    private String serviceName;

    private String description;

    private Double price;
    
    private String unit;

    private boolean availability;

    @Column(name = "service_hours")
    private String serviceHours;

    @Enumerated(EnumType.STRING)
    private ServiceCategory serviceCategory;

    @ElementCollection
    @CollectionTable(name = "service_images", joinColumns = @JoinColumn(name = "service_id"))
    @Column(name = "images_url")
    private List<String> images;

    @ElementCollection
    @CollectionTable(name = "service_room_types", joinColumns = @JoinColumn(name = "service_id"))
    @Column(name = "room_type_id")
    private List<String> allowedRoomTypes;
}

