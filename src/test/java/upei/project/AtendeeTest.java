package upei.project;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AttendeeTest {

    @Test
    void testAttendeesWithDifferentEmailsAreNotEqual() {
        Attendee a1 = new Attendee("Alice", "alex@email.com");
        Attendee a2 = new Attendee("Alice", "alice@email.com");
        assertNotEquals(a1, a2);
        assertNotEquals(a1.hashCode(), a2.hashCode());
    }

    @Test
    void testNameAndEmailGetters() {
        Attendee a = new Attendee("Kim", "kim@email.com");
        assertEquals("Kim", a.getName());
        assertEquals("kim@email.com", a.getEmail());
    }

    @Test
    void testToStringFormat() {
        Attendee a = new Attendee("Zane", "zane@email.com");
        assertEquals("Zane <zane@email.com>", a.toString());
    }
}
