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

    @org.springframework.web.bind.annotation.PatchMapping
    public void updateActives(@org.springframework.web.bind.annotation.RequestBody List<User> users) {
        this.userService.updateActives(users);
    }
}
