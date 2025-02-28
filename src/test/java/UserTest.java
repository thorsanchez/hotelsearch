import com.example.hotelsearch2h.models.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserTest {

    private User user;

    @BeforeEach
    void setUp() {
        // Initialize a new User object before each test
        user = new User();
    }

    @AfterEach
    void tearDown() {
        // Reset the User object after each test
        user = null;
    }

    @Test
    void setName() {
        user.setName("Johannes");
        assertEquals("Johannes", user.getName());
    }

    @Test
    void getName() {
        user.setName("Johannes");
        assertEquals("Johannes", user.getName());
    }

    @Test
    void setEmail() {
        user.setEmail("joi@example.com");
        assertEquals("joi@example.com", user.getEmail());
    }

    @Test
    void getEmail() {
        user.setEmail("joi@example.com");
        assertEquals("joi@example.com", user.getEmail());
    }

    @Test
    void setPhoneNumber() {
        user.setPhoneNumber("1234567890");
        assertEquals("1234567890", user.getPhoneNumber());
    }

    @Test
    void getPhoneNumber() {
        user.setPhoneNumber("1234567890");
        assertEquals("1234567890", user.getPhoneNumber());
    }

    @Test
    void setNumberOfAdults() {
        user.setNumberOfAdults(2);
        assertEquals(2, user.getNumberOfAdults());
    }

    @Test
    void getNumberOfAdults() {
        user.setNumberOfAdults(2);
        assertEquals(2, user.getNumberOfAdults());
    }

    @Test
    void setNumberOfChildren() {
        user.setNumberOfChildren(1);
        assertEquals(1, user.getNumberOfChildren());
    }

    @Test
    void getNumberOfChildren() {
        user.setNumberOfChildren(1);
        assertEquals(1, user.getNumberOfChildren());
    }

    @Test
    void setId() {
        user.setId(1);
        assertEquals(1, user.getId());
    }

    @Test
    void getId() {
        user.setId(1);
        assertEquals(1, user.getId());
    }
}
