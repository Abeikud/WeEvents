package upei.project;

import java.util.ArrayList;
import java.util.List;

public class EventManagementSystem implements ManagementSystem<Event> {
    private final MyLinkedList<Event> events = new MyLinkedList<>();
    private final MyLinkedList<Ticket> tickets = new MyLinkedList<>();
    private final MyLinkedList<Attendee> attendees = new MyLinkedList<>();

    @Override
    public void add(Event item) {
        events.add(item);
    }

    @Override
    public void remove(Event item) {
        events.remove(item);
    }

    @Override
    public boolean contains(Event item) {
        return events.contains(item);
    }

    @Override public void reportAll(){
        System.out.println("--- All Events Report ---");
        events.forEach(Event::report);
        System.out.println("--- End Report ---");
    }

    // ---- Overloaded methods for Tickets ----
    public void add(Ticket ticket) {
        tickets.add(ticket);
    }

    public void remove(Ticket ticket) {
        tickets.remove(ticket);
    }

    public boolean contains(Ticket ticket) {
        return tickets.contains(ticket);
    }

    // ---- Overloaded methods for Attendees ----
    public void add(Attendee attendee) {
        if (!attendees.contains(attendee))
            attendees.add(attendee);
    }

    public void remove(Attendee attendee) {
        attendees.remove(attendee);
    }

    public boolean contains(Attendee attendee) {
        return attendees.contains(attendee);
    }

    public void reportTickets() {
        System.out.println("--- All Tickets Report ---");
        tickets.forEach(System.out::println);
        System.out.println("--- End Tickets Report ---");
    }

    public void reportEventDetails(String id) {
        Event event = findEventByIdRecursive(id);
        if (event != null) {
            System.out.println("--- Details for Event ID: " + id + " ---");
            event.report();
            System.out.println("--- End Details ---");
        } else {
            System.out.println("Event with ID " + id + " not found.");
        }
    }


    public Event findEventByIdRecursive(String id) {
        final Event[] result = {null};
        events.forEach(e -> {
            if (result[0] == null && e.containsEventRecursive(id)) {
                result[0] = findEventNode(e, id);
            }
        });
        return result[0];
    }

    public static Event findEventNode(Event event, String id) {
        if (event.getId().equals(id)) {
            return event;
        }
        // Only search sub-events if it's a MultiDayEvent
        if (event instanceof MultiDayEvent) {
            MultiDayEvent multiDay = (MultiDayEvent) event;
            for (Event subEvent : multiDay.getSubEvents()) {
                Event found = findEventNode(subEvent, id);
                if (found != null) {
                    return found;
                }
            }
        }
        return null;
    }
}
