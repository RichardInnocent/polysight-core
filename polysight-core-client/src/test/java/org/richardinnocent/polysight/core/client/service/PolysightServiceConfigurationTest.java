package org.richardinnocent.polysight.core.client.service;

import static org.junit.Assert.*;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.junit.Test;

public class PolysightServiceConfigurationTest {

  @Test
  public void testSettingValuesFromConstructor() {
    String baseUri = "https://myservice.com";
    ServiceVersion version = new MajorOnlyServiceVersion(3);

    PolysightServiceConfiguration config = new PolysightServiceConfiguration(baseUri, version);
    assertEquals(baseUri, config.getBaseUri());
    assertEquals(version, config.getVersion());
  }

  @Test
  public void testUriHasTrailingForwardSlashRemovedIfPresent() {
    String baseUri = "https://myservice.com";
    ServiceVersion version = new MajorOnlyServiceVersion(3);

    PolysightServiceConfiguration config =
        new PolysightServiceConfiguration(" " + baseUri + "/ ", version);
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