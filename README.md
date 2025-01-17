# EVotingSystem

**EVotingSystem** is a REST API project designed to facilitate electronic voting. This system allows users to participate in elections, cast votes, and view results efficiently.

---

## Features

### 1. **User Management:**
- **Add User**: Add users to the system.
- **Get All Users**: Retrieve all users.

### 2. **Election Management:**
- **Create Election**: Add new elections.
- **Get All Elections**: Retrieve all elections.
- **Manage Election Choices**: Manage the election options available for voting.

### 3. **Voting System:**
- **Cast Vote**: Users can cast votes for specific election choices.
- **Prevent Duplicate Voting**: Ensure that users can't vote more than once in an election.

### 4. **Analytics:**
- **Count Total Votes**: Retrieve the total number of votes for each election.
- **Identify Winner**: Determine the winner of an election based on votes.

---

## Technologies Used
- **Backend Framework**: Spring Boot
- **Database**: H2 (In-memory database)
- **ORM Tool**: JPA (Java Persistence API)

---

## Endpoints

### User Endpoints

- **Add User**  
  `POST /add/user`  
  **Body**:
  ```json
  {
    "name": "John Doe"
  }
