# 2025F CS2910 Project Report
**Group Members**
1. Adekanola Opololaoluwa (0357547)
2. Kevin Davies (0354848)
3. Daniel Dampson(0363404)

## Summary of Management System
Our project is an Event Management System designed to manage a variety of event types (Concerts, Shows, SportsGames) and participants (Attendees, Tickets), supporting core operations like registration, waitlisting, and capacity management. At its heart is a custom singly-linked list (MyLinkedList<T>), giving us fine control over data storage.

Key classes include:

Event (abstract): The base for all event types, tracks core info (id, name, date, venue, capacity, attendees, waitlist).

Concert, Show, SportsGame: Specialized event types with extra fields (artist/genre for Concert, teams for SportsGame, type for Show).

MultiDayEvent: Allows hierarchical sub-events, supporting complex festival structures and recursive search.

Attendee: Registered participant, identified uniquely by email for system-wide consistency.

Ticket: Ties an attendee to an event.

EventManagementSystem: Manages global collections of events, tickets, and attendees, supporting add/remove/query/report.

MyLinkedList<T>: Custom linked list, supporting all event/attendee storage needs.

Plain English: Our system lets you create a variety of events, add people as attendees, automatically handle waitlisting and promotion, issue tickets, and report on the entire system or any item in detail. Sub-events and custom printing make for clear and scalable management.


## Class Diagram
A visual depiction of the class structure in our design.

            +-------------------+
            |    Attendee       |
            +-------------------+
            | - name: String    |
            | - email: String   |
            +-------------------+
            | + getName()       |
            | + getEmail()      |
            +-------------------+

            +-------------------+
            |   Event (abs)     |
            +-------------------+
            | - id: String      |
            | - name: String    |
            | - date: String    |
            | - venue: String   |
            | - capacity: int   |
            | - attendees: LL   |
            | - waitlist: LL    |
            +-------------------+
            | + getId()         |
            | + getName()       |
            | + getDate()       |
            | + getVenue()      |
            | + getCapacity()   |
            | + addAttendee()   |
            | + removeAttendee()|
            | + isAttending()   |
            | + isWaitlisted()  |
            | + report()        |
            +-------------------+
                  /   |   |   \
                 /    |   |    \
     +-----------+   +-------------+   +-------------------+   +---------------------+
     |  Concert  |   |    Show     |   |   SportsGame      |   |   MultiDayEvent     |
     +-----------+   +-------------+   +-------------------+   +---------------------+
     | - artist  |   | - showType  |   | - homeTeam: String|   | - subEvents: LL     |
     | - genre   |   +-------------+   | - awayTeam: String|   +---------------------+
     +-----------+                    | - sport: String   |
                                      +-------------------+

            +-------------------+
            |     Ticket        |
            +-------------------+
            | - ticketId: String|
            | - attendee: Attendee|
            | - event: Event    |
            +-------------------+

            +----------------------------------+
            | EventManagementSystem            |
            +----------------------------------+
            | - events: LL<Event>              |
            | - tickets: LL<Ticket>            |
            | - attendees: LL<Attendee>        |
            +----------------------------------+
            | +add(Event/Ticket/Attendee)      |
            | +remove(Event/Ticket/Attendee)   |
            | +contains(Event/Ticket/Attendee) |
            | +reportAll()                     |
            | +findEventByIdRecursive()        |
            +----------------------------------+

            
---

## Design Decisions

e leveraged abstract classes and inheritance to avoid code duplication, allowing each specialized event type to extend Event with minimal code. Custom linked lists provide precise control, and we opted for email as a unique identifier for Attendees—this simplifies search and guarantees uniqueness system-wide.

Recursive methods were used for searching and reporting on nested events. Logic for auto-promoting waitlisted attendees after removals is encapsulated in removeAttendee.

Design prioritizes clarity and scalability: by using generics and abstraction, the system can handle thousands of objects without structural changes. Storing data in raw linked lists is efficient for small-to-mid datasets, but could be swapped for hash-based structures for future scalability (e.g., to O(1) lookups for attendees/events).

Testing included all "edge cases" (empty lists, removals, boundary promotion), ensuring robust logic before demo integration in Main.

# Reflection
### Which generative AIs did you use, and what tasks did you use it for?
We used ChatGPT as our main generative AI for:

Advice on best-practice OO design and class relationships.

Reviewing complex recursive methods and suggesting edge-case test cases.

Polishing print/report output and toString() methods for clarity.

Guidance on robust, readable JUnit tests and exception handling.


### Reflecting on your experience:
_Write a short reflection on your use of generative AI in this project, including if you did not use it.

**Reflecting on our experience:**
- What went well using generative AI in this project?
AI was invaluable for brainstorming and reviewing edge cases, especially when we were unsure about inheritance nuances or best ways to recursively print/validate nested events. The quick feedback loop on Java syntax and test design saved us time.

- What didn’t go well using generative AI?
AI sometimes returned overly broad or generic advice, so we had to filter and adapt suggestions to our specific constraints and project rules. We also got occasionally redundant code samples, but this highlighted potential issues for us (e.g., double-checking handling of attendee uniqueness).

- Were there any limitations you encountered using generative AI?
Our team had to ensure final implementations actually fit our assignment specs—we used AI for "second opinions," not to substitute for reading requirements or thinking through system rules.

- How did your solution change/evolve/improve/degrade because of the generative AI?
AI helped us catch potential issues earlier in the process (null cases, improper equals/hashCode, etc.), meaning fewer rewrites. It also inspired us to make our reporting output more readable.

- What could you have done so the project turned out better?
If we’d explored generative tools earlier, we might have mapped out a more optimal test plan sooner. We learned it is still critical to deeply understand assignment requirements, as AI is complementary but not a substitute for specification-based work.

# Bonus Consideration:
Advanced Recursion and Data Structure Use:
Our system enables fully recursive search and report functions, making it possible to manage, trace, and display deeply nested event structures (e.g., multi-day festivals with unlimited sub-events). This supports real-world scalability in organizational contexts beyond simple events.
