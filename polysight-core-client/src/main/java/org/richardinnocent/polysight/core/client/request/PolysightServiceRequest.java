package org.richardinnocent.polysight.core.client.request;

import org.richardinnocent.polysight.core.client.service.PolysightService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;

/**
 * A request to a Polysight service.
 * @param <S> The type of Polysight service to interact with.
 * @param <R> The type of entity returned by the response.
 */
@FunctionalInterface
@SuppressWarnings("unused")
public interface PolysightServiceRequest<S extends PolysightService, R> {

  /**
   * Executes the request.
   * @return The result of the request.
   * @throws RestClientException Thrown if there is a problem executing the request.
   */
  ResponseEntity<R> execute() throws RestClientException;
}