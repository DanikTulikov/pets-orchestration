package com.tulikov.homeautomation.petsorchestartion.dao;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.tulikov.homeautomation.petsorchestartion.dao.impl.SerialPortTemplate;
import com.tulikov.homeautomation.petsorchestartion.model.Device;

public abstract class GenericDeviceDao<T extends Device> implements DeviceDao<T> {

  private Map<Long, T> devices;

  private long currentId = 1;

  private SerialPortTemplate serialPortTemplate;

  public GenericDeviceDao(SerialPortTemplate serialPortTemplate) {
    this.serialPortTemplate = serialPortTemplate;
    devices = new HashMap<>();
  }

  @Override
  public void add(T device) {
//    setGlobalTime(device.getAddress());
//    updateDeviceParams(device);
    device.setId(currentId++);
    devices.put(device.getId(), device);
  }

  @Override
  public T get(Long id) {
    return devices.get(id);
  }

  @Override
  public void update(Long id, T device) {
//    updateDeviceParams(device);
    devices.put(id, device);
  }

  @Override
  public void delete(Long id) {
    T device = devices.remove(id);
//    serialPortTemplate.write(String.format("!%s;r%d=0\n", device.getAddress(), getActivityNumber()));
  }

  @Override
  public List<T> getAll() {
    return new ArrayList<>(devices.values());
  }

  protected abstract int getActivityNumber();

  protected Map<Long, T> getDevices() {
    return devices;
  }

  protected long getCurrentId() {
    return currentId;
  }

  protected SerialPortTemplate getSerialPortTemplate() {
    return serialPortTemplate;
  }

  private void setGlobalTime(String address) {
    serialPortTemplate.write((String.format("!%s;G=%d", address, getSecondsFromMidnight())));
  }

  private void updateDeviceParams(T device) {
    int isOn = device.isOn() ? 1 : 0;
    int isByTime = device.isByTime() ? 1 : 0;
    long duration = device.getActivity().getDuration().getStandardSeconds();
    long timeToStart = Duration.between(LocalTime.of(0, 0), device.getActivity().getTimeToStart()).getSeconds();
    long period = device.getActivity().getPeriod().getSeconds();
    int threshold = (int)(device.getThreshold() / 100. * 1023);

    serialPortTemplate.write(String.format("!%s;r%d=%d:m%d=%d:d%d=%d:t%d=%d:T%d=%d:v%d=%d\n", device.getAddress(),
        getActivityNumber(), isOn,
        getActivityNumber(), isByTime,
        getActivityNumber(), duration,
        getActivityNumber(), timeToStart,
        getActivityNumber(), period,
        getActivityNumber(), threshold));
  }

  private long getSecondsFromMidnight() {
    LocalDateTime now = LocalDateTime.now();
    LocalDateTime midnight = now.toLocalDate().atStartOfDay();

    return Duration.between(midnight, now).getSeconds();
  }
}
