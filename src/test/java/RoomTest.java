import com.example.hotelsearch2h.models.Room;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RoomTest {

    private Room room;

    @BeforeEach
    void setUp() {
        // Initialize a new Room object before each test
        room = new Room();
    }

    @AfterEach
    void tearDown() {
        // Reset the Room object after each test
        room = null;
    }

    //set room id to 1
    @Test
    void setId() {
        room.setId(1);
        assertEquals(1, room.getId());
    }

    // checking setting and gettin the hotel name
    @Test
    void getHotelName() {
        room.setHotelName("Test Hotel");
        assertEquals("Test Hotel", room.getHotelName());
    }

    @Test
    void setHotelName() {
        room.setHotelName("Test Hotel");
        assertEquals("Test Hotel", room.getHotelName());
    }

    @Test
    void getCity() {
        room.setCity("Test City");
        assertEquals("Test City", room.getCity());
    }

    @Test
    void setCity() {
        room.setCity("Test City");
        assertEquals("Test City", room.getCity());
    }

    @Test
    void getPostalCode() {
        room.setPostalCode("123");
        assertEquals("123", room.getPostalCode());
    }

    @Test
    void setPostalCode() {
        room.setPostalCode("123");
        assertEquals("123", room.getPostalCode());
    }

    @Test
    void getCountry() {
        room.setCountry("Test Country");
        assertEquals("Test Country", room.getCountry());
    }

    @Test
    void setCountry() {
        room.setCountry("Test Country");
        assertEquals("Test Country", room.getCountry());
    }

    @Test
    void isHasWifi() {
        room.setHasWifi(true);
        assertTrue(room.isHasWifi());
    }

    @Test
    void setHasWifi() {
        room.setHasWifi(true);
        assertTrue(room.isHasWifi());
    }

    @Test
    void isHasRoomService() {
        room.setHasRoomService(true);
        assertTrue(room.isHasRoomService());
    }

    @Test
    void setHasRoomService() {
        room.setHasRoomService(true);
        assertTrue(room.isHasRoomService());
    }

    @Test
    void isbigBathroom() {
        room.setbigBathroom(true);
        assertTrue(room.isbigBathroom());
    }

    @Test
    void setbigBathroom() {
        room.setbigBathroom(true);
        assertTrue(room.isbigBathroom());
    }
}
