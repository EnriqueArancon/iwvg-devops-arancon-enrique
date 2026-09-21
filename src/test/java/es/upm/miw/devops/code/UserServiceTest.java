package es.upm.miw.devops.code;

import org.junit.jupiter.api.Test;
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
}
