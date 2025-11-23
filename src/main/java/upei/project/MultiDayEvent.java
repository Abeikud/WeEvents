package upei.project;

public class MultiDayEvent extends Event {

    private final MyLinkedList<Event> subEvents = new MyLinkedList<>();

    public MultiDayEvent(String id, String name, String dateRange, String venue,
                         int capacity) {
        super(id, name, dateRange, venue, capacity);
    }

    @Override
    public String getType() {
        return "MultiDayEvent";
    }

    public void addSubEvent(Event e) {
        subEvents.add(e);
    }

    public boolean removeSubEvent(Event e) {
        return subEvents.remove(e);
    }

    public MyLinkedList<Event> getSubEvents() {
        return subEvents;
    }

    // Recursive search through nested structure
    @Override
    public boolean containsEventRecursive(String eventId) {
        if (super.containsEventRecursive(eventId)) {
            return true;
        }
        final boolean[] found = {false};
        subEvents.forEach(e -> {
            if (!found[0] && e.containsEventRecursive(eventId)) {
                found[0] = true;
            }
        });
        return found[0];
    }

    @Override
    public void report() {
        super.report();
        System.out.println("  Sub-events:");
        subEvents.forEach(e -> {
            System.out.println("    -> " + e);
        });
    }

    // Recursive detailed report
    public void reportRecursive() {
        report();
        subEvents.forEach(e -> {
            if (e instanceof MultiDayEvent) {
                ((MultiDayEvent) e).reportRecursive();
            } else {
                e.report();
            }
        });
    }
}
