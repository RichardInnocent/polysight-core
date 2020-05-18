package org.richardinnocent.polysight.core.client.service;

/**
 * Specifies which version of a service is targeted. This affects which how any requests are formed,
 * including the path to which its sent. For example, requests for version 1 of a service might be
 * received on {@code https://someservice/api/v1/}, whilst version 2 of a service might be
 * received on {@code https://someservice/api/v2/}. As a general rule, the location of a service
 * can be found at <code>{hostname}/api/{version}</code>. The service version allows the building
 * of the {@code version} part of the URI via {@link #getUriForm()}.
 */
@FunctionalInterface
public interface ServiceVersion {

  /**
   * The version as it would appear in a URI. For example, requests for version 1 of a service might
   * be received on {@code https://someservice.com/api/v1/}, whilst version 2 would be found at
   * {@code https://someservice.com/api/v2/}. As a general rule, this can be simplified to the
   * following: <code>{hostname}/api/{version}/</code>. This method provides the {@code version} as
   * it should be presented in the URI.
   * @return The version as it would appear in a URI.
   */
  String getUriForm();

}
