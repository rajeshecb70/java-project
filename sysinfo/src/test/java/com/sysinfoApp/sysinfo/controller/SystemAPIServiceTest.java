package com.sysinfoApp.sysinfo.controller;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SystemAPIServiceTest {

  private SystemAPIService systemAPIService;

  @BeforeEach
  void setUp() {
    // Initialize the systemAPIService instance before each test
    systemAPIService = new SystemAPIService();
  }

  @Test
  void testGetSystemUptime() {
    // Call the method using the instance created in setUp()
    String uptime = systemAPIService.getUptimeInfo();
    assertNotNull(uptime, "Uptime should not be null");
    assertTrue(uptime.contains("Uptime:"), "Uptime string should contain 'Uptime:'");
  }

  @Test
  void testGetSystemCpuLoad() {
    // Call the method using the instance created in setUp()
    double cpuLoad = systemAPIService.getCpuInfo();

    // Assert that the CPU load is a valid number and is non-negative
    assertTrue(cpuLoad >= 0, "CPU load should be non-negative");

    // Optionally, assert that the value is below 100%
    assertTrue(cpuLoad <= 100, "CPU load should be below or equal to 100%");
  }
}
