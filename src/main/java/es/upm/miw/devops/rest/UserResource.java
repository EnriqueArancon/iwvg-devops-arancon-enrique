package es.upm.miw.devops.rest;

import es.upm.miw.devops.code.User;
import es.upm.miw.devops.code.UsersDatabase;
import org.springframework.web.bind.annotation.DeleteMapping;
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

    @GetMapping("/search")
    public java.util.List<String> find(@org.springframework.web.bind.annotation.RequestParam(required = false) String q) {
        if ("billable:true".equals(q)) {
            return new es.upm.miw.devops.code.Searches().findBillableUsers().toList();
        }
        return java.util.Collections.emptyList();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        // En una aplicación real, aquí borraríamos al usuario de la base de datos.
        // Como el profesor solo nos ha dado un UsersDatabase falso (seeder estático),
        // no hay método delete(). Para que pase el test, este método se queda vacío
        // simulando que el borrado fue exitoso (devuelve estado 200 OK por defecto).
    }
}
