# EVotingSystem

**EVotingSystem** is a REST API project designed to facilitate electronic voting. This system allows users to participate in elections, cast votes, and view results efficiently.

---

![image alt](https://github.com/rahulwadhekar/EVotingSystem/blob/f55cf603196606e01ee9d882c007dc4115943630/Screenshot%202025-01-17%20104949.png)

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

- **Get All Users**
`GET /get/users`

-**Election Endpoints**
Add Election
`POST /add/election`
**Body**
```json

{
  "name": "Presidential Election 2025"
}
```
-**Get All Elections**
`GET /get/elections`
-**Election Choice Endpoints**
**Add Election Choice**
`POST /add/electionChoice`
**Body**
```json

{
  "name": "Candidate A",
  "election": {
    "id": 1
  }
}
```
**Get All Election Choices**
`GET /get/electionChoices`
-**Voting Endpoints**
**Cast Vote**
`POST /add/vote?userId={userId}&electionId={electionId}&electionChoiceId={electionChoiceId}`
-**Get All Votes**
`GET /get/votes`
-**Count Total Votes**
`GET /count/votes`
**Count Votes by Election Name**
`GET /count/votes/{electionName}`
-**Result Endpoints-**
**Get Election Winner**
`GET /winner/election/{electionName}`
**Installation**
*Clone the repository:*


```
git clone https://github.com/your-username/EVotingSystem.git
```

**Navigate to the project directory:**



```
cd EVotingSystem
```

**Build and run the application:**
```
mvn spring-boot:run
```
***Project Structure***

```
EVotingSystem/
├── src/main/java
│   ├── com/codingninjas/EVotingSystem
│   │   ├── entities
│   │   ├── controllers
│   │   ├── repositories
│   │   └── services
├── src/main/resources
│   └── application.properties
└── pom.xml

```
**License**
This project is licensed under the MIT License. See the LICENSE file for details.



Name: Rahul
Email: wadhekarrahul1818@gmail.com
GitHub: github.com/rahulwadhekar
