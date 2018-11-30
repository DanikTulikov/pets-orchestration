package com.tulikov.homeautomation.petsorchestartion.utils;

import java.io.IOException;

import org.joda.time.Duration;
import org.joda.time.Period;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.node.IntNode;

public class DurationCombinedSerializer {

  public static class DurationJsonSerializer extends JsonSerializer<Duration> {

    @Override
    public void serialize(Duration duration, JsonGenerator jsonGenerator, SerializerProvider serializerProvider)
        throws IOException {

      jsonGenerator.writeStartObject();
      jsonGenerator.writeNumberField("days", duration.getStandardDays());
      jsonGenerator.writeNumberField("hours", duration.getStandardHours() % 24);
      jsonGenerator.writeNumberField("minutes", duration.getStandardMinutes() % 60);
      jsonGenerator.writeNumberField("seconds", duration.getStandardSeconds() % 60);
      jsonGenerator.writeEndObject();
    }
  }

  public static class DurationJsonDeserializer extends JsonDeserializer<Duration> {

    @Override
    public Duration deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
        throws IOException {

      TreeNode duration = jsonParser.getCodec().readTree(jsonParser);
      IntNode days = (IntNode) duration.get("days");
      IntNode hours = (IntNode) duration.get("hours");
      IntNode minutes = (IntNode) duration.get("minutes");
      IntNode seconds = (IntNode) duration.get("seconds");

      return new Period()
          .withDays(days.intValue())
          .withHours(hours.intValue())
          .withMinutes(minutes.intValue())
          .withSeconds(seconds.intValue())
          .toStandardDuration();
    }
  }
}
