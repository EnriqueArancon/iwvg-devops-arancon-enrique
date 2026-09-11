package es.upm.miw.devops.rest;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserResource {

    @PutMapping("/{id}/active")
    public void updateActive(@PathVariable String id) {
        // Al igual que con el DELETE, esto es solo la "carcasa" (el endpoint) 
        // para que podáis hacer todo el flujo de despliegue en AWS y Docker.
        // Como no tenemos base de datos real, se deja el método vacío 
        // fingiendo que la actualización ha ido bien.
    }
}
