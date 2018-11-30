package com.tulikov.homeautomation.petsorchestartion.dao.impl;

import java.io.OutputStreamWriter;
import java.io.Writer;

import org.springframework.stereotype.Component;

import com.fazecast.jSerialComm.SerialPort;

@Component
public class SerialPortTemplate {

  private static final String SERIAL_PORT_DESCRIPTOR = "COM2";

  public void write(String message) {
    SerialPort port = SerialPort.getCommPort(SERIAL_PORT_DESCRIPTOR);
    port.openPort();
    port.setComPortTimeouts(SerialPort.TIMEOUT_READ_SEMI_BLOCKING, 0, 0);

    try {
      writeToSerialPort(port, message);
    } finally {
      port.closePort();
    }
  }

  private void writeToSerialPort(SerialPort port, String message) {
    try(Writer portWriter = new OutputStreamWriter(port.getOutputStream())) {
      portWriter.write(message);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
