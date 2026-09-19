package es.upm.miw.devops.functionaltests;

import es.upm.miw.devops.code.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;


import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
public class UsersResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testReadAll() {
        this.webTestClient
                .get()
                .uri("/users")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(User.class)
                .value(users -> assertTrue(users.size() >= 6));
    }
}
