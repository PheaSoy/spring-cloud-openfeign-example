package org.soyphea;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import static org.assertj.core.api.Assertions.*;
import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;
import org.mockserver.model.HttpRequest;
import org.springframework.http.MediaType;
import org.testcontainers.shaded.com.google.common.net.HttpHeaders;

import java.util.concurrent.TimeUnit;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class FrontendServiceIntegrationTest extends AbstractIntegrationTest{

    @Autowired
    TestRestTemplate testRestTemplate;

    @LocalServerPort
    int port;

    @BeforeEach
    public void setup(){
        HttpRequest request = request("/api/books").withMethod("GET");
        getMockServerClient().when(request).respond(response()
                .withBody("{\"title\":\"Enterprise Kubernetes\",\"id\":\"1373737\",\"publishDate\":\"2020-07-10\"}")
                .withHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON.toString())
                .withDelay(TimeUnit.SECONDS, 2));
    }
    @Test
    void test_search_book() {
        assertThat(testRestTemplate.getForEntity(urlBuilder()+"/api/books",String.class).getStatusCode()).isEqualTo(200);
    }

    String urlBuilder(){
        return String.format("http://localhost:%d/frontend",port);
    }
}
