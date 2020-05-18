package org.richardinnocent.polysight.core.client.request;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;
import org.richardinnocent.polysight.core.client.service.PolysightService;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class RestTemplateServiceRequestTest {

  private final PolysightService service = mock(PolysightService.class);
  private final RestTemplateBuilder templateBuilder = mock(RestTemplateBuilder.class);
  private final RestTemplate template = mock(RestTemplate.class);

  @Before
  public void setUpBuilder() {
    when(templateBuilder.build()).thenReturn(template);
  }

  @Test
  public void testFieldsPassedToConstructorArePassedToExecuteInternal() {
    @SuppressWarnings("unchecked")
    ResponseEntity<String> expectedResponse = mock(ResponseEntity.class);

    PolysightServiceRequest<PolysightService, String> request =
        new RestTemplateServiceRequest<>(service, templateBuilder) {
      @Override
      protected ResponseEntity<String> executeInternal(PolysightService service,
                                                       RestTemplate template) {
        assertEquals(RestTemplateServiceRequestTest.this.service, service);
        assertEquals(RestTemplateServiceRequestTest.this.template, template);
        return expectedResponse;
      }
    };

    assertEquals(expectedResponse, request.execute());
  }

  @Test
  public void testFieldsTemplateIsAdjustedBeforeBeingBuiltIfRequested() {
    String rootUri = "rootUri";

    @SuppressWarnings("unchecked")
    ResponseEntity<String> expectedResponse = mock(ResponseEntity.class);

    PolysightServiceRequest<PolysightService, String> request =
        new RestTemplateServiceRequest<>(service, templateBuilder) {
          @Override
          protected ResponseEntity<String> executeInternal(PolysightService service,
                                                           RestTemplate template) {
            assertEquals(RestTemplateServiceRequestTest.this.service, service);
            assertEquals(RestTemplateServiceRequestTest.this.template, template);
            return expectedResponse;
          }

          @Override
          protected void modifyTemplate(RestTemplateBuilder templateBuilder) {
            templateBuilder.rootUri(rootUri);
          }
        };

    assertEquals(expectedResponse, request.execute());

    InOrder inOrder = inOrder(templateBuilder);
    inOrder.verify(templateBuilder, times(1)).rootUri(rootUri);
    inOrder.verify(templateBuilder, times(1)).build();
  }

}