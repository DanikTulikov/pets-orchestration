package com.tulikov.homeautomation.petsorchestartion.model;

import java.time.LocalTime;

import org.joda.time.Duration;
import org.joda.time.Period;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.tulikov.homeautomation.petsorchestartion.utils.DurationCombinedSerializer.DurationJsonDeserializer;
import com.tulikov.homeautomation.petsorchestartion.utils.DurationCombinedSerializer.DurationJsonSerializer;
import com.tulikov.homeautomation.petsorchestartion.utils.PeriodCombinedSerializer.PeriodJsonDeserializer;
import com.tulikov.homeautomation.petsorchestartion.utils.PeriodCombinedSerializer.PeriodJsonSerializer;

import lombok.Data;

@Data
public class Activity {

  private LocalTime timeToStart;

  @JsonSerialize(using = DurationJsonSerializer.class)
  @JsonDeserialize(using = DurationJsonDeserializer.class)
  private Duration duration;

  @JsonSerialize(using = PeriodJsonSerializer.class)
  @JsonDeserialize(using = PeriodJsonDeserializer.class)
  private Period period;
}
