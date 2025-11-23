# 25F CS2910 Programming Project Generative AI Prompt Log

We are building an Event Management System for a school project. Our classes include Event, Concert, Show, SportsGame, and MultiDayEvent, along with Attendee and Ticket. Does it make sense to use Event as an abstract superclass for all event types?

How should we model sub-events within a festival or multi-day event? Is it better to use inheritance, have the class hold a list of sub-events, or use both approaches for supporting sub-events?

Our MyLinkedList implementation sometimes throws IndexOutOfBounds. Can you explain likely causes and suggest a robust way to handle out-of-bounds errors in Java linked lists?

What’s a good way to enforce uniqueness for attendees based on email, both from an OO and data structure perspective?

We wrote a method to promote the first waitlisted person after an attendee is removed. Can you suggest a one-liner or elegant way to update and report who was promoted from the waitlist?

Can you show us the best way to use toString and report methods so the printed output is clean, uncluttered, and grader-friendly?

What are the most valuable edge-case tests when verifying waitlist logic and removing attendees?

We sometimes get output like [Attendee{name='Alex', email='alex@ovosound.com'}]. How can we print only the names and emails for a cleaner output, both in toString and in our report methods?

What’s a recommended structure for JUnit tests that ensures our main class logic, our data structure, and all custom behaviors are well-covered?

How do you recommend searching all sub-events (including multiple nesting levels) for a given event ID? Can you suggest an efficient and readable recursive approach?

How can we improve our diagram for submission, making it match the style of our assignment 

How should we handle attempts to create attendees or events with missing or empty attributes?

Our group is considering how to approach reporting and class diagrams for the written report. Any tips for making our diagrams and documentation clear and professional for graders?

Prompt Used for Project Report:
“For my project I need you to do the following: fill out this report form this is the template...”
(Used to generate our project summary, diagram, reflection, and bonus claims for CS2910 submission.)

  
