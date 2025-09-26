package com.example.solveda.practice.Controller;

import com.example.solveda.practice.entity.ThermostatData;
import com.example.solveda.practice.service.ThermostatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("/thermostats")
public class ThermostatController {

    @Autowired
    private ThermostatService thermostatService;

    @GetMapping("")
    public List<ThermostatData> getThermostatData(
            @RequestParam("deviceId") String deviceId,
            @RequestParam(value = "startTime", required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Instant startTime,
            @RequestParam(value = "endTime", required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Instant endTime) {

        return thermostatService.getThermostatData(deviceId, startTime, endTime);
    }
}
