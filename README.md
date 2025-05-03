# Quiz Application - Spring Boot

This is a simple Quiz Application built using Spring Boot. It allows users to manage questions, create quizzes, fetch quizzes, and submit answers.

## Features

- Add and retrieve quiz questions
- Create quizzes dynamically based on category and number of questions
- Fetch quiz details
- Submit completed quizzes and calculate results

---

## API Endpoints

### 📋 Question Endpoints

#### 1. Get All Questions  
- **URL:** `/question/allQuestions`  
- **Method:** `GET`  
- **Description:** Fetch all available questions.

#### 2. Get Questions by Category  
- **URL:** `/question/category/{category}`  
- **Method:** `GET`  
- **Description:** Fetch all questions from a specific category.  
- **Path Variable:**  
  - `category` - (String) The category to filter questions.

#### 3. Add New Question  
- **URL:** `/question/add`  
- **Method:** `POST`  
- **Description:** Add a new question to the database.  
- **Request Body:**  
  ```json
  {
    "questionTitle": "What is Java?",
    "option1": "Programming Language",
    "option2": "Snake",
    "option3": "Coffee",
    "option4": "Planet",
    "rightAnswer": "Programming Language",
    "difficultyLevel": "Easy",
    "category": "java"
  }
  
## 🧠 Quiz Endpoints

### 4. Create Quiz  
- **URL:** `/quiz/create?category={category}&numQ={numQ}&title={title}`  
- **Method:** `POST`  
- **Description:** Creates a quiz based on the specified category and number of questions.  

**Query Parameters:**
- `category` (String): The category to pull questions from  
- `numQ` (Integer): Number of questions  
- `title` (String): Quiz title  

---

### 5. Fetch Quiz by ID  
- **URL:** `/quiz/{quizid}`  
- **Method:** `GET`  
- **Description:** Retrieves a quiz for attempting.  

**Path Variable:**
- `quizid` (Long): ID of the quiz  

---

### 6. Submit Quiz  
- **URL:** `/quiz/submit/{id}`  
- **Method:** `POST`  
- **Description:** Submit answers for a quiz and get the result.  

**Path Variable:**
- `id` (Long): ID of the quiz  

**Request Body:**
```json
[
  {
    "id": 1,
    "answer": "Programming Language"
  },
  {
    "id": 2,
    "answer": "Spring Boot"
  }
]

