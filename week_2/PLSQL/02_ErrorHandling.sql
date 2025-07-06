-- Scenario 1
CREATE OR REPLACE PROCEDURE SafeTransferFunds(
    p_FromAccount IN NUMBER,
    p_ToAccount IN NUMBER,
    p_Amount IN NUMBER
) AS
    v_FromBalance NUMBER;
BEGIN
    -- 1. Checking if both accounts exist
    SELECT Balance INTO v_FromBalance
    FROM Accounts
    WHERE AccountID = p_FromAccount;

    -- 2. Checking for sufficient balance
    IF v_FromBalance < p_Amount THEN
        RAISE_APPLICATION_ERROR(-20001, 'Insufficient funds in source account.');
    END IF;

    -- 3. Deducting from sender
    UPDATE Accounts
    SET Balance = Balance - p_Amount,
        LastModified = SYSDATE
    WHERE AccountID = p_FromAccount;

    -- 4. Adding to receiver
    UPDATE Accounts
    SET Balance = Balance + p_Amount,
        LastModified = SYSDATE
    WHERE AccountID = p_ToAccount;

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('Transfer successful: ' || p_Amount || ' transferred from account ' || p_FromAccount || ' to account ' || p_ToAccount);

EXCEPTION
    WHEN NO_DATA_FOUND THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: One or both accounts not found.');
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Unexpected error: ' || SQLERRM);
END;
EXEC SafeTransferFunds(3, 4, 1000);
EXEC SafeTransferFunds(1, 2, 999999);

-- Scenario 2
CREATE OR REPLACE PROCEDURE UpdateSalary(
    p_EmployeeID IN NUMBER,
    p_Percent IN NUMBER
) AS
BEGIN
    -- Update salary by the given percentage
    UPDATE Employees
    SET Salary = Salary + (Salary * p_Percent / 100)
    WHERE EmployeeID = p_EmployeeID;

    -- If no rows were updated, the employee does not exist
    IF SQL%ROWCOUNT = 0 THEN
        RAISE_APPLICATION_ERROR(-20001, 'Employee ID ' || p_EmployeeID || ' does not exist.');
    END IF;

    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Salary updated successfully for EmployeeID: ' || p_EmployeeID);

EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error updating salary for EmployeeID ' || p_EmployeeID || ': ' || SQLERRM);
END;

EXEC UpdateSalary(102, 10);  -- Bob Smith gets a 10% raise
-- Triggering error handling
BEGIN
    UpdateSalary(999, 5);
END;

-- Scenario 3
CREATE OR REPLACE PROCEDURE AddNewCustomer(
    p_CustomerID IN NUMBER,
    p_Name       IN VARCHAR2,
    p_DOB        IN DATE,
    p_Balance    IN NUMBER
) AS
    v_Count NUMBER;
BEGIN
    -- Checking if customer with the same ID already exists
    SELECT COUNT(*) INTO v_Count
    FROM Customers
    WHERE CustomerID = p_CustomerID;

    IF v_Count > 0 THEN
        RAISE_APPLICATION_ERROR(-20001, 'Customer with ID ' || p_CustomerID || ' already exists.');
    END IF;

    -- Inserting the new customer
    INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
    VALUES (p_CustomerID, p_Name, p_DOB, p_Balance, SYSDATE);

    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Customer inserted successfully: ' || p_Name);

EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error adding customer: ' || SQLERRM);
END;
EXEC AddNewCustomer(9, 'Zoya Mirza', TO_DATE('1993-08-15', 'YYYY-MM-DD'), 7000);
EXEC  AddNewCustomer(1, 'Rishi Raj', TO_DATE('1980-01-01', 'YYYY-MM-DD'), 5000);
