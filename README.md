# Polynomial Calculator

## Project Overview

The Polynomial Calculator is a Java application designed for the manipulation of polynomial expressions. It provides a command-line interface for users to input polynomial terms, and then perform essential operations such as addition, multiplication, and term removal.

This project implements core data structure concepts, specifically single-linked lists, to represent and handle polynomial terms in an efficient and flexible manner.

## Key Features

*   **Polynomial Input:** Users can input multiple terms of polynomial expressions through a straightforward coefficient and power based input system.
*   **Ordered Term Storage:** The application organizes and stores polynomial terms in ascending order of their degrees.
*   **Polynomial Addition:** Implements an operation to add two polynomial expressions and return the resulting polynomial.
*   **Polynomial Multiplication:** Implements an operation to multiply two polynomial expressions and return the resulting polynomial.
*   **Term Removal:** Allows users to remove all terms of a given degree from both polynomial expressions.
*   **Output to Console:** Results for polynomial operations are displayed on the console for easy access.
*   **Exception Handling:** Implements robust exception handling to gracefully deal with invalid user inputs.

## How to Use the Calculator

1.  Upon starting the application, you'll be prompted to input the coefficients and powers for two polynomial expressions. Enter a `0` when you're finished with each input.
2.  After entering both polynomials, the program will present a menu to choose operations:
    *   **1 - Add:** Add the two polynomials together.
    *   **2 - Multiply:** Multiply the two polynomials.
    *   **3 - Print:** Print the current forms of both polynomials.
    *   **4 - Delete:** Remove terms with a specified degree.
    *   **5 - Exit:** Terminate the program.
3.  Input your choice, and you will be provided with results in the terminal.

## File Structure
├── Node.java # Class for the Node Object
├── MyLinkedList.java # Implementation of a linked list
├── Proj_1_comp_2112.java # Main application class for the polynomial calculator
└── README.md # This document

## Technical Details

*   **Linked List Implementation:** Polynomials are represented using single-linked lists, where each node stores a coefficient and its corresponding power.
*   **Ordered Insertion:** Polynomial terms are inserted into the linked list based on the ascending order of their degrees. This ensures that the polynomials are stored in an organized manner.
*   **Efficient Operations:** The addition and multiplication methods traverse through the linked lists to produce the final polynomial in an efficient manner.
*  **Error Handling:** All inputs are monitored for exception, and handled accordingly.

## Notes and Considerations

*   This project was designed to demonstrate the use of custom data structures (linked lists) to represent mathematical concepts effectively.
*   This code is designed for clear understanding and not optimal performance.
*   The `addInOrder` function maintains the order of the polynomials.
* The functions were written with extensibility and reusability in mind
