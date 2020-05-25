package org.richardinnocent.polysight.core.client.request;

import org.richardinnocent.polysight.core.client.service.PolysightService;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

/**
 * An abstract {@link PolysightService} that uses Spring's {@link RestTemplate} to execute requests.
 * @param <S> The type of service interacted with by this request.
 * @param <R> The type of entity contained in the response.
 */
public abstract class RestTemplateServiceRequest<S extends PolysightService, R>
    implements PolysightServiceRequest<S, R> {

  private final S service;
  private final RestTemplate template;

  /**
   * Creates a new {@link PolysightService} that uses Spring's {@link RestTemplate} to execute
   * requests.
   * @param service The service to execute the request against.
   * @param templateBuilder The template builder, detailing specific requirements about the request,
   * such as its timeout.
   */
  public RestTemplateServiceRequest(S service, RestTemplateBuilder templateBuilder) {
    this.service = service;
    modifyTemplate(templateBuilder);
    this.template = templateBuilder.build();
  }

  /**
   * Should be overridden if this request requires specific configuration on the template.
   * @param templateBuilder The template to adjust.
   */
  @SuppressWarnings("unused")
  protected void modifyTemplate(RestTemplateBuilder templateBuilder) {}

  public final ResponseEntity<R> execute() throws RestClientException {
    return executeInternal(service, template);
  }

  /**
   * Executes the request.
   * @param service The service which should be used to action the request.
   * @param template The template to use.
   * @return The request response.
   * @throws RestClientException Thrown if there is a problem executing the request.
   */
  protected abstract ResponseEntity<R> executeInternal(S service, RestTemplate template)
      throws RestClientException;

}
