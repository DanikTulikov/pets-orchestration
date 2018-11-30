package com.tulikov.homeautomation.petsorchestartion.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tulikov.homeautomation.petsorchestartion.dao.SprinklerDao;
import com.tulikov.homeautomation.petsorchestartion.model.Sprinkler;
import com.tulikov.homeautomation.petsorchestartion.service.GenericDeviceService;
import com.tulikov.homeautomation.petsorchestartion.service.SprinklerService;

@Service
public class SprinklerServiceImpl extends GenericDeviceService<Sprinkler> implements SprinklerService {

  @Autowired
  public SprinklerServiceImpl(SprinklerDao sprinklerDao) {
    super(sprinklerDao);
  }

}
