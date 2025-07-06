DECLARE
    CURSOR txn_cursor IS
        SELECT c.CustomerID, c.Name, t.TransactionID, t.TransactionDate, t.Amount, t.TransactionType
        FROM Customers c
        JOIN Accounts a ON c.CustomerID = a.CustomerID
        JOIN Transactions t ON a.AccountID = t.AccountID
        WHERE EXTRACT(MONTH FROM t.TransactionDate) = EXTRACT(MONTH FROM SYSDATE)
          AND EXTRACT(YEAR FROM t.TransactionDate) = EXTRACT(YEAR FROM SYSDATE)
        ORDER BY c.CustomerID, t.TransactionDate;

    customer_id     Customers.CustomerID%TYPE;
    customer_name   Customers.Name%TYPE;
    transaction_id  Transactions.TransactionID%TYPE;
    transaction_date Transactions.TransactionDate%TYPE;
    amount          Transactions.Amount%TYPE;
    transaction_type Transactions.TransactionType%TYPE;
BEGIN
    OPEN txn_cursor;
    LOOP
        FETCH txn_cursor INTO customer_id, customer_name, transaction_id, transaction_date, amount, transaction_type;
        EXIT WHEN txn_cursor%NOTFOUND;

        DBMS_OUTPUT.PUT_LINE('Customer: ' || customer_name || 
                             ' | Transaction ID: ' || transaction_id || 
                             ' | Date: ' || TO_CHAR(transaction_date, 'DD-MON-YYYY') ||
                             ' | Type: ' || transaction_type || 
                             ' | Amount: ₹' || amount);
    END LOOP;
    CLOSE txn_cursor;
END;

DECLARE
    CURSOR account_cursor IS
        SELECT AccountID, Balance
        FROM Accounts;

    account_id Accounts.AccountID%TYPE;
    balance    Accounts.Balance%TYPE;
    annual_fee CONSTANT NUMBER := 100; 
BEGIN
    OPEN account_cursor;
    LOOP
        FETCH account_cursor INTO account_id, balance;
        EXIT WHEN account_cursor%NOTFOUND;

        UPDATE Accounts
        SET Balance = Balance - annual_fee,
            LastModified = SYSDATE
        WHERE AccountID = account_id;

        DBMS_OUTPUT.PUT_LINE('Annual fee of ₹' || annual_fee || ' applied to Account ID: ' || account_id);
    END LOOP;
    CLOSE account_cursor;

    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error applying annual fee: ' || SQLERRM);
END;

DECLARE
    CURSOR loan_cursor IS
        SELECT LoanID, InterestRate
        FROM Loans;

    loan_id      Loans.LoanID%TYPE;
    interest     Loans.InterestRate%TYPE;
    new_rate     NUMBER;
BEGIN
    OPEN loan_cursor;
    LOOP
        FETCH loan_cursor INTO loan_id, interest;
        EXIT WHEN loan_cursor%NOTFOUND;

        IF interest > 6 THEN
            new_rate := interest - 0.5;
        ELSE
            new_rate := interest;
        END IF;

        UPDATE Loans
        SET InterestRate = new_rate
        WHERE LoanID = loan_id;

        DBMS_OUTPUT.PUT_LINE('Updated Loan ID ' || loan_id || ' | Old Rate: ' || interest || ' | New Rate: ' || new_rate);
    END LOOP;
    CLOSE loan_cursor;

    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error updating loan interest rates: ' || SQLERRM);
END;
