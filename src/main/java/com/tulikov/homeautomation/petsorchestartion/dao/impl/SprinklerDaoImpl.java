package com.tulikov.homeautomation.petsorchestartion.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tulikov.homeautomation.petsorchestartion.dao.GenericDeviceDao;
import com.tulikov.homeautomation.petsorchestartion.dao.SprinklerDao;
import com.tulikov.homeautomation.petsorchestartion.model.Sprinkler;

@Repository
public class SprinklerDaoImpl extends GenericDeviceDao<Sprinkler> implements SprinklerDao {

  @Autowired
  public SprinklerDaoImpl(SerialPortTemplate serialPortTemplate) {
    super(serialPortTemplate);
  }

  @Override
  protected int getActivityNumber() {
    return 2;
  }
}
