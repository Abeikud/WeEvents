package upei.project;

public class Ticket {
    private final String ticketId;
    private final Attendee attendee;
    private final Event event;

    public Ticket(String ticketId, Event event, Attendee attendee) {
        this.ticketId = ticketId;
        this.event = event;
        this.attendee = attendee;
    }

    public String getTicketId() { return ticketId; }
    public Event getEvent() { return event; }
    public Attendee getAttendee() { return attendee; }

    @Override
    public String toString() {
        return "Ticket: " + ticketId
                + ", Event: " + event.getName()
                + ", Attendee: " + attendee.getName() + " <" + attendee.getEmail() + ">";
    }

}
