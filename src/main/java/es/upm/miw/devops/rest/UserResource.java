package es.upm.miw.devops.rest;

import es.upm.miw.devops.code.User;
import es.upm.miw.devops.code.UsersDatabase;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserResource {

    @GetMapping("/{id}")
    public User read(@PathVariable String id) {
        return new UsersDatabase().findAll()
                .filter(user -> id.equals(user.getId()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("User not found: " + id));
    }
}
