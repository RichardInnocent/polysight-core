package org.richardinnocent.polysight.core.client.service;

/**
 * Specifies which version of a service is targeted. For major-only service versions, only the major
 * version of the service is considered when building the URI path. For example, requests will
 * target {@code https://someservice.com/api/v1/}. Any minor or patch updates to the service should
 * therefore expect to not affect the syntax of the requests or responses. Any change that requires
 * this would demand a new major service version.
 */
public final class MajorOnlyServiceVersion implements ServiceVersion {

  private final int version;

  /**
   * Creates a new service version.
   * @param version The version of the service.
   */
  public MajorOnlyServiceVersion(int version) {
    this.version = version;
  }

  /**
   * Gets the version of the service.
   * @return The version of the service.
   */
  public int getVersion() {
    return version;
  }

  @Override
  public String getUriForm() {
    return "v" + version;
  }

  @Override
  public String toString() {
    return getUriForm();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof MajorOnlyServiceVersion)) {
      return false;
    }
    MajorOnlyServiceVersion that = (MajorOnlyServiceVersion) o;
    return version == that.version;
  }

  @Override
  public int hashCode() {
    return version;
  }
}
