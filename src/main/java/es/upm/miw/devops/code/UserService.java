package es.upm.miw.devops.code;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    public void updateActives(List<User> users) {
        users.forEach(userUpdate -> 
            new UsersDatabase().findAll()
                    .filter(u -> u.getId().equals(userUpdate.getId()))
                    .findFirst()
                    .ifPresent(u -> {
                        if ("ADMIN".equals(u.getRole()) && !userUpdate.isActive()) {
                            // Do not deactivate ADMIN users
                            return;
                        }
                        u.setActive(userUpdate.isActive());
                    })
        );
    }
}
