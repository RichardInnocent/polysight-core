package org.richardinnocent.polysight.core.client.service;

import java.util.Objects;
import org.springframework.boot.web.client.RestTemplateBuilder;

public class PolysightServiceConfiguration {

  private final String baseUri;
  private final ServiceVersion version;

  /**
   * Creates a new service configuration.
   * @param baseUri The base URI of the service, e.g. {@code https://myservice.com}. If a trailing
   * {@code /} is detected, it will be removed.
   * @param version The version of the service.
   * @param templateBuilder The template for building API requests. This can contain configuration
   * such as timeout settings.
   */
  public PolysightServiceConfiguration(
      String baseUri, ServiceVersion version, RestTemplateBuilder templateBuilder)
      throws NullPointerException {
    this.baseUri = transformBaseUri(Objects.requireNonNull(baseUri, "Base URI is null"));
    this.version = Objects.requireNonNull(version, "Version is null");
  }

  private String transformBaseUri(String uri) {
    uri = uri.trim();
    if (uri.endsWith("/")) {
      uri = uri.substring(0, uri.length()-1);
    }
    return uri;
  }

  /**
   * Gets the base URI of the service, e.g. {@code https://myservice.com/}.
   * @return The base URI of the service.
   */
  public String getBaseUri() {
    return baseUri;
  }

  /**
   * The version of the service.
   * @return The version of the service.
   */
  public ServiceVersion getVersion() {
    return version;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof PolysightServiceConfiguration)) {
      return false;
    }
    PolysightServiceConfiguration that = (PolysightServiceConfiguration) o;
    return Objects.equals(baseUri, that.baseUri) && Objects.equals(version, that.version);
  }

  @Override
  public int hashCode() {
    return Objects.hash(baseUri, version);
  }
}