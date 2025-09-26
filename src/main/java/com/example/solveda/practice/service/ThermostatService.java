package com.example.solveda.practice.service;

import com.example.solveda.practice.entity.ThermostatData;
import com.example.solveda.practice.repository.ThermostatRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class ThermostatService {

    private final ThermostatRepository thermostatRepository;

    public ThermostatService(ThermostatRepository thermostatRepository) {
        this.thermostatRepository = thermostatRepository;
    }

    public List<ThermostatData> getThermostatData(
            String deviceId, Instant startTime, Instant endTime) {

        if (startTime != null && endTime != null) {
            return thermostatRepository.findByMetaDeviceIdAndTimestampBetween(deviceId, startTime, endTime);
        }

        return thermostatRepository.findByMetaDeviceIdAndTimestampBetween(
                deviceId, Instant.now().minusMillis(5*60*1000), Instant.now());

    }
}
