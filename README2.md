# 📘 2025F CS2910 Programming Project Specification: Build Your Own Management System

---

**Release Date:** October 6, 2025.

**Due Date:** November 23, 2025, 11:59PM. 


## Overview
In this project, your group will design and implement a **Management System** in Java.  
Your system could manage *any kind of entities you choose* (examples below).  

Every system must implement a **common interface**, but otherwise you have creative freedom.  
The goal is to practice **object-oriented programming**, **linked lists**, **recursion**, and **test-driven development** (TDD) while responsibly using **generative AI** as a coding assistant.  

At the end, each group will give a **5–7 minute presentation** demonstrating your system and reflecting on your process.  

---

## Learning Goals
By completing this project, you will:  
- Apply **object-oriented design principles** (inheritance, abstraction, polymorphism).  
- Implement **custom data structures** (linked list and/or queue).  
- Use **recursion** in a meaningful feature.  
- Practice **test-driven development** (JUnit).  
- Use **generative AI responsibly** to support (not replace) your own work.  
- Work collaboratively to design, implement, and present a system.  

---

## 🔑 Common Interface
All systems must implement this interface:

```java
public interface ManagementSystem<T> {
    void add(T item);
    void remove(T item);
    boolean contains(T item);
    void reportAll();
}
```

- `T` represents the entity your system manages (e.g., Book, Student, Pet).

- Your system must implement this interface.

- You are free to add more methods/classes as needed.

---

## 🧩 Possible System Ideas

You may choose any theme, for example:

- 📚 Library Management System (Books, Patrons, Loans)

- 🏫 Student Course Registration (Students, Courses, Waitlists)

- 🐾 Pet Adoption System (Animals, Adopters, Applications)

- 🚗 Car Rental System (Vehicles, Customers, Reservations)

- 🎵 Music Playlist Manager (Playlists, Songs, Users)

- 🏋️ Gym Membership Manager (Members, Classes, Trainers)

You are also welcome to propose your own idea, subject to instructor approval.

---

## 🏗 Technical Requirements

Every project must include:

- Inheritance: At least one class hierarchy (e.g., Item → Book/DVD, or User → Student/Instructor).

- Custom Linked List: At least one collection (e.g., waitlist, playlist, enrolled courses) must use your own MyLinkedList<T>.

- Recursion: At least one feature must use recursion (e.g., category traversal, prerequisite checking, hierarchical reporting).

- Test-Driven Development: Use JUnit tests to guide your development.

- Interface Implementation: Your system must implement the ManagementSystem<T> interface.

- Reports: Provide at least 2 meaningful reports (e.g., all items for a user, all users for an item, status of a waitlist).

---

## 📐 Sample Class Diagram (Library Example)
            +-------------------+
            |     Item (abs)    |
            +-------------------+
            | - id : String     |
            | - title : String  |
            +-------------------+
            | + getId()         |
            | + getTitle()      |
            +-------------------+
                    ^
                    |
            +-------------------+    +-------------------+
            |       Book        |    |       DVD         |
            +-------------------+    +-------------------+
            | - author : String |    | - director: String|
            +-------------------+    +-------------------+

            +-------------------+
            |      Patron       |
            +-------------------+
            | - id : String     |
            | - name : String   |
            | - items : LL      |
            +-------------------+
            | + borrowItem()    |
            | + returnItem()    |
            +-------------------+

            +----------------------------------+
            |   LibraryManagementSystem        |
            +----------------------------------+
            | - items : LL<Item>               |
            | - patrons : LL<Patron>           |
            +----------------------------------+
            | + add(Item/Patron)               |
            | + remove(Item/Patron)            |
            | + contains(Item/Patron)          |
            | + reportAll()                    |
            +----------------------------------+


**(LL = your custom MyLinkedList<T> implementation)**

---

## 📊 Deliverables

1. Codebase (Java, well-structured).

2. JUnit Test Suite (with meaningful coverage).

3. AI Prompt Log (record key prompts you used + reflections).

4. Presentation (5–7 min):

    - Live demo of your system.

    - Explanation of your OOP design (inheritance, recursion, linked lists).

    - Reflection on your use of AI.

---

## ⏱ Suggested Milestones

- Week 1 (Pick your group): Make your group of 3 people from your lab section.
  
- Weeks 2 (Design): Define your system, sketch class diagram, write initial tests.

- Week 3-5 (Implementation): Build core features and data structures. **Remember to use TDD to test throughout development!**

- Week 6 (Final Testing & Reports): Add recursive feature and reports.

- Week 7 (Polish & Presentation): Finalize tests, documentation, and demo.

---

## ✅ Grading (example weights)

- Correctness & Features – 40%

- OOP Design & Data Structures – 20%

- Test-Driven Development – 15%

- Presentation & Demo – 15%

- AI Prompt Log & Reflection – 10%

----

## Submission
All submission will be done through the Github Classroom.  Your team will accept the project, similar to how you have
accepted lab assignments.  You will commit your code, and all code in the repository at the submission date will be
marked. 

As a note, it is expected that students will be regularly be committing code to the Github repository.  Late submissions
due to technical issues will not normally be accepted. 

## Team Dynamics
For those working in a pair, it is expected that each individual will contribute in meaningful and substantive ways to
the project.  If a complaint is raised by one or both of the members of a working pair, or during final marking, the 
instructor will examine  the Github logs as evidence regarding contribution. This does not mean that each team member must have the same number of commits, but both members should be pushing code to the repository.  At the discretion of the instructor, under performing members will have deductions associated with their contribution, up to and including 0 for the project for a complete absence of 
meaningful and substantive contributions.  

If there are serious problems arise in multiple groups, the instructor may introduce a short survey halfway through 
the project period regarding relative contributions.  If this occurs, it will be announced through Moodle.

## Academic Misconduct

### Academic Integrity Statement

In your project package for this project you will include a text file in the project folder, at the same
folder level as _src_ named **INTEGRITY.md**. 

**Please read this file carefully and update it to have your names and student numbers.  Students who
do not complete this statement will have a deduction of 10% from the project mark**.

### Academic Integrity and Generative AI
It is clear from this project description that you are permitted to use generative AI as part of your toolset.  However,
this does not mean that the rest of UPEI Academic Regulation 20 is not applicable to this assignment.  It is expected that
you will abide by the rules regarding plagiarism, misrepresentation, solicitation and fabrication of results, as well as any
other forms of academic misconduct.

As a caution, groups working on the same Management System (which will likely happen) will naturally have variation in how they are implemented.
It is highly improbable that two groups would have near identical implementations with the number of choices in this project. Further,
it is highly improbable that two groups would have near identical implementations just because they used the same generative AI
tools.  Such a claim would not be accepted in an academic misconduct investigation.  A reminder that as per the syllabus, a team 
that has academic misconduct upheld will lose receive 0, losing 15% of the final mark, and an additional 15% from their final mark.
Individuals with previous academic misconduct allegations upheld will further have a maximum mark of 50% possible in
the course.


#### ⚖️ Responsible AI Use

You may use generative AI for most parts of the project, in particular, to help brainstorm, debug, or draft code.
However:

- Keep a log of key prompts you used.

- Comment any AI-generated code that you adapted.

- Reflect on what you changed or improved.

The goal is to learn how to work with AI responsibly, while keeping ownership of your code and design.
