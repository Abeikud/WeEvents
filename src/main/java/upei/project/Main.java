package upei.project;

public class Main {
    public static void main(String[] args) {
        EventManagementSystem system = new EventManagementSystem();

        // Create simple events
        Concert concert = new Concert(
                "E1", "06 Vibes", "2025-12-10 20:00",
                "City Arena", 2000, "Jim Lxgacy", "Rock");

        SportsGame game = new SportsGame(
                "E2", "Championship Final", "2025-12-12 19:30",
                "Stadium A", 379000, "Ravens", "Bears", "Football");

        Show comedyShow = new Show(
                "E3", "Laugh Riot", "2025-12-15 21:00",
                "Comedy Club", 180, "Comedy");

        // Multi-day event with nested events
        MultiDayEvent festival = new MultiDayEvent(
                "FEST1", "W Music Festival", "2025-12-20 to 2025-12-22",
                "ScotiaBank Centre", 50000);

        Concert day1Concert = new Concert(
                "F1", "Opening Night", "2025-12-20 18:00",
                "Main Stage", 50000, "Drake", "EDM");
        Concert day2Concert = new Concert(
                "F2", "Headliner Night", "2025-12-21 19:00",
                "Main Stage", 50000, "Future", "Pop");

        festival.addSubEvent(day1Concert);
        festival.addSubEvent(day2Concert);

        // Create attendees
        Attendee alex = new Attendee("Alex", "alex@ovosound.com");
        Attendee bassey = new Attendee("Bassey", "bassey@ovo.com");
        Attendee carrie = new Attendee("Carrie", "carrie@ovo.com");
        Attendee kentrell   = new Attendee("Kentrell", "kentrell@mustard.com");

        system.add(alex);
        system.add(bassey);
        system.add(carrie);
        system.add(kentrell);

        // Add events to system
        system.add(concert);
        system.add(game);
        system.add(comedyShow);
        system.add(festival);

// === TEST: Smaller Size Event with Waitlists ===
        System.out.println("\n=== Testing Small Event with Waitlists ===");
        Show tinyShow = new Show(
                "S1", "Tiny Improv", "2025-12-22 18:00",
                "Mini Studio", 2, "Improv");

        Show openMicNight = new Show(
                "S3",
                "Open Mic Night",
                "2025-12-29 20:00",
                "Small Cafe",
                2,    // very limited capacity
                "Comedy"
        );

        SportsGame pingPongFinal = new SportsGame(
                "E5",
                "Ping Pong Finals",
                "2025-12-30 17:00",
                "Rec Room",
                3,      // small group
                "A team",
                "B team",
                "Ping Pong"
        );

        // Add events to system
        system.add(tinyShow);
        system.add(openMicNight);
        system.add(pingPongFinal);

        // Attempt to register all four attendees; only one should get in, others waitlisted
        tinyShow.addAttendee(alex);
        tinyShow.addAttendee(bassey);
        tinyShow.addAttendee(carrie);
        tinyShow.addAttendee(kentrell);

        openMicNight.addAttendee(alex);
        openMicNight.addAttendee(bassey);
        openMicNight.addAttendee(carrie); // should hit waitlist due to capacity

        pingPongFinal.addAttendee(bassey);
        pingPongFinal.addAttendee(carrie);

        tinyShow.report();
        openMicNight.report();
        pingPongFinal.report();

        // Remove the single admitted attendee to check if the first waitlisted is promoted
        tinyShow.removeAttendee(alex);

        System.out.println("Promoted " + (tinyShow.getAttendees().get(tinyShow.getAttendees().size() - 1).getName()) + " from waitlist.");
        tinyShow.report();

        System.out.println("=== End Small Event Waitlist Test ===\n");

        // Register attendees (fills capacity, sends extra to waitlist)
        concert.addAttendee(alex);
        concert.addAttendee(bassey);
        concert.addAttendee(carrie);

        game.addAttendee(alex);
        game.addAttendee(carrie);
        game.addAttendee(kentrell);

        comedyShow.addAttendee(bassey);
        comedyShow.addAttendee(alex);

        festival.addAttendee(alex);
        festival.addAttendee(bassey);
        festival.addAttendee(carrie);
        festival.addAttendee(kentrell);

        day1Concert.addAttendee(alex);
        day1Concert.addAttendee(bassey);
        day2Concert.addAttendee(carrie);
        day2Concert.addAttendee(kentrell);
        day2Concert.addAttendee(alex);

        // Create tickets
        Ticket t1 = new Ticket("T1", concert, alex);
        Ticket t2 = new Ticket("T2", concert, bassey);
        Ticket t3 = new Ticket("T3", game, kentrell);
        Ticket t4 = new Ticket("T4", festival, carrie);

        system.add(t1);
        system.add(t2);
        system.add(t3);
        system.add(t4);

        //  demo //

        // 1) Global report of everything (events)
        system.reportAll();

        // 2) Report all tickets
        system.reportTickets();

        // 3) Detailed report for a specific event (includes recursion)
        system.reportEventDetails("FEST1");

        // 4) Show that recursive search works for nested event F2
        Event found = system.findEventByIdRecursive("F2");
        System.out.println("Recursive search for 'F2' found: " + found);


    }
}
