package com.tulikov.homeautomation.petsorchestartion.model;

import lombok.Data;

@Data
public abstract class Device {

  protected long id;
  protected String address;
  protected String name;
  protected boolean isOn;
  protected boolean isByTime;
  protected Activity activity;
  protected int threshold;
}
