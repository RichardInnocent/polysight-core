package org.richardinnocent.polysight.core.common.mapper;

import org.richardinnocent.polysight.core.common.mapper.modules.LocalDateModule;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.joda.JodaModule;

/**
 * An {@link ObjectMapper} used to serialize/deserialize HTTP requests/responses.
 */
public class ApiObjectMapper extends ObjectMapper {

  /**
   * Creates a new object mapper, used in the serialization and deserialization of entities in HTTP
   * requests/responses, registering the appropriate modules.
   */
  public ApiObjectMapper() {
    registerModule(new JodaModule());
    registerModule(new LocalDateModule());
  }

}
