package com.tulikov.homeautomation.petsorchestartion.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tulikov.homeautomation.petsorchestartion.dao.FeederDao;
import com.tulikov.homeautomation.petsorchestartion.model.Feeder;
import com.tulikov.homeautomation.petsorchestartion.service.FeederService;
import com.tulikov.homeautomation.petsorchestartion.service.GenericDeviceService;

@Service
public class FeederServiceImpl extends GenericDeviceService<Feeder> implements FeederService {

  @Autowired
  public FeederServiceImpl(FeederDao feederDao) {
    super(feederDao);
  }
}
