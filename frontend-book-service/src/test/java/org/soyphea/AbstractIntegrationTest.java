package org.soyphea;

import org.mockserver.client.server.MockServerClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MockServerContainer;

@SpringBootTest
public class AbstractIntegrationTest {
    public static MockServerContainer mockServer = new MockServerContainer();

    public static MockServerClient mockServerClient;

    @DynamicPropertySource
    static void neo4jProperties(DynamicPropertyRegistry registry) {
        mockServer.start();
        mockServerClient =  new MockServerClient(mockServer.getContainerIpAddress(), mockServer.getServerPort());
        registry.add("book.baseUrl",mockServer::getEndpoint);
    }

    public  MockServerClient getMockServerClient() {
        return mockServerClient;
    }

}