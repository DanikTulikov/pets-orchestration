package com.tulikov.homeautomation.petsorchestartion.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tulikov.homeautomation.petsorchestartion.dao.GenericDeviceDao;
import com.tulikov.homeautomation.petsorchestartion.dao.HeaterDao;
import com.tulikov.homeautomation.petsorchestartion.model.Heater;

@Repository
public class HeaterDaoImpl extends GenericDeviceDao<Heater> implements HeaterDao {

  @Autowired
  public HeaterDaoImpl(SerialPortTemplate serialPortTemplate) {
    super(serialPortTemplate);
  }

  @Override
  protected int getActivityNumber() {
    return 3;
  }

}
