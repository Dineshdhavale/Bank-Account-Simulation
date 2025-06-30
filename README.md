
## Features

* Account Creation:** Users can set up a new bank account by providing their name, a unique account number, and an initial balance.
* Deposit:** Add funds to the account.
* Withdrawal:** Remove funds from the account, with checks for insufficient balance.
* Balance Inquiry:** Instantly view the current account balance.
* Transaction History:** A detailed log of all deposits and withdrawals, including the date, type of transaction, amount, and the balance after each operation.
* Input Validation:** Basic checks to ensure valid numeric inputs and positive amounts for transactions.
---
## Project Structure

* `BankSimulation.java`: Contains the `main` method and the `BankSimulation` class, which handles user interaction and orchestrates the bank operations. It also includes the definitions for `Account` and `Transaction` classes for simplicity in this single-file example.
* `Account` Class: Manages the core banking logic, including `deposit`, `withdraw`, and maintaining the `balance` and `transactionHistory`.
* `Transaction` Class: Represents a single financial transaction, storing details like date, type, amount, and the resulting balance.

---
Welcome to the Bank Account Simulation!

--- Create Your Account ---
Enter Account Holder Name: Jane Doe
Enter Account Number: 987654321
Enter Initial Balance: $500.00

Account created successfully for Jane Doe (Account No: 987654321)
Current Balance: $500.00

--- Choose an Operation ---

Deposit

Withdraw

Check Balance

View Transaction History

Exit
Enter your choice: 1
Enter amount to deposit: $100.50
Deposit successful. New balance: $600.50

--- Choose an Operation ---

Deposit

Withdraw

Check Balance

View Transaction History

Exit
Enter your choice: 2
Enter amount to withdraw: $200.00
Withdrawal successful. New balance: $400.50

--- Choose an Operation ---

Deposit

Withdraw

Check Balance

View Transaction History

Exit
Enter your choice: 4
--- Transaction History for Account 987654321 --- Date: Mon Jun 30 19:47:27 IST 2025, Type: Initial Deposit, Amount: $500.00, New Balance: $500.00 Date: Mon Jun 30 19:47:45 IST 2025, Type: Deposit, Amount: $100.50, New Balance: $600.50 Date: Mon Jun 30 19:48:01 IST 2025, Type: Withdrawal, Amount: $200.00, New Balance: $400.50
--- Choose an Operation ---

Deposit

Withdraw

Check Balance

View Transaction History

Exit
Enter your choice: 5
Thank you for using the Bank Account Simulation. Goodbye!
