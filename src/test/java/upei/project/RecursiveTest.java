package upei.project;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RecursiveTest {

    @Test
    void testDeepRecursionAndEdgeCases() {
        MultiDayEvent outerFest = new MultiDayEvent("FEST", "WinterFest", "2025-12", "Central Grounds", 2);
        Concert day1 = new Concert("D1", "Day 1", "2025-12-01", "Stage", 1, "DJ", "EDM");
        Concert day2 = new Concert("D2", "Finale", "2025-12-02", "Stage", 1, "MC", "Pop");
        outerFest.addSubEvent(day1);
        outerFest.addSubEvent(day2);
        MultiDayEvent nested = new MultiDayEvent("NEST", "Sub", "2025-12-01", "Side", 1);
        day1.addAttendee(new Attendee("Alice", "alice@a.com"));
        outerFest.addSubEvent(nested);
        Concert subConcert = new Concert("S1", "Indie", "2025-12-01", "Side", 1, "Band", "Indie");
        nested.addSubEvent(subConcert);

        assertTrue(outerFest.containsEventRecursive("D1"));
        assertTrue(outerFest.containsEventRecursive("NEST"));
        assertTrue(outerFest.containsEventRecursive("S1"));
        assertFalse(outerFest.containsEventRecursive("NOTFOUND"));
    }

    @Test
    void testNoSubEvents() {
        MultiDayEvent mde = new MultiDayEvent("MID", "Solo", "2025-12", "Solo", 1);
        assertTrue(mde.containsEventRecursive("MID"));
        assertFalse(mde.containsEventRecursive("X"));
    }
}
