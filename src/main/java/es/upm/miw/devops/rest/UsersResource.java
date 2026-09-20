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

    @org.springframework.web.bind.annotation.PutMapping("/{id}")
    public User update(@org.springframework.web.bind.annotation.PathVariable String id, @org.springframework.web.bind.annotation.RequestBody User user) {
        return new UsersDatabase().findAll()
                .filter(u -> u.getId().equals(id))
                .findFirst()
                .map(u -> {
                    u.setName(user.getName());
                    u.setFamilyName(user.getFamilyName());
                    u.setEmail(user.getEmail());
                    u.setIdentity(user.getIdentity());
                    u.setAddress(user.getAddress());
                    u.setCity(user.getCity());
                    u.setProvince(user.getProvince());
                    u.setPostalCode(user.getPostalCode());
                    u.setActive(user.isActive());
                    u.setFractions(user.getFractions());
                    return u;
                })
                .orElseThrow(() -> new org.springframework.web.server.ResponseStatusException(org.springframework.http.HttpStatus.NOT_FOUND, "User not found"));
    }
}
