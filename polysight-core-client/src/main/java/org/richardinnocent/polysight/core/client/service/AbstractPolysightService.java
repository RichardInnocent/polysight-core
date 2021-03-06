package org.richardinnocent.polysight.core.client.service;

import java.util.Objects;

/**
 * Abstract implementation of {@link PolysightService}, with some basic implementations.
 */
public abstract class AbstractPolysightService implements PolysightService {

  private final String baseUri;
  private final ServiceVersion version;

  /**
   * Creates a new {@link PolysightService} with the given configuration.
   * @param configuration The configuration of the service.
   */
  public AbstractPolysightService(PolysightServiceConfiguration configuration) {
    Objects.requireNonNull(configuration, "Configuration is null");
    this.baseUri = configuration.getBaseUri();
    this.version = configuration.getVersion();
  }

  @Override
  public String getBaseUri() {
    return baseUri;
  }

  @Override
  public ServiceVersion getVersion() {
    return version;
  }

  @Override
  public String getVersionedUri() {
    return baseUri + "/api/" + version.getUriForm();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof AbstractPolysightService)) {
      return false;
    }
    AbstractPolysightService that = (AbstractPolysightService) o;
    return Objects.equals(baseUri, that.baseUri) &&
        Objects.equals(version, that.version);
  }

  @Override
  public int hashCode() {
    return Objects.hash(baseUri, version);
  }
}
