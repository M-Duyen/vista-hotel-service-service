package com.hotelvista.service_service.config;

import com.hotelvista.service_service.model.Service;
import com.hotelvista.service_service.model.ServiceCategory;
import com.hotelvista.service_service.repository.ServiceRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DataSeeder {

    @Bean
    @ConditionalOnProperty(name = "app.seed.enabled", havingValue = "true")
    ApplicationRunner seedServices(ServiceRepository repository) {
        return args -> {
            if (repository.count() > 0) {
                return;
            }

            List<Service> sampleServices = List.of(
                    new Service(
                            "SVC-001",
                            "Dịch vụ đưa đón sân bay",
                            "Xe riêng đưa đón từ sân bay đến khách sạn.",
                            25.0,
                            "Chuyến",
                            true,
                            "24/7",
                            ServiceCategory.TRANSPORT,
                            List.of(
                                    "https://picsum.photos/seed/airport-pickup-1/900/600",
                                    "https://picsum.photos/seed/airport-pickup-2/900/600"
                            ),
                            List.of()
                    ),
                    new Service(
                            "SVC-002",
                            "Giặt ủi lấy liền",
                            "Giặt, sấy và gấp trong vòng 4-6 tiếng.",
                            8.5,
                            "Kg",
                            true,
                            "06:00-22:00",
                            ServiceCategory.LAUNDRY,
                            List.of(
                                    "https://picsum.photos/seed/laundry-express-1/900/600",
                                    "https://picsum.photos/seed/laundry-express-2/900/600"
                            ),
                            List.of()
                    ),
                    new Service(
                            "SVC-003",
                            "Gói Spa Thư giãn",
                            "Massage 60 phút kèm trà thảo mộc.",
                            45.0,
                            "Lượt",
                            true,
                            "09:00-21:00",
                            ServiceCategory.SPA,
                            List.of(
                                    "https://picsum.photos/seed/spa-relax-1/900/600",
                                    "https://picsum.photos/seed/spa-relax-2/900/600"
                            ),
                            List.of()
                    ),
                    new Service(
                            "SVC-004",
                            "Tour Thành phố",
                            "Tham quan các địa điểm nổi tiếng trong nửa ngày.",
                            32.0,
                            "Khách",
                            false,
                            "08:00-17:00",
                            ServiceCategory.TOUR,
                            List.of(
                                    "https://picsum.photos/seed/city-tour-1/900/600",
                                    "https://picsum.photos/seed/city-tour-2/900/600"
                            ),
                            List.of()
                    ),
                    new Service(
                            "SVC-005",
                            "Buffet Sáng",
                            "Buffet sáng quốc tế tại nhà hàng chính.",
                            15.0,
                            "Suất",
                            true,
                            "06:30-10:30",
                            ServiceCategory.FOOD_BEVERAGE,
                            List.of(
                                    "https://picsum.photos/seed/breakfast-buffet-1/900/600",
                                    "https://picsum.photos/seed/breakfast-buffet-2/900/600"
                            ),
                            List.of()
                    ),
                    new Service(
                            "SVC-006",
                            "Truy cập Phòng Gym",
                            "Sử dụng không giới hạn các thiết bị tập gym.",
                            0.0,
                            "Ngày",
                            true,
                            "05:00-23:00",
                            ServiceCategory.WELLNESS,
                            List.of(
                                    "https://picsum.photos/seed/gym-access-1/900/600",
                                    "https://picsum.photos/seed/gym-access-2/900/600"
                            ),
                            List.of()
                    )
            );

            repository.saveAll(sampleServices);
        };
    }
}

