package org.richardinnocent.polysight.core.client.service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.junit.Test;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;

public class AbstractPolysightServiceTest {

  @Test
  public void testEqualsAndHashCode() {
    EqualsVerifier.forClass(AbstractPolysightService.class)
                  .suppress(Warning.STRICT_INHERITANCE)
                  .verify();
  }

  @Test
  public void testFieldsAreSetCorrectlyFromConstructor() {
    String baseUri = "base URI";
    ServiceVersion version = mock(ServiceVersion.class);
    RestTemplateBuilder templateBuilder = mock(RestTemplateBuilder.class);
    RestTemplate template = mock(RestTemplate.class);
    when(templateBuilder.build()).thenReturn(template);

    PolysightServiceConfiguration serviceConfiguration = mock(PolysightServiceConfiguration.class);
    when(serviceConfiguration.getBaseUri()).thenReturn(baseUri);
    when(serviceConfiguration.getVersion()).thenReturn(version);

    AbstractPolysightService service = new AbstractPolysightService(serviceConfiguration) {};

    assertEquals(baseUri, service.getBaseUri());
    assertEquals(version, service.getVersion());
  }

  @Test
  public void testGetVersionedUrl() {
    String baseUri = "base URI";
    String versionUri = "v1";

    PolysightServiceConfiguration serviceConfiguration = mock(PolysightServiceConfiguration.class);
    when(serviceConfiguration.getBaseUri()).thenReturn(baseUri);
    when(serviceConfiguration.getVersion()).thenReturn(() -> versionUri);

    AbstractPolysightService service = new AbstractPolysightService(serviceConfiguration) {};

    assertEquals(baseUri + "/api/" + versionUri, service.getVersionedUri());
  }

}