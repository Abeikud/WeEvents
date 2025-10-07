# 2025F CS2910 Project Report
**Group Members**
1. Person 1 (Student Number)
2. Person 2 (Student Number)
3. Person 3 (Student Number)

## Summary of Management System
_A summary description of the systen that you chose including plain language descriptions of each class.  (250 words max)_

## Class Diagram
_A vizualtion depiction of the class structure in your design.  Feel free to modify and add to the sample class diagram below for a Library Management system._

### Sample Class Diagram (Library Example)
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



## Design Decisions

_Explain the design decisions made, especially any use of interfaces or inheritance. 
You should also explain your choices of data structures and algorithms.
Something to consider as well is how your system will scale as the number of objects gets very lage. (500 words max)_




# Reflection
_A reflection on your experiences with generative AI during this project. Provide a few sentences reflecting
on your experience with AI for each of the following prompts._ 

### Which generative AIs did you use, and what tasks did you use it for?
_**Example:** Git Co-Pilot: generated getters and setters_

### How did you learn about the tools used by your group (delete ones that don't apply)?
_Please describe where and how you learned about the tools_

### Reflecting on your experience:
_Write a short reflection on your use of generative AI in this project, including if you did not use it. 
You may use the prompts as headings if you wish. (500 words max)_  

**Prompts to think about in writing your reflections if you worked with generative AI:**
- What went well using generative AI in this project?
- What went well using generative AI?
- What didn’t go well using generative AI?
- Were there any limitations you encountered using generative AI?
- How did your solution change/evolve/improve/degrade because of the generative AI?
- What could you have done so the project turned out better?

**Prompts to think about in writing your reflections if you didn't use generative AI:**
- Why did you choose not to use generative AI in this project?
- Were there particular problems that you encountered where you think generative AI would have helped?
- Were there particular things you were glad you learned to do yourself without the use of generative AI?
- What could you have done so the project would turn out better?

# Bonus Consideration:
If you have aspects of your project you would like considered for the available bonus.
