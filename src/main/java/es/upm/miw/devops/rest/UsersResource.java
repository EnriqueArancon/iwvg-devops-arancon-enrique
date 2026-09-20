package es.upm.miw.devops.rest;

import es.upm.miw.devops.code.User;
import es.upm.miw.devops.code.UsersDatabase;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersResource {

    private final es.upm.miw.devops.code.UserService userService;

    @org.springframework.beans.factory.annotation.Autowired
    public UsersResource(es.upm.miw.devops.code.UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> readAll() {
        return new UsersDatabase().findAll().toList();
    }

    @org.springframework.web.bind.annotation.PutMapping("/{id}")
    public User update(@org.springframework.web.bind.annotation.PathVariable String id, @org.springframework.web.bind.annotation.RequestBody User user) {
        try {
            return this.userService.update(id, user);
        } catch (IllegalArgumentException e) {
            throw new org.springframework.web.server.ResponseStatusException(org.springframework.http.HttpStatus.NOT_FOUND, "User not found");
        }
    }
}
