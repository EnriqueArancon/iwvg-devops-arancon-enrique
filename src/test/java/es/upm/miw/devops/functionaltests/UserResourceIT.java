package es.upm.miw.devops.functionaltests;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
@ActiveProfiles("test")
class UserResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testReadUserById() {
        webTestClient.get()
                .uri("/user/1")
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.id").isEqualTo("1")
                .jsonPath("$.name").isEqualTo("Oscar")
                .jsonPath("$.familyName").isEqualTo("Fernandez");
    }

    @Test
    void testReadUserByIdNotFound() {
        webTestClient.get()
                .uri("/user/999")
                .exchange()
                .expectStatus().is5xxServerError();
    }

    @Test
    void testSearchBillableUsers() {
        webTestClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/user/search")
                        .queryParam("q", "billable:true")
                        .build())
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.length()").isEqualTo(2)
                .jsonPath("$[0]").isEqualTo("Oscar Fernandez")
                .jsonPath("$[1]").isEqualTo("Ana Blanco");
    }

    @Test
    void testDeleteUser() {
        webTestClient.delete()
                .uri("/user/1")
                .exchange()
                .expectStatus().isOk();
    }

    @Test
    void testDeleteUserNotFound() {
        webTestClient.delete()
                .uri("/user/999")
                .exchange()
                .expectStatus().is5xxServerError();
    }

    @Test
    void testUpdateActive() {
        webTestClient.put()
                .uri("/user/1/active")
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.id").isEqualTo("1")
                .jsonPath("$.active").isEqualTo(true);
    }

    @Test
    void testUpdateActiveNotFound() {
        webTestClient.put()
                .uri("/user/999/active")
                .exchange()
                .expectStatus().is5xxServerError();
    }
}
