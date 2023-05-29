import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SILab2Test {

    // Test cases for Every Branch craiteria
    @Test
    void testValidUserWithUniqueEmailAndUsername() {
        User user = new User("gjorge.argirov", "Passw0rd!", "gjorge.argirov@gmail.com");
        List<User> allUsers = new ArrayList<>();
        assertTrue(SILab2.function(user, allUsers));
    }

    @Test
    void testValidUserWithDuplicateEmailAndUniqueUsername() {
        List<User> allUsers = new ArrayList<>();
        User user = new User("josif.stojanov", "StrongPassword", "josif.stojanov@outlook.com");
        allUsers.add(new User("gjorge.argirov", "Passw0rd!", "josif.stojanov@outlook.com"));
        assertFalse(SILab2.function(user, allUsers));
    }

    @Test
    void testValidUserWithUniqueEmailAndDuplicateUsername() {
        List<User> allUsers = new ArrayList<>();
        User user = new User("josif.stojanov", "StrongPassword", "josif.stojanov@example.com");
        allUsers.add(new User("josif.stojanov", "Passw0rd!", "gjorge.argirov@gmail.com"));
        assertFalse(SILab2.function(user, allUsers));
    }

    @Test
    void testUserWithNullValues() {
        User user = null;
        List<User> allUsers = new ArrayList<>();
        assertThrows(RuntimeException.class, () -> SILab2.function(null, allUsers));
    }

    @Test
    void testUserWithNullInPassword() {
        List<User> allUsers = new ArrayList<>();
        User user = new User("gjorge.argirov", null, "gjorge.argirov@gmail.com");
        assertThrows(RuntimeException.class, () -> SILab2.function(user, allUsers));
    }

    @Test
    void testUserWithNullInEmail() {
        List<User> allUsers = new ArrayList<>();
        User user = new User("gjorge.argirov", "Passw0rd!", null);
        assertThrows(RuntimeException.class, () -> SILab2.function(user, allUsers));
    }

    @Test
    void testUserWithNullUsername() {
        List<User> allUsers = new ArrayList<>();
        User user = new User(null, "Pass1worD!", "gjorge.argirov@gmail.com");
        assertTrue(SILab2.function(user, allUsers));
        assertEquals(user.getEmail(), user.getUsername());
    }

    @Test
    void testInvalidPasswordLength() {
        List<User> allUsers = new ArrayList<>();
        User user = new User("gjorge.argirov", "test", "gjorge.argirov@gmail.com");
        assertFalse(SILab2.function(user, allUsers));
    }

    @Test
    void testInvalidPasswordWithUsernameSubstring() {
        List<User> allUsers = new ArrayList<>();
        User user = new User("gjorge.argirov", "gapass123", "gjorge.argirov@gmail.com");
        assertFalse(SILab2.function(user, allUsers));
    }

    @Test
    void testInvalidPasswordWithoutSpecialCharacters() {
        List<User> allUsers = new ArrayList<>();
        User user = new User("gjorge.argirov", "Password123", "gjorge.argirov@gmail.com");
        assertFalse(SILab2.function(user, allUsers));
    }

    @Test
    void testInvalidPasswordWithSpecialCharacters() {
        List<User> allUsers = new ArrayList<>();
        User user = new User("gjorge.argirov", "!SecurePassword27.03", "gjorge.argirov@gmail.com");
        assertTrue(SILab2.function(user, allUsers));
    }


    //In continue it is the Multiple Condition criteria
    @Test
    void testNullUserObject() {
        User user = null;
        assertThrows(RuntimeException.class, () -> SILab2.function(user, null));
    }

    @Test
    void testNullPassword() {
        User user = new User("gjorge.argirov", null, "gjorge.argirov@gmail.com");
        assertThrows(RuntimeException.class, () -> SILab2.function(user, null));
    }

    @Test
    void testNullEmail() {
        User user = new User("gjorge.argirov", "Passw0rd!", null);
        assertThrows(RuntimeException.class, () -> SILab2.function(user, null));
    }

    @Test
    void testNullUserObjectWithNullPassword() {
        User user = null;
        assertThrows(RuntimeException.class, () -> SILab2.function(user, null));
    }

    @Test
    void testNullUserObjectWithNullEmail() {
        User user = null;
        assertThrows(RuntimeException.class, () -> SILab2.function(user, null));
    }

    @Test
    void testNullPasswordWithNullEmail() {
        User user = new User("gjorge.argirov", null, null);
        assertThrows(RuntimeException.class, () -> SILab2.function(user, null));
    }

    @Test
    void testNullUserObjectWithNullPasswordAndNullEmail() {
        User user = null;
        assertThrows(RuntimeException.class, () -> SILab2.function(user, null));
    }

    @Test
    void testNonNullFields() {
        List<User> allUsers = new ArrayList<>();
        User user = new User("gjorge.argirov", "Passw0rd!", "gjorge.argirov@gmail.com");
        assertDoesNotThrow(() -> SILab2.function(user, allUsers));
    }


}