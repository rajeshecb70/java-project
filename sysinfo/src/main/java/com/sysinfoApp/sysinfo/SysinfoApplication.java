package com.sysinfoApp.sysinfo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/** Main entry point for the Sysinfo application. */
@SpringBootApplication
public class SysinfoApplication {

  /**
   * Starts the Sysinfo application.
   *
   * @param args Command-line arguments (not used).
   */
  public static void main(final String[] args) {
    SpringApplication.run(SysinfoApplication.class, args);
  }
}
