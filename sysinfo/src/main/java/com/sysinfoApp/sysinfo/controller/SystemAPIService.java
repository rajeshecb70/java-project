package com.sysinfoApp.sysinfo.controller;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

import com.sysinfoApp.sysinfo.model.CustomSystemInfo;

import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.software.os.OperatingSystem;
import oshi.util.Util;
@Component
public class SystemAPIService {

    private final SystemInfo si;
    private final HardwareAbstractionLayer hal;
    private final OperatingSystem os;

    public SystemAPIService() {
        si = new SystemInfo();
        hal = si.getHardware();
        os = si.getOperatingSystem();
    }

    public String getUptimeInfo() {
        long uptimeSeconds = os.getSystemUptime();
        long hours = TimeUnit.SECONDS.toHours(uptimeSeconds);
        long minutes = TimeUnit.SECONDS.toMinutes(uptimeSeconds) % 60;
        long seconds = uptimeSeconds % 60;

        return String.format("Uptime: %02d:%02d:%02d (hh:mm:ss)", hours, minutes, seconds);
    }

    public double getCpuInfo() {
        CentralProcessor processor = hal.getProcessor();

        // Get CPU load average over a short interval.
        long[] loadTicks = processor.getSystemCpuLoadTicks();
        Util.sleep(1000); // Wait for a short interval
        double cpuLoad = processor.getSystemCpuLoadBetweenTicks(loadTicks) * 100;

        return cpuLoad; // CPU Load as percentage
    }

    public static void main(String[] args) {
        CustomSystemInfo systemInfo = new CustomSystemInfo();

        // Print uptime and CPU utilization
        System.out.println(systemInfo.getUptimeInfo());
        System.out.printf("CPU Utilization: %.2f%%\n", systemInfo.getCpuInfo());
    }
}
