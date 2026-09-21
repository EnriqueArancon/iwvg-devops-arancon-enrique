package es.upm.miw.devops.code;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {

    @Test
    void testUpdateExistingUser() {
        UserService userService = new UserService();
        User updatedUser = new User();
        updatedUser.setName("NewName");
        updatedUser.setFamilyName("NewFamilyName");
        updatedUser.setEmail("new@example.com");

        User result = userService.update("1", updatedUser);

        assertEquals("NewName", result.getName());
        assertEquals("NewFamilyName", result.getFamilyName());
        assertEquals("new@example.com", result.getEmail());
    }

    @Test
    void testUpdateNonExistingUser() {
        UserService userService = new UserService();
        User updatedUser = new User();
        updatedUser.setName("NewName");

        assertThrows(IllegalArgumentException.class, () -> userService.update("999", updatedUser));
    }

    @Test
    void testUpdateActives() {
        UserService userService = new UserService();
        
        User userUpdate1 = new User("1", null, null, null);
        userUpdate1.setActive(false);
        
        User userUpdate2 = new User("2", null, null, null);
        userUpdate2.setActive(false);

        // This just verifies the logic executes without throwing exceptions.
        // In a real scenario with a mock database, we would verify the database was updated.
        assertDoesNotThrow(() -> userService.updateActives(List.of(userUpdate1, userUpdate2)));
    }
}
