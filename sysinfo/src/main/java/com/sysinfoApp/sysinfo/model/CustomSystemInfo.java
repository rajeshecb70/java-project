package com.sysinfoApp.sysinfo.model;

import java.util.concurrent.TimeUnit;
import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.software.os.OperatingSystem;
import oshi.util.Util;

/** Provides system information such as uptime and CPU load. */
public final class CustomSystemInfo {

  private static final int SECONDS_IN_MINUTE = 60;
  private static final int MILLISECONDS_IN_SECOND = 1000;
  private static final int CPU_LOAD_SCALE = 100;

  private final SystemInfo si;
  private final HardwareAbstractionLayer hal;
  private final OperatingSystem os;

  /** Initializes system information components. */
  public CustomSystemInfo() {
    si = new SystemInfo();
    hal = si.getHardware();
    os = si.getOperatingSystem();
  }

  /**
   * Retrieves the system uptime in hh:mm:ss format.
   *
   * @return A formatted string representing system uptime.
   */
  public String getUptimeInfo() {
    long uptimeSeconds = os.getSystemUptime();
    long hours = TimeUnit.SECONDS.toHours(uptimeSeconds);
    long minutes = TimeUnit.SECONDS.toMinutes(uptimeSeconds) % SECONDS_IN_MINUTE;
    long seconds = uptimeSeconds % SECONDS_IN_MINUTE;

    return String.format("Uptime: %02d:%02d:%02d (hh:mm:ss)", hours, minutes, seconds);
  }

  /**
   * Retrieves the current CPU load as a percentage.
   *
   * @return The CPU load percentage.
   */
  public double getCpuInfo() {
    CentralProcessor processor = hal.getProcessor();
    long[] loadTicks = processor.getSystemCpuLoadTicks();
    Util.sleep(MILLISECONDS_IN_SECOND); // Wait for a short interval
    return processor.getSystemCpuLoadBetweenTicks(loadTicks) * CPU_LOAD_SCALE;
  }
}
