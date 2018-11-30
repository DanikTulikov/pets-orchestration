package com.tulikov.homeautomation.petsorchestartion.service;

import java.util.List;

import com.tulikov.homeautomation.petsorchestartion.model.Device;

public interface DeviceService<T extends Device> {

  void add(T device);

  T get(Long id);

  void update(Long id, T device);

  void delete(Long id);

  List<T> getAll();
}
