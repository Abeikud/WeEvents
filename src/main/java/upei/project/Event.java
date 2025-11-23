package upei.project;

public abstract class Event {
    protected final String id;
    private final String name;
    private final String date;   // simple String for date/time
    private final String venue;
    protected int capacity;

    private final MyLinkedList<Attendee> attendees = new MyLinkedList<>();
    private final MyLinkedList<Attendee> waitlist  = new MyLinkedList<>();

    protected Event(String id, String name, String date, String venue, int capacity) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.venue = venue;
        this.capacity = capacity;
    }

    public String getId() {
        return id;
    }
    public String getName(){
        return name;
    }
    public String getDate(){
        return date;
    }
    public String getVenue(){
        return venue;
    }
    public int getCapacity(){
        return capacity;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public boolean addAttendee(Attendee attendee) {
        // Prevent adding the same attendee twice either in guestList or waitlist
        if (attendees.contains(attendee) || waitlist.contains(attendee)) {
            return false;
        }
        // Check if there is capacity to add the attendee to the main list
        if (attendees.size() < capacity) {
            attendees.add(attendee);
            return true;
        } else {
            waitlist.add(attendee);
            return false;
        }
    }

    public boolean removeAttendee(Attendee attendee) {
        // Attempt to remove from main list
        if (attendees.remove(attendee)) {
            // Promote first waitlisted attendee if waitlist is not empty
            if (!waitlist.isEmpty()) {
                Attendee toPromote = waitlist.get(0); // get the first Attendee in the waitlist
                waitlist.remove(toPromote);           // remove by value (object), not by index
                attendees.add(toPromote); // add to main list
            }
            return true;
        }
        // If not in main list, try to remove from waitlist
        return waitlist.remove(attendee);
    }

    public boolean isAttending(Attendee attendee) {
        return attendees.contains(attendee);
    }

    public boolean isWaitlisted(Attendee attendee) {
        return waitlist.contains(attendee);
    }

    public MyLinkedList<Attendee> getAttendees() {
        return attendees;
    }

    public MyLinkedList<Attendee> getWaitlist() {
        return waitlist;
    }

    public abstract String getType();

    @Override
    public String toString() {
        return getType() + ": " + name + " at " + venue + " (" + date + ")";
    }

    public void report() {
        System.out.println("Event[" + getType() + "] id=" + id + ", name=" + name +
                ", date=" + date + ", venue=" + venue + ", capacity=" + capacity);
        System.out.println("  Attendees (" + attendees.size() + "): " + attendees);
        System.out.println("  Waitlist (" + waitlist.size() + "): " + waitlist);
    }

    public boolean containsEventRecursive(String eventId) {
        return this.id.equals(eventId);
    }

    public static Event findEventNode(Event event, String id) {
        if (event.getId().equals(id)) {
            return event;
        }
        // Recursively search sub-events if present
        if (event instanceof MultiDayEvent) {
            MultiDayEvent multi = (MultiDayEvent) event;
            for (Event sub : multi.getSubEvents()) {
                Event found = findEventNode(sub, id);
                if (found != null) {
                    return found;
                }
            }
        }
        return null;
    }
}
