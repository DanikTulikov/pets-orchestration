package com.tulikov.homeautomation.petsorchestartion.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tulikov.homeautomation.petsorchestartion.dao.IlluminatorDao;
import com.tulikov.homeautomation.petsorchestartion.model.Illuminator;
import com.tulikov.homeautomation.petsorchestartion.service.GenericDeviceService;
import com.tulikov.homeautomation.petsorchestartion.service.IlluminatorService;

@Service
public class IlluminatorServiceImpl extends GenericDeviceService<Illuminator> implements IlluminatorService {

  @Autowired
  public IlluminatorServiceImpl(IlluminatorDao illuminatorDao) {
    super(illuminatorDao);
  }

}
