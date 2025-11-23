package upei.project;

public class SportsGame extends Event {
    private final String homeTeam;
    private final String awayTeam;
    private final String sport;

    public SportsGame(String id, String name, String date, String venue,
                      int capacity, String homeTeam, String awayTeam, String sport) {
        super(id, name, date, venue, capacity);
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.sport = sport;
    }

    public String getHomeTeam() {
        return homeTeam;
    }
    public String getAwayTeam() {
        return awayTeam;
    }
    public String getSport() {
        return sport;
    }

    @Override
    public String getType() {
        return "SportsGame";
    }

    @Override
    public void report() {
        super.report();
        System.out.println("  Match: " + homeTeam + " vs " + awayTeam +
                " (" + sport + ")");
    }
}
