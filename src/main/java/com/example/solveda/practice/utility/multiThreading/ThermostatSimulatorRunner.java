package com.example.solveda.practice.utility.multiThreading;

import com.example.solveda.practice.service.ThermostatSimulatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ThermostatSimulatorRunner implements CommandLineRunner {

    @Autowired
    private ThermostatSimulatorService simulatorService;

    @Override
    public void run(String... args) throws Exception {
        String[] deviceIds = {"thermo1", "thermo2", "thermo3"};
        String[] rooms = {"living_room", "bedroom", "kitchen"};

        // Run simulation: 50 iterations, 1 second delay between iterations
        simulatorService.simulateDevices(deviceIds, rooms, 50, 1000);
    }
}