# 📘 2025F CS2910 Programming Project Specification: Build Your Own Management System

---

**Release Date:** October 10, 2025.

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

- `T` represents an entity your system manages (e.g., Book, Student, Pet). You should have an overloaded copy of each of the first three methods for each of the entities that can be added to your system.

- Your system must implement this interface.

- You are free (and strongly encouraged) to add more methods/classes as needed.

- `reportAll` should display (either printing to standard input or by other means) a report of everything contained inside the system at a given point in time.

---

## 🧩 Possible System Ideas

You may choose any theme **except** for Library or Flight Management Systems as we did examples with both of these in class.
We encourage you to be creative and chose something you and your group members are interested in. Some examples might include:

- 🏫 Student Course Registration (Students, Courses, Waitlists)

- 🐾 Pet Adoption System (Animals, Adopters, Applications)

- 🚗 Car Rental System (Vehicles, Customers, Reservations)

- 🎵 Music Playlist Manager (Playlists, Songs, Users)

- 🏋️ Gym Membership Manager (Members, Classes, Trainers)

**Please ensure you have read the Technical Requirements section before deciding on a system.** 
For example, some systems may be too simple for any meaningful inheritance or interface implementations.  

---

## 🏗 Technical Requirements

Every project must include:

- Inheritance: At least one class hierarchy (e.g., Item → Book/DVD, or User → Student/Instructor).

- Custom Linked List: At least one collection (e.g., waitlist, playlist, enrolled courses) must use your own MyLinkedList<T>.

- Recursion: At least one feature must use recursion (e.g., category traversal, prerequisite checking, hierarchical reporting).

- Test-Driven Development: Use JUnit tests to guide your development.

- Interface Implementation: Your system must implement the ManagementSystem<T> interface.

- Demo: To showcase all of the features of your Management System, you should add a robust example in Main.java that creates an instance of your Management system class and adds many entities to it (creating and adding the entities may be a good task to hand to generative AI). This demo must include a call to `reportAll`, but should also include at least 2 other meaningful reports. For the Library Management System example, a report for a given Book might prints its title, author, id, status, borrowing history, and the list of all Patrons that have an active hold placed on it (if applicable). A report for a given Patron might include their Library card number, all currently borrowed books and holds, as all as indicating if any are overdue, and a list of all books previously borrowed.

---


## 👩🏻‍🏫🙋🏽Presentation

As mentioned above, your group is expected to give a short 5-7 minute presentation. It is best if everyone in your group has a chance to say something during the presentation, but not necessary. It is necessary for all of your group members to be present though so that any questions can be handled by the entire group.

Your presentation should provide the following (not necessarily in this order):

1. A demo of your management system in action.
2. A brief explanation of your design choices.
3. How generative AI was used.
4. A minute or two at the end for questions from your classmates and professors. 

This presentation is _not_ intended to be stressful, but a good opportunity to take ownership of your work and share your project that you've been working on for several weeks.
Listening to other presentations will also be a great opportunity to learn from other design decisions groups that made different design decisions.

Further, practice with presentations is the best way to get better! 
Very few people are naturally comfortable speaking in front of groups without lots of practice (including your instructors!). 


## 📊 Deliverables

1. Codebase (Java, well-structured).

2. JUnit Test Suite (with meaningful coverage).

3. AI Prompt Log (see PROMPT_LOG.md for a very basic template). We strongly recommend you add to this as you go instead of trying to compile this at the end. 

4. Presentation (5–7 min + questions).
      
5. Report (see REPORT.md for your template)

---

## ⏱ Suggested Milestones

- Week 1 (Pick your group): Make your group of 3 people from your lab section.
  
- Week 2 (Design): Decide on a system, define your system, sketch your initial class diagram, write initial tests.
  (Note: you may find your initial choice is not robust enough to make an interesting class diagram, so you will want to complete the entire design phase before completely settling on a system)

- Week 3-4 (Implementation): Build core features and data structures. **Remember to use TDD to test throughout development!**

- Week 5 (Final Testing & Report): Add recursive feature and report.

- Week 6 (Polish & Presentation): Finalize tests, documentation, polish `report` method formats, and demo.

---

## ✅ Grading 

The following is the rubric of where marks will be awarded in this project.

- **Code Design (5 marks):** Average projects will produce an implementation that accurately 
represents the management system chosen by the group using principles of cohesion to have meaningful representation of objects, reduce 
coupling between classes to ensure future extension, and will be fully encapsulated for future compatibility and evolution. Excellent solutions 
will have exceptional quality in the above and/or use advanced features in Java such as abstract 
classes or interfaces appropriately. It is strongly recommended you document design choices (i.e., why your code is what it is, not just what it is) in your class/method header Javadoc 
documentation.
- **Testing (3 marks):** Average TDD will have tests for the majority of classes and coverage of most branches.  Excellent
  solutions will have very high branch coverage, all edge cases covered, and robust input handling.
- **Code Documentation (2 marks):** Average classes will be self-documenting code with well-formed with Javadoc comments for the
majority of methods and good block level comments.  Excellent documentation will do all of the above throughout all
of their project.
- **Presentation (3 marks):** See the Presentation section for a description of what goes into this part of the project.
- **Reflection (2 marks):** Average reflections will engage with the provided prompts to have descriptions and reasoning 
regarding their application of AI.  Excellent reflections will take into account context in which events occur, 
questions assumption that were made at the time, describes alternatives, thinks about consequences of decisions/actions 
on others, and engages in reflective skepticism.

## Potential Bonus - 5% of Course Final Mark
There are a potential bonus that may be awarded at the discretion of the marker/instructor.  Up to 5% could be
added to your final mark to a maximum of 100% in the course.  Examples of where this may be awarded
is as follows:
- Complex class structure due to choosing a very complex management system which is good or excellent in its design. 
- Advanced use of Java features such as functional interfaces, abstract classes above or beyond what might
be expected at the second year level.
- Advanced use of data structures and algorithms in any multiple parts of the system.
- Advanced use of Exceptions to manage different aspects of the code beyond the second year level.

If you have one of the above components, or another aspect you would like considered, please provide a description and
why you think it should be considered in the appropriate section of your report.  It is recommended that you complete the 
requirements of the project and commit a completed project before trying to add bonus material.

----

## Submission
All submission will be done through the Github Classroom.  Your team will accept the project, similar to how you have
accepted lab assignments.  You will commit your code, and all code in the repository at the submission date will be
marked. 

As a note, it is expected that students will be regularly be committing code to the Github repository.  Late submissions
due to technical issues will not normally be accepted. 

## Team Dynamics
It is expected that each individual will contribute in meaningful and substantive ways to the project.  
If a complaint is raised by one or more members of a group, or during final marking, the 
instructor will examine the Github logs as evidence regarding contribution. This does not mean that each team member must have the same number of commits, but both all members should be pushing code to the repository.  At the discretion of the instructor, under performing members may have deductions associated with their contribution, up to and including 0 for the project for a complete absence of 
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
