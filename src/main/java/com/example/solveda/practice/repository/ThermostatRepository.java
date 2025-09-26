package com.example.solveda.practice.repository;
import com.example.solveda.practice.entity.ThermostatData;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Repository
public interface ThermostatRepository extends MongoRepository<ThermostatData, String> {

    // Incase it returns null we will get empty object of optional
    Optional<ThermostatData> findTopByMetaDeviceIdAndMetaRoomOrderByTimestampDesc(
            String deviceId,
            String room
    );

    List<ThermostatData> findByMetaDeviceIdAndTimestampBetween(
            String deviceId,
            Instant start,
            Instant end
    );
}
