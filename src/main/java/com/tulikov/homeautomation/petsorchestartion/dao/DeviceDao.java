package com.tulikov.homeautomation.petsorchestartion.dao;

import java.util.List;

import com.tulikov.homeautomation.petsorchestartion.model.Device;

public interface DeviceDao<T extends Device> {

  void add(T device);

  T get(Long id);

  void update(Long id, T device);

  void delete(Long id);

  List<T> getAll();

}
