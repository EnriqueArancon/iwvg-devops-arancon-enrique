package es.upm.miw.devops.code;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {

    @Test
    void testUpdateActives() {
        UserService userService = new UserService();
        
        // user 1 is now ADMIN in the dummy database
        User adminUserUpdate = new User("1", null, null, null);
        adminUserUpdate.setActive(false);
        
        User normalUserUpdate = new User("2", null, null, null);
        normalUserUpdate.setActive(false);

        // Verify the logic executes without throwing exceptions.
        assertDoesNotThrow(() -> userService.updateActives(List.of(adminUserUpdate, normalUserUpdate)));
    }
}
