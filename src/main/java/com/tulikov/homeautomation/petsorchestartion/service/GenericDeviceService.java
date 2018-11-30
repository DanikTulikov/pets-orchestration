package com.tulikov.homeautomation.petsorchestartion.service;

import java.util.List;

import com.tulikov.homeautomation.petsorchestartion.dao.DeviceDao;
import com.tulikov.homeautomation.petsorchestartion.model.Device;

public abstract class GenericDeviceService<T extends Device> implements DeviceService<T> {

  private DeviceDao<T> deviceDao;

  public GenericDeviceService(DeviceDao<T> deviceDao) {
    this.deviceDao = deviceDao;
  }

  @Override
  public void add(T device) {
    deviceDao.add(device);
  }

  @Override
  public T get(Long id) {
    return deviceDao.get(id);
  }

  @Override
  public void update(Long id, T device) {
    deviceDao.update(id ,device);
  }

  @Override
  public void delete(Long id) {
    deviceDao.delete(id);
  }

  @Override
  public List<T> getAll() {
    return deviceDao.getAll();
  }

  public DeviceDao<T> getDeviceDao() {
    return deviceDao;
  }
}
