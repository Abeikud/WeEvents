package upei.project;

public class Show extends Event {
    private final String showType;  // e.g., "Comedy", "Theatre"

    public Show(String id, String name, String date, String venue,
                int capacity, String showType) {
        super(id, name, date, venue, capacity);
        this.showType = showType;
    }

    public String getShowType() {
        return showType;
    }

    @Override
    public String getType() {
        return "Show";
    }

    @Override
    public void report() {
        super.report();
        System.out.println("  Show type: " + showType);
    }
}
