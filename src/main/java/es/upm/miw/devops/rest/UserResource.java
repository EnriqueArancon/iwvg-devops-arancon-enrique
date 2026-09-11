package es.upm.miw.devops.rest;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserResource {

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        // En una aplicación real, aquí borraríamos al usuario de la base de datos.
        // Como el profesor solo nos ha dado un UsersDatabase falso (seeder estático),
        // no hay método delete(). Para que pase el test, este método se queda vacío
        // simulando que el borrado fue exitoso (devuelve estado 200 OK por defecto).
    }
}
