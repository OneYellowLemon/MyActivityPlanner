# My Activity Planner

IT4045C Enterprise Application Development

## Introduction

<!-- Introduction paragraph. Jacob will create this -->

## Storyboard

<!-- Screen mockups of application. -->

## Functional Requirements

### 1. As a user, I can view a list of all upcoming activities today

**Given**: The application is not open

**When**: The application is loaded to the default page

**Then**: All available activities for today are shown in chronological order

---

**Given**: A date other than today is currently selected

**When**: The user clicks on Today

**Then**: All available activities for today are shown in chronological order

---

### 2. As a user, I can switch the selected day to a different day to view a list of all upcoming activities on that day

**Given**: A date is selected

**When**: The user clicks on a different date

**Then**: All available activities for that day are shown in chronological order

---

### 3. As a user, I can see a list of activities I have signed up for on "My Activity List"

**Given**: The application is loaded to the default page

**When**: The user clicks "My Activity List"

**Then**: A list of activities the user has signed up for is visible with entries containing activity name, date, and time

---

**Given**: The user is looking at their activity list

**When**: The user clicks on a specific activity

**Then**: Details about that activity are displayed, including activity name, date, time, location, and brief description

---

### 4. As a user, I can view details about a specific activity

**Given**: A list of activities is shown for the selected day

**When**: The user clicks on a specific activity

**Then**: Details about that activity are displayed, including activity name, date, time, location, and brief description

---

### 5. As a user, I can add an activity to My Activity List

**Given**: A specific activity is currently being viewed that is not already part of the user's "My Activity List"

**When**: The user clicks "Add to My Activities"

**Then**: The activity is added to the user's list of activities

---

**Given**: A user is adding an activity to their activity list and has clicked "Add to My Activities"

**When**: The activity has successfully been added

**Then**: A success confirmation is displayed to the user with the message `<activity name> at <date and time> has been added to your activities.`

---

**Given**: A specific activity is currently being viewed that is not already part of the user's "My Activity List" and occurs at the same time as another activity on the user's "My Activity List"

**When**: The user clicks "Add to My Activities"

**Then**: A failure message is displayed to the user with the message `You already have an activity at this time!` and the activity is not added to the user's activity list

---

### 6. As a user, I can remove an activity from My Activity List

**Given**: A specific activity is currently being viewed that is already part of the user's "My Activity List"

**When**: The user clicks "Remove from My Activities"

**Then**: The activity is removed from the user's list of activities

---

**Given**: A user is removing an activity from their activity list and has clicked "Remove from My Activities"

**When**: The activity has successfully been removed

**Then**: A success confirmation is displayed to the user with the message `<activity name> at <date and time> has been removed from your activities.`

---

### 7. As an admin, I can create new activities

**Given**: The admin page is open and the user has entered data in fields: name, date and time, location, and description

**When**: The user clicks "Add Activity"

**Then**: The activity is created and a success confirmation is displayed with the message `<activity name> at <date and time> has been created.` and the input fields are cleared

---

**Given**: The admin page is open and the user has entered data in the name, location, or description fields with more than 20 characters in the name field, 50 characters in the location field, or 500 characters in the description field

**When**: The user clicks "Add Activity"

**Then**: An error message is returned indicating which maximum character length was violated (20 for name, 50 for location, 500 for description)

---

**Given**: The admin page is open and the user has entered data in date and time fields with the selected date and time in the past

**When**: The user clicks "Add Activity"

**Then**: An error message is returned indicating the activity could not be created in the past

---

### 8. As an admin, I can modify existing activities

**Given**: The admin page is open

**When**: The user clicks the edit button on an existing activity

**Then**: The existing name, date and time, and description of the activity are loaded into the edit fields

---

**Given**: The admin page is open and the user is editing an activity

**When**: The user clicks "Save Activity"

**Then**: The activity is updated and a success confirmation is displayed with the message `The activity has been updated.` Additionally, the input fields are cleared and the button reverts back to a "Add Activity" button

---

### 9. As an admin, I can delete activities

**Given**: The admin page is open

**When**: The user clicks the delete button on an existing activity

**Then**: The activity is deleted and a success confirmation is displayed with the message `<activity name> at <date and time> has been deleted.`

## Class Diagram

<!-- Insert image of UML-based class diagram here -->

### Class Diagram Description

<!-- Class Diagram Description: One or two lines for each class to describe use of interfaces, classes and resources, interfaces, etc. Don't worry about putting more than a few words to each class; this does not need to be thorough. -->

## JSON Schema

<!--  Your project should have an REST endpoint that emits JSON, which another group can consume.  The design document should contain a draft JSON schema for this endpoint.
You can create a schema from a Java class at QuickType.io.  This Java class is typically a DTO.  That's all you need at this point. -->

<!-- Jacob thoughts: we can export events on "My Activity List" -->

## Scrum roles

**UI Specialists**:

**Business Logic/Persistence Specialists**:

**Product Owner/Scrum Master/DevOps Specialist**: Jacob G

## Project Link

https://github.com/OneYellowLemon/IT4045C

## Milestones

<!-- Links to milestones once created -->

## Standup Meeting

<!-- Link to standup meeting once created -->
