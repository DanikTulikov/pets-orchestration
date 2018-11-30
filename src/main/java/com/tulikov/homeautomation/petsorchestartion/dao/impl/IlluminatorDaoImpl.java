package com.tulikov.homeautomation.petsorchestartion.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tulikov.homeautomation.petsorchestartion.dao.GenericDeviceDao;
import com.tulikov.homeautomation.petsorchestartion.dao.IlluminatorDao;
import com.tulikov.homeautomation.petsorchestartion.model.Illuminator;

@Repository
public class IlluminatorDaoImpl extends GenericDeviceDao<Illuminator> implements IlluminatorDao {

  @Autowired
  public IlluminatorDaoImpl(SerialPortTemplate serialPortTemplate) {
    super(serialPortTemplate);
  }

  @Override
  protected int getActivityNumber() {
    return 1;
  }
}
