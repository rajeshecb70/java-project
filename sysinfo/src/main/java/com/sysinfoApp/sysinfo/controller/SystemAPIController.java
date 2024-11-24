package com.sysinfoApp.sysinfo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller class to expose system information APIs.
 */
@RestController
@RequestMapping("/api/system")
public class SystemAPIController {

    private final SystemAPIService systemAPIService;

    @Autowired
    public SystemAPIController(SystemAPIService systemAPIService) {
        this.systemAPIService = systemAPIService;
    }

    /**
     * Endpoint to get the system uptime.
     *
     * @return A string representing system uptime.
     */
    @GetMapping("/uptime")
    public String getSystemUptime() {
        return systemAPIService.getUptimeInfo();
    }

    /**
     * Endpoint to get the system CPU load.
     *
     * @return The CPU load percentage.
     */
    @GetMapping("/cpu-load")
    public double getSystemCpuLoad() {
        return systemAPIService.getCpuInfo();
    }
}
