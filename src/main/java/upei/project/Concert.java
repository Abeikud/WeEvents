package upei.project;

public class Concert extends Event {
    private final String artist;
    private final String genre;

    public Concert(String id, String name, String date, String venue,
                   int capacity, String artist, String genre) {
        super(id, name, date, venue, capacity);
        this.artist = artist;
        this.genre = genre;
    }

    public String getArtist() {
        return artist;
    }
    public String getGenre() {
        return genre;
    }

    @Override
    public String getType() {
        return "Concert";
    }

    @Override
    public String toString() {
        return "Concert: " + getName()
                + " by " + getArtist()
                + " (" + getGenre() + ") at "
                + getVenue() + " on " + getDate();
    }


    @Override
    public void report() {
        super.report();
        System.out.println("  Artist: " + artist + ", Genre: " + genre);
    }
}

