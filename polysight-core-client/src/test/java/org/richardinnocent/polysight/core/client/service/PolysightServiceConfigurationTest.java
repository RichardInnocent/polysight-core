package org.richardinnocent.polysight.core.client.service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.junit.Test;
import org.springframework.boot.web.client.RestTemplateBuilder;

public class PolysightServiceConfigurationTest {

  @Test
  public void testSettingValuesFromConstructor() {
    String baseUri = "https://myservice.com";
    ServiceVersion version = new MajorOnlyServiceVersion(3);
    RestTemplateBuilder templateBuilder = mock(RestTemplateBuilder.class);

    PolysightServiceConfiguration config =
        new PolysightServiceConfiguration(baseUri, version, templateBuilder);
    assertEquals(baseUri, config.getBaseUri());
    assertEquals(version, config.getVersion());
  }

  @Test
  public void testUriHasTrailingForwardSlashRemovedIfPresent() {
    String baseUri = "https://myservice.com";
    ServiceVersion version = new MajorOnlyServiceVersion(3);
    RestTemplateBuilder templateBuilder = mock(RestTemplateBuilder.class);

    PolysightServiceConfiguration config =
        new PolysightServiceConfiguration(" " + baseUri + "/ ", version, templateBuilder);
    assertEquals(baseUri, config.getBaseUri());
    assertEquals(version, config.getVersion());
  }

  @Test
  public void testEqualsAndHashCode() {
    EqualsVerifier.forClass(PolysightServiceConfiguration.class)
                  .suppress(Warning.STRICT_INHERITANCE)
                  .verify();
  }

}