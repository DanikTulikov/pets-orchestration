package com.tulikov.homeautomation.petsorchestartion.utils;

import java.io.IOException;

import org.joda.time.Period;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.node.IntNode;

public class PeriodCombinedSerializer {
  public static class PeriodJsonSerializer extends JsonSerializer<Period> {

    @Override
    public void serialize(Period period, JsonGenerator jsonGenerator, SerializerProvider serializerProvider)
        throws IOException {

      jsonGenerator.writeStartObject();
      jsonGenerator.writeNumberField("days", period.getDays());
      jsonGenerator.writeNumberField("hours", period.getHours() % 24);
      jsonGenerator.writeNumberField("minutes", period.getMinutes() % 60);
      jsonGenerator.writeNumberField("seconds", period.getSeconds() % 60);
      jsonGenerator.writeEndObject();
    }
  }

  public static class PeriodJsonDeserializer extends JsonDeserializer<Period> {

    @Override
    public Period deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
        throws IOException {

      TreeNode period = jsonParser.getCodec().readTree(jsonParser);
      IntNode days = (IntNode) period.get("days");
      IntNode hours = (IntNode) period.get("hours");
      IntNode minutes = (IntNode) period.get("minutes");
      IntNode seconds = (IntNode) period.get("seconds");

      return new Period()
          .withDays(days.intValue())
          .withHours(hours.intValue())
          .withMinutes(minutes.intValue())
          .withSeconds(seconds.intValue());
    }
  }
}
