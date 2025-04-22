# My Activity Planner

IT4045C Enterprise Application Development

## Introduction

My Activity Planner is an application for individuals living in assisted living that allows them to see a list of activities for a given day and sign up for them.
An administration page allows management of the activities, including creating new activities, editing existing activities, and deleting activities.
Users of the app can view activities day by day with details including the activity name, date, location, and description. Users can sign up for activities, view the activities they have signed up for, and withdraw from activities.

## Storyboard

[Storyboard](storyboard.pdf)

## Functional Requirements

### 1. As a user, I can "log in" as a specific user ID so that I can manage my activity list

**Given**: The application is not open

**When**: The application is loaded to the default page

**Then**: The user is prompted to enter a user ID

---

### 2. As a user of the application, I can act as a specific user ID so that I can have a separate activity list from other users

**Given**: The application is open to the default page

**When**: The user enters their user ID

**Then**: The user of the application performs tasks as that user ID

---

### 3. As a user of the application, I can only act as a valid user ID so that I do not lose my data

**Given**: The application is open to the default page

**When**: The user enters an invalid user ID

**Then**: An error message is shown stating the requested user does not exist

---

### 4. As a user, I can view a list of all upcoming activities today so that I can see what is happening

**Given**: The user has authenticated

**When**: The application is loaded to the default page

**Then**: All available activities for today are shown

---

**Given**: The user has authenticated, and a date other than today is currently selected

**When**: The user clicks on Today

**Then**: All available activities for today are shown

---

### 5. As a user, I can switch the selected day to a different day so that I can view a list of all upcoming activities on that day

**Given**: The user has authenticated, and a date is selected

**When**: The user clicks on a different date

**Then**: All available activities for that day are shown

---

### 6. As a user, I can see a list of activities I have signed up for on "My Activity List" so that I can know what I am supposed to be doing

**Given**: The user has authenticated, and the application is loaded to the default page

**When**: The user clicks "My Activity List"

**Then**: A list of activities the user has signed up for is visible with entries containing activity name and date

---

### 7. As a user, I can view details about a specific activity so that I can be informed about what I can sign up for

**Given**: A list of activities is shown for the selected day

**When**: The user clicks on a specific activity

**Then**: Details about that activity are displayed, including activity name, date, location, and brief description.

---

### 8. As a user, I can add an activity to My Activity List so that I can attend them

**Given**: The user has authenticated, and a specific activity is currently being viewed that is not already part of the user's "My Activity List"

**When**: The user clicks "Sign Up"

**Then**: The activity is added to the user's list of activities

---

### 9. As a user, I can remove an activity from My Activity List so that I can withdraw my interest in an activity I had previously signed up for

**Given**: The user has authenticated, and a specific activity is currently being viewed that is already part of the user's "My Activity List"

**When**: The user clicks "Withdraw"

**Then**: The activity is removed from the user's list of activities

---

### 10. As an admin, I can create new activities so that I can make them available to users

**Given**: The admin page is open and the user has entered data in fields: name, date, location, and description

**When**: The user clicks "Create Activity"

**Then**: The activity is created and the input fields are cleared

---

**Given**: The admin page is open and the user has entered data in date field with the selected date in the past

**When**: The user clicks "Create Activity"

**Then**: An error message is returned indicating the activity could not be created in the past

---

### 11. As an admin, I can modify existing activities so that I can make corrections

**Given**: The admin page is open

**When**: The user clicks the edit button on an existing activity

**Then**: The existing name, date, location, and description of the activity are loaded into the edit fields

---

**Given**: The admin page is open and the user is editing an activity

**When**: The user clicks "Save Activity"

**Then**: The activity is updated, the input fields are cleared, and the "Save Activity" button reverts back to a "Create Activity" button

---

### 12. As an admin, I can delete activities so that I can cancel activities

**Given**: The admin page is open

**When**: The user clicks the delete button on an existing activity

**Then**: The activity is deleted.

---

### 13. As an admin, I can create new users so that I can allow users to be able to log in

**Given**: The admin page is open and the user has entered data in fields: first name, last name

**When**: The user clicks "Add User"

**Then**: The user is created and the input fields are cleared

## Class Diagram

![Class diagram for My Activity Planner](ClassDiagram.png)

[View it on LucidChart](https://lucid.app/lucidchart/182d23de-7ba1-4009-b43e-6455d03dbf5d/edit?invitationId=inv_3bcc0d16-4830-4a5c-ab85-9cdeda8fb1b8)

### Class Diagram Descriptions

#### Classes:

```
com.myactivityplanner.enterprise:
- EnterpriseApplication: Start up application server
- ActivityController: Endpoints for working with activities
- UserController: Endpoints for working with users
- PagesController: Handle UI pages

com.myactivityplanner.enterprise.dto:
- User: Store user information
- Activity: Store activity information
- UserActivity: Store User -> Activity mappings

com.myactivityplanner.enterprise.service:
- ActivityServiceStub: Stub class for activity service
- ActivityService: Handle business logic for activities
- UserServiceStub: Stub class for user service
- UserService: Handle business logic for users

com.myactivityplanner.enterprise.dao:
- UserActivityDAO: Handle persistence for mapping users to activities
- UserActivityDAOStub: Stub class for persisting the mappings between users and activities
- ActivityDAO: Handle persistence for activities
- ActivityDAOStub: Stub class for activity persistence
- UserDAO: Handle persistence for users
- UserDAOStub: Stub class for user persistence
```

#### Interfaces:

```
com.myactivityplanner.enterprise.service:
- IActivityService: Interface for activity service; to be implemented by ActivityService
- IUserService: Interface for user service; to be implemented by UserService

com.myactivityplanner.enterprise.dao:
- IActivityDAO: Interface for persisting activities; to be implemented by ActivityDAO
- IUserDAO: Interface for persisting users; to be implemented by UserDAO
- IUserActivityDAO: Interface for persisting user to activity mappings; to be implemented by UserActivityDAO
```

#### Methods:

```
IActivityService:
- getUsersSignedUpForActivity(activityId: int): List<User> - Returns a list of users who have signed up for a specific activity
- getActivitiesForDate(date: java.time.LocalDate): List<Activity> - Returns a list of Activity objects that occur on the specified Date
- getSignedUpActivitiesForUser(userId: int): List<Activity> - Returns a list of Activity objects that the specified user has signed up for.
- isUserSignedUpForActivity(userId: int, activityId: int): boolean - Returns true if the specified user is signed up for the specified activity
- signUpForActivity(activityId: int, userId: int): void - Signs the specified user up for the specified activity
- withdrawFromActivity(activityId: int, userId: int): void - Withdraws the specified user from the specified activity
- getActivity(activityId: int): Activity - Returns an activity by ID
- saveActivity(activity: Activity): Activity - Upsert an Activity by ID and returns the updated/inserted activity object
- deleteActivity(activityId: int): int - Delete an activity by ID and returns the ID of the deleted activity

IUserService:
- createUser(firstName: String, lastName: String): User - Creates a new user and returns the created User object
- getUserName(userId: int): String - Returns the full name of the specified user in the format: firstname, lastname
- getUsers(): List<User> - Returns a list of all User objects 

IUserActivityDAO:
- getAllUserActivities(): List<UserActivity> - Returns a list of all UserActivity objects
- signUpUser(userId: int, activityId: int): void - Creates a record in the UserActivity table with the specified userId and activityId.
- withdrawUser(userId: int, activityId: int): void - Deletes a record in the UserActivity table with the specified userId and activityId.

IActivityDAO:
- getActivity(activityId: int): Activity - Returns an Activity object by ID
- getActivities(): List<Activity> - Returns a list of all Activity objects
- saveActivity(activity: Activity): Activity - Update an existing Activity if it exists, otherwise, create a new Activity. Returns updated/inserted activity object
- deleteActivity(activityId: int): void - Delete an Activity.

IUserDAO:
- createUser(firstName: String, lastName: String): User - Create a new user with the specified first and last name. Returns the created user object
- getUser(userId: int): User - Returns a user by ID
- getUsers(): List<User> - Returns a list of all users
```

## JSON Schema

JSON schema for use in a third-party app. This provides full information about a user's "My Activity List":

```json
{
  "type": "object",
  "properties": {
    "userId": {
      "type": "integer"
    },
    "activities": {
      "type": "array",
      "items": [
        {
          "type": "object",
          "properties": {
            "id": {
              "type": "integer"
            },
            "name": {
              "type": "string"
            },
            "description": {
              "type": "string"
            },
            "location": {
              "type": "string"
            },
            "timestamp": {
              "type": "string"
            }
          },
          "required": [
            "id",
            "name",
            "description",
            "location",
            "timestamp"
          ]
        }
      ]
    }
  },
  "required": [
    "userId",
    "activities"
  ]
}
```

## Scrum roles

**UI Specialists**: Abdoul S, Brian M

**Business Logic/Persistence Specialists**: Evan S, Jacob G

**Product Owner/Scrum Master/DevOps Specialist**: Jacob G

## Project Link

https://github.com/OneYellowLemon/MyActivityPlanner

## Milestones

[Milestone 1](https://github.com/OneYellowLemon/MyActivityPlanner/milestone/1)

[Milestone 2](https://github.com/OneYellowLemon/MyActivityPlanner/milestone/2)

[Milestone 3](https://github.com/OneYellowLemon/MyActivityPlanner/milestone/3)

## Standup Meeting

We meet every Wednesday at 4:30 pm EST.

> [!NOTE]
> Link not public due to public repository. Link has been shared with team.

<details>
    <summary>Why is it not public?</summary>

    As this is a public repository, we do not want our standup link public.
    
    As per the assignment instructions: If your repo is public, and you prefer not to put the Teams link there, no problem... just email it to me and your group members. However, you should still list the date and time of your weekly meeting(s).

</details>
