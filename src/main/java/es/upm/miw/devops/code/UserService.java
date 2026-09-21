package es.upm.miw.devops.code;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    public User update(String id, User updatedUser) {
        return new UsersDatabase().findAll()
                .filter(user -> user.getId().equals(id))
                .findFirst()
                .map(user -> {
                    user.setName(updatedUser.getName());
                    user.setFamilyName(updatedUser.getFamilyName());
                    user.setEmail(updatedUser.getEmail());
                    user.setIdentity(updatedUser.getIdentity());
                    user.setAddress(updatedUser.getAddress());
                    user.setCity(updatedUser.getCity());
                    user.setProvince(updatedUser.getProvince());
                    user.setPostalCode(updatedUser.getPostalCode());
                    user.setActive(updatedUser.isActive());
                    user.setFractions(updatedUser.getFractions());
                    return user;
                })
                .orElseThrow(() -> new IllegalArgumentException("User not found: " + id));
    }

    public void updateActives(List<User> users) {
        users.forEach(userUpdate -> 
            new UsersDatabase().findAll()
                    .filter(u -> u.getId().equals(userUpdate.getId()))
                    .findFirst()
                    .ifPresent(u -> u.setActive(userUpdate.isActive()))
        );
    }
}
