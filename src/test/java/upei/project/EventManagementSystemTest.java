package upei.project;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class EventManagementSystemTest {
    @Test
    void testAddAndRemoveEvent() {
        EventManagementSystem system = new EventManagementSystem();
        Concert concert = new Concert("E1", "Jazz Night", "2025-11-21", "Hall", 2, "Trio", "Jazz");
        system.add(concert);
        assertTrue(system.contains(concert));
        system.remove(concert);
        assertFalse(system.contains(concert));
    }

    @Test
    void testAttendeeAndTicketManagement() {
        EventManagementSystem system = new EventManagementSystem();
        Attendee a = new Attendee("Alice", "alice@a.com");
        Concert concert = new Concert("E2", "Rock", "2025-12-1", "Arena", 1, "Band", "Rock");
        system.add(concert);
        system.add(a);
        assertTrue(system.contains(a));
        concert.addAttendee(a);
        assertTrue(concert.isAttending(a));
        Ticket ticket = new Ticket("T100", concert, a);
        system.add(ticket);
        assertTrue(system.contains(ticket));
        system.remove(ticket);
        assertFalse(system.contains(ticket));
    }

    @Test
    void testWaitlistAndPromotion() {
        Concert concert = new Concert("E3", "Tiny Show", "2025-12-2", "Stage", 1, "Soloist", "Indie");
        Attendee a1 = new Attendee("Bob", "bob@b.com");
        Attendee a2 = new Attendee("Cara", "cara@c.com");
        concert.addAttendee(a1);
        assertTrue(concert.isAttending(a1));
        concert.addAttendee(a2);
        assertTrue(concert.isWaitlisted(a2));
        concert.removeAttendee(a1); // Should promote Cara
        assertTrue(concert.isAttending(a2));
    }

    @Test
    void testSearchByTitle() {
        MultiDayEvent fest = new MultiDayEvent("FEST", "Winter Festival", "2025-12", "Grounds", 2);
        Concert sub1 = new Concert("C1", "Opening Night", "2025-12-1", "Stage1", 1, "Alpha", "EDM");
        Concert sub2 = new Concert("C2", "Finale", "2025-12-2", "Stage2", 1, "Beta", "Pop");
        fest.addSubEvent(sub1);
        fest.addSubEvent(sub2);
        MyLinkedList<Event> events = new MyLinkedList<>();
        events.add(fest);

        List<Event> found = new java.util.ArrayList<>();
        for (Event e : toList(events)) searchByTitleRecursive(e, "night", found);
        assertEquals(1, found.size());
        assertTrue(found.get(0).getName().toLowerCase().contains("night"));
    }

    @Test
    void testRecursiveSearchById() {
        EventManagementSystem system = new EventManagementSystem();
        MultiDayEvent mde = new MultiDayEvent("F", "Fest", "2025-12", "Fairgrounds", 10);
        Concert d1 = new Concert("D1", "Day1", "2025-12-01", "A", 3, "X", "Y");
        mde.addSubEvent(d1);
        system.add(mde);
        assertNotNull(system.findEventByIdRecursive("D1"));
        assertNull(system.findEventByIdRecursive("ZZ"));
    }

    // Helper for converting MyLinkedList to ArrayList
    private <T> List<T> toList(MyLinkedList<T> list) {
        List<T> out = new java.util.ArrayList<>();
        list.forEach(out::add);
        return out;
    }

    // Helper for recursive search by title
    private void searchByTitleRecursive(Event e, String q, List<Event> results) {
        if (e.getName().toLowerCase().contains(q)) results.add(e);
        if (e instanceof MultiDayEvent) {
            MultiDayEvent mde = (MultiDayEvent) e;
            for (Event sub : toList(mde.getSubEvents())) searchByTitleRecursive(sub, q, results);
        }
    }
}
