# project-manager
This was Capstone Project 1 for level 2 of the HyperionDev Software Engineering Bootcamp.

This project is based on object oriented programming (OOP). A structural engineering firm needs a program to keep track of the many projects they work on.
Below are the specifications given by the client:

The program stores the following information for each project that they work on:
* Project number.
* Project name.
* What type of building is being designed? E.g. House, apartment block or
store, etc.
* The physical address for the project.
* ERF number.
* The total fee being charged for the project.
* The total amount paid to date.
* Deadline for the project.
* The name, telephone number, email address and physical address of the
architect for the project.
* The name, telephone number, email address and physical address of the
contractor for the project.
* The name, telephone number, email address and physical address of the
customer for the project.

The program must be able to do the following:
* Capture information about new projects. If a project name is not provided
when the information is captured, name the project using the surname of
the customer. For example, a house being built by Mike Tyson would be
called “House Tyson.” An apartment block owned by Jared Goldman would
be called “Apartment Goldman.”
* Update information about existing projects. Information may need to be
adjusted at different stages throughout the lifecycle of a project. For
example, the deadline might change after a meeting with various
stakeholders.
* Finalise existing projects. When a project is finalised, the following should
happen:
** An invoice should be generated for the client. This invoice should
contain the customer’s contact details and the total amount that the
customer must still pay. This amount is calculated by subtracting the
total amount paid to date from the total fee for the project. If the
customer has already paid the full fee, an invoice should not be
generated.
** The project should be marked as “finalised” and the completion date
should be added. All the information about the project should be
added to a text file called CompletedProject.txt.
* See a list of projects that still need to be completed.
* See a list of projects that are past the due date.
* Find and select a project by entering either the project number or project
name.

### Please note

Only part of the project requirements have been met. This is an ongoing solo project.

The requirements that have been met so far are as follows:
* Create a class that will be used to create a project object.
* Create a class that will be used to create person objects.
* Capture the details that are used to create a new project
object.
* Change the due date of the project.
* Change the total amount of the fee paid to date.
* Update a contractor’s contact details.
* Finalise the project.
