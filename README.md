# Restaurant Ordering System

A Java console application developed as a final project for Computer Programming course. This system simulates a restaurant ordering experience with menu browsing, order management, and payment processing functionality.

## Project Information

- **Course**: Computer Programming (1st Year)
- **Language**: Java
- **Type**: Console Application
- **Author**: zkil27

## Features

- Interactive menu system with three categories
- Order management with quantity tracking
- Multiple payment methods with convenience fees
- Automatic tax calculation (15%)
- Receipt generation with detailed breakdown
- Input validation and error handling

## System Requirements

- Java 8 or higher
- Command line interface

## Installation and Setup

1. Clone the repository:
```bash
git clone https://github.com/zkil27/COMPROGPROJECT.git
```

2. Navigate to source directory:
```bash
cd COMPROGPROJECT/PROJECT/src
```

3. Compile:
```bash
javac Main.java
```

4. Run:
```bash
java Main
```

## How to Use

1. Enter customer name
2. Select menu category (1-3) or proceed to checkout (4)
3. Choose items and specify quantities
4. Select payment method
5. Enter payment amount
6. Receive receipt

## Menu Structure

- **Dishes**: 8 items (₱100-150)
- **Desserts**: 8 items (₱200-250)  
- **Drinks**: 8 items (₱5-111)

## Payment Options

| Payment Method | Convenience Fee |
|---------------|----------------|
| Cash | 0% |
| Debit Card | 0% |
| Credit Card | 0.5% |
| GCash | 0.05% |
| Paymaya | 0.005% |
| PayPal | 0.0005% |

## Technical Implementation

- **Data Storage**: Arrays for menu items and pricing
- **Input Handling**: Scanner class
- **Calculations**: Subtotal + Tax (15%) + Convenience Fee
- **Output**: Formatted receipts with date stamps

## File Structure

```
COMPROGPROJECT/
└── PROJECT/
    └── src/
        └── Main.java (Main application file)
```

## Key Functions

- `hahahaha()`: Handles item selection and cart operations
- `ykona()`: Processes payments and generates receipts
- `anolang()`: Utility function for screen formatting

## Academic Learning Objectives

This project demonstrates:
- Basic Java programming concepts
- Array manipulation
- User input/output handling
- Control structures (loops, conditionals)
- Method implementation
- Mathematical calculations in programming

## Status

Completed as final project submission for Computer Programming course.
