package org.richardinnocent.polysight.core.client;

/**
 * Presents a set of methods for interacting with an external Polysight service.
 */
public interface PolysightService {

  /**
   * Gets the base URI of the service, e.g. {@code https://myservice.com}.
   * @return The base URI of the service.
   */
  String getBaseUri();

  /**
   * Gets the version of the service that is targeted by this instance.
   * @return The version of the service that is targeted by this instance.
   */
  ServiceVersion getVersion();

  /**
   * It's expected that the URI to all versioned services exists in the form
   * <code>{hostname}/api/{version}</code>. This method builds this URI.
   * @return The URI to the versioned service.
   */
  String getVersionedUri();

}
