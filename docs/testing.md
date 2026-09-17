# Testing Documentation

## Testing Approach

The application was tested manually by running the Java program and checking each menu option with valid and invalid inputs.

## Test Cases

| Test Case | Input/Action | Expected Result | Status |
|---|---|---|---|
| TC01 | Start the application | Main menu is displayed | Passed |
| TC02 | Add a valid expense | Expense is added and saved | Passed |
| TC03 | Enter an invalid amount | Error message is displayed | Passed |
| TC04 | View all expenses | All saved expenses are displayed | Passed |
| TC05 | Search using a category | Matching expenses are displayed | Passed |
| TC06 | Delete using a valid ID | Selected expense is deleted | Passed |
| TC07 | Enter an invalid expense ID | Error message is displayed | Passed |
| TC08 | Calculate total expense | Correct total is displayed | Passed |
| TC09 | Calculate category total | Correct category total is displayed | Passed |
| TC10 | Restart the application | Previously saved expenses are loaded | Passed |

## Validation Testing

The following inputs were checked:

- Empty category
- Empty description
- Invalid amount
- Invalid menu choice
- Invalid expense ID
- Category with no matching expenses

## Result

The main functions of the Personal Expense Tracker were tested successfully. The application accepted valid inputs, rejected invalid inputs, displayed appropriate messages, and stored expense records in a file.