import com.example.hotelsearch2h.models.Booking;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BookingTest {

    private Booking booking;

    @BeforeEach
    void setUp() {
        // Initialize a new Booking object before each test
        booking = new Booking();
    }

    @AfterEach
    void tearDown() {
        // Reset the Booking object after each test
        booking = null;
    }

    @Test
    void setStartDate() {
        LocalDate startDate = LocalDate.now();
        booking.setStartDate(startDate);
        assertEquals(startDate, booking.getStartDate());
    }

    @Test
    void getStartDate() {
        LocalDate startDate = LocalDate.now();
        booking.setStartDate(startDate);
        assertEquals(startDate, booking.getStartDate());
    }

    @Test
    void setEndDate() {
        LocalDate endDate = LocalDate.now().plusDays(1);
        booking.setEndDate(endDate);
        assertEquals(endDate, booking.getEndDate());
    }

    @Test
    void getEndDate() {
        LocalDate endDate = LocalDate.now().plusDays(1);
        booking.setEndDate(endDate);
        assertEquals(endDate, booking.getEndDate());
    }

    @Test
    void setCancelled() {
        booking.setCancelled(true);
        assertEquals(true, booking.isCancelled());
    }

    @Test
    void isCancelled() {
        booking.setCancelled(true);
        assertEquals(true, booking.isCancelled());
    }

    @Test
    void setRoomId() {
        booking.setRoomId(1);
        assertEquals(1, booking.getRoomId());
    }

    @Test
    void getRoomId() {
        booking.setRoomId(1);
        assertEquals(1, booking.getRoomId());
    }

    @Test
    void setUserID() {
        booking.setUserID(1);
        assertEquals(1, booking.getUserID());
    }

    @Test
    void getUserID() {
        booking.setUserID(1);
        assertEquals(1, booking.getUserID());
    }

    @Test
    void setId() {
        booking.setId(1);
        assertEquals(1, booking.getId());
    }

    @Test
    void getId() {
        booking.setId(1);
        assertEquals(1, booking.getId());
    }
}
