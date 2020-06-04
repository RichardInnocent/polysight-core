package org.richardinnocent.polysight.core.common.mapper;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
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
    setSerializationInclusion(Include.NON_NULL);
    registerModule(new JodaModule());
    registerModule(new LocalDateModule());
  }

}
