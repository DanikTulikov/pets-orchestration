package com.tulikov.homeautomation.petsorchestartion.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tulikov.homeautomation.petsorchestartion.dao.HeaterDao;
import com.tulikov.homeautomation.petsorchestartion.model.Heater;
import com.tulikov.homeautomation.petsorchestartion.service.GenericDeviceService;
import com.tulikov.homeautomation.petsorchestartion.service.HeaterService;

@Service
public class HeaterServiceImpl extends GenericDeviceService<Heater> implements HeaterService {

  @Autowired
  public HeaterServiceImpl(HeaterDao heaterDao) {
    super(heaterDao);
  }
}
