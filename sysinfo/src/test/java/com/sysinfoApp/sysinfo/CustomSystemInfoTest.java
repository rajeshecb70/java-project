package com.sysinfoApp.sysinfo.model;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CustomSystemInfoTest {

  private CustomSystemInfo customSystemInfo;

  @BeforeEach
  void setUp() {
    customSystemInfo = new CustomSystemInfo();
  }

  @Test
  void testGetUptimeInfo() {
    String uptime = customSystemInfo.getUptimeInfo();
    assertNotNull(uptime, "Uptime should not be null");
    assertTrue(uptime.contains("Uptime:"), "Uptime string should contain 'Uptime:'");
  }

  @Test
  void testGetCpuInfo() {
    double cpuLoad = customSystemInfo.getCpuInfo();
    assertTrue(cpuLoad >= 0, "CPU load should be non-negative");
  }
}
