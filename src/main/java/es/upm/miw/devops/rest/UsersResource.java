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

    @GetMapping
    public List<User> readAll() {
        return new UsersDatabase().findAll().toList();
    }

    @org.springframework.web.bind.annotation.PatchMapping
    public void updateActives(@org.springframework.web.bind.annotation.RequestBody List<User> users) {
        users.forEach(userUpdate -> 
            new UsersDatabase().findAll()
                    .filter(u -> u.getId().equals(userUpdate.getId()))
                    .findFirst()
                    .ifPresent(u -> u.setActive(userUpdate.isActive()))
        );
    }
}
