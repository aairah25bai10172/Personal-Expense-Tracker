# Project Statement

## Project Title

Personal Expense Tracker

## Problem Statement

Managing daily expenses manually can be difficult. People may forget where their money was spent or find it difficult to calculate their total expenses.

The Personal Expense Tracker is designed to provide a simple command-line application for recording and managing personal expenses.

## Objectives

- Record personal expenses
- Organize expenses by category
- View saved expense records
- Search expenses easily
- Delete incorrect records
- Calculate total expenses
- Calculate category-wise expenses
- Store data permanently using file handling

## Functional Requirements

1. The system shall allow users to add an expense.
2. The system shall display all expenses.
3. The system shall search expenses by category.
4. The system shall delete an expense using its ID.
5. The system shall calculate the total expense.
6. The system shall calculate the total expense for a category.
7. The system shall save expense records in a file.
8. The system shall validate user input.

## Non-Functional Requirements

- **Usability:** The application should be easy to use.
- **Reliability:** The application should handle invalid input.
- **Maintainability:** The code should be divided into separate classes.
- **Performance:** The application should process normal user operations quickly.
- **Data Persistence:** Expense records should remain saved after the program closes.

## Major Modules

### 1. Expense Model

Stores expense details such as ID, amount, category, date, and description.

### 2. Expense Service

Handles adding, viewing, searching, deleting, and calculating expenses.

### 3. File Storage

Saves and loads expense records from a text file.

### 4. Input Validator

Checks whether user input is valid.

### 5. Main Menu

Provides the user interface and connects all modules.

## Input

The application accepts:

- Expense amount
- Expense category
- Expense date
- Expense description
- Menu choice
- Expense ID

## Output

The application displays:

- Expense records
- Search results
- Total expenses
- Category-wise totals
- Error messages
- Success messages

## Technologies Used

- Java
- Object-Oriented Programming
- ArrayList
- File Handling
- BufferedReader
- BufferedWriter
- Exception Handling
- Git and GitHub

## Expected Outcome

The completed application will help users manage personal expenses through a simple, organized, and reliable command-line system.