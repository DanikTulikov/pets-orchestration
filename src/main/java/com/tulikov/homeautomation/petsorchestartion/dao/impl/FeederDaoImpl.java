package com.tulikov.homeautomation.petsorchestartion.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tulikov.homeautomation.petsorchestartion.dao.FeederDao;
import com.tulikov.homeautomation.petsorchestartion.dao.GenericDeviceDao;
import com.tulikov.homeautomation.petsorchestartion.model.Feeder;

@Repository
public class FeederDaoImpl extends GenericDeviceDao<Feeder> implements FeederDao {

  @Autowired
  public FeederDaoImpl(SerialPortTemplate serialPortTemplate) {
    super(serialPortTemplate);
  }

  @Override
  protected int getActivityNumber() {
    return 0;
  }
}
