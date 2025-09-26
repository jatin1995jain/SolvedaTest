package com.example.solveda.practice.service;
import com.example.solveda.practice.entity.Meta;
import com.example.solveda.practice.entity.ThermostatData;
import com.example.solveda.practice.repository.ThermostatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Random;

@Service
public class ThermostatSimulatorService {

    @Autowired
    private ThermostatRepository thermostatRepository;

    private Random random = new Random();

    // Insert new data asynchronously
    @Async("taskExecutor")
    public void insertData(String deviceId, String room) {
        ThermostatData data = new ThermostatData();
        data.setTimestamp(Instant.now());
        Meta meta = new Meta();
        meta.setDeviceId(deviceId);
        meta.setRoom(room);
        data.setMeta(meta);
        data.setTemperature(20 + random.nextDouble() * 10); // 20-30C
        data.setHumidity(40 + random.nextDouble() * 20);    // 40-60%
        thermostatRepository.save(data);
        //System.out.println("Inserted: " + data);
    }

    // Simulate multiple devices
    public void simulateDevices(String[] deviceIds, String[] rooms, int iterations, long delayMillis) {
        for (int i = 0; i < iterations; i++) {
            for (String device : deviceIds) {
                for (String room : rooms) {
                    insertData(device, room);   // insert new data
                }
            }

            try {
                Thread.sleep(delayMillis);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}