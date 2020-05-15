package org.richardinnocent.polysight.core.common.mapper;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.LocalDate;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;

import static org.junit.Assert.*;

public class ApiObjectMapperTest {

  private static final ApiObjectMapper MAPPER = new ApiObjectMapper();

  @Test
  public void testSerializationOfJodaDateTimes() throws JsonProcessingException {
    DateTime dateTime = new DateTime(2019, 10, 17, 19, 32, 15, DateTimeZone.forOffsetHours(3));
    assertEquals(Long.toString(dateTime.getMillis()), MAPPER.writeValueAsString(dateTime));
  }

  @Test
  public void testSerializationOfJodaLocalDate() throws JsonProcessingException {
    LocalDate date = new LocalDate(2019, 10, 17);
    assertEquals(
        String.format("\"%d-%d-%d\"", date.getYear(), date.getMonthOfYear(), date.getDayOfMonth()),
        MAPPER.writeValueAsString(date)
    );
  }

}