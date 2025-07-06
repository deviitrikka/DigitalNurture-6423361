-- Scenario 1
CREATE OR REPLACE PACKAGE CustomerManagement AS
    PROCEDURE AddCustomer(p_ID NUMBER, p_Name VARCHAR2, p_DOB DATE, p_Balance NUMBER);
    PROCEDURE UpdateCustomer(p_ID NUMBER, p_Name VARCHAR2, p_DOB DATE);
    FUNCTION GetCustomerBalance(p_ID NUMBER) RETURN NUMBER;
END CustomerManagement;

CREATE OR REPLACE PACKAGE BODY CustomerManagement AS

    PROCEDURE AddCustomer(p_ID NUMBER, p_Name VARCHAR2, p_DOB DATE, p_Balance NUMBER) IS
    BEGIN
        INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
        VALUES (p_ID, p_Name, p_DOB, p_Balance, SYSDATE);
    EXCEPTION
        WHEN DUP_VAL_ON_INDEX THEN
            DBMS_OUTPUT.PUT_LINE('Customer with ID ' || p_ID || ' already exists.');
    END;

    PROCEDURE UpdateCustomer(p_ID NUMBER, p_Name VARCHAR2, p_DOB DATE) IS
    BEGIN
        UPDATE Customers
        SET Name = p_Name, DOB = p_DOB, LastModified = SYSDATE
        WHERE CustomerID = p_ID;
    END;

    FUNCTION GetCustomerBalance(p_ID NUMBER) RETURN NUMBER IS
        balance NUMBER;
    BEGIN
        SELECT Balance INTO balance FROM Customers WHERE CustomerID = p_ID;
        RETURN balance;
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            RETURN NULL;
    END;

END CustomerManagement;
EXEC CustomerManagement.AddCustomer(10, 'Aditi Sharma', TO_DATE('1995-04-10', 'YYYY-MM-DD'), 8000);
EXEC CustomerManagement.UpdateCustomer(10, 'Aditi Sharma', TO_DATE('1995-04-10', 'YYYY-MM-DD'));


-- Scenario 2
CREATE OR REPLACE PACKAGE EmployeeManagement AS
    PROCEDURE HireEmployee(p_ID NUMBER, p_Name VARCHAR2, p_Position VARCHAR2, p_Salary NUMBER, p_Dept VARCHAR2);
    PROCEDURE UpdateEmployee(p_ID NUMBER, p_Salary NUMBER);
    FUNCTION CalculateAnnualSalary(p_ID NUMBER) RETURN NUMBER;
END EmployeeManagement;

CREATE OR REPLACE PACKAGE BODY EmployeeManagement AS

    PROCEDURE HireEmployee(p_ID NUMBER, p_Name VARCHAR2, p_Position VARCHAR2, p_Salary NUMBER, p_Dept VARCHAR2) IS
    BEGIN
        INSERT INTO Employees (EmployeeID, Name, Position, Salary, Department, HireDate)
        VALUES (p_ID, p_Name, p_Position, p_Salary, p_Dept, SYSDATE);
    END;

    PROCEDURE UpdateEmployee(p_ID NUMBER, p_Salary NUMBER) IS
    BEGIN
        UPDATE Employees
        SET Salary = p_Salary
        WHERE EmployeeID = p_ID;
    END;

    FUNCTION CalculateAnnualSalary(p_ID NUMBER) RETURN NUMBER IS
        salary NUMBER;
    BEGIN
        SELECT Salary INTO salary FROM Employees WHERE EmployeeID = p_ID;
        RETURN salary * 12;
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            RETURN NULL;
    END;

END EmployeeManagement;
EXEC EmployeeManagement.HireEmployee(203, 'Vasu Mehta', 'Analyst', 30000, 'Finance');
EXEC EmployeeManagement.UpdateEmployee(101, 35000);


-- Scenario 3
CREATE OR REPLACE PACKAGE AccountOperations AS
    PROCEDURE OpenAccount(p_AccountID NUMBER, p_CustomerID NUMBER, p_Type VARCHAR2, p_Balance NUMBER);
    PROCEDURE CloseAccount(p_AccountID NUMBER);
    FUNCTION GetTotalBalance(p_CustomerID NUMBER) RETURN NUMBER;
END AccountOperations;

CREATE OR REPLACE PACKAGE BODY AccountOperations AS

    PROCEDURE OpenAccount(p_AccountID NUMBER, p_CustomerID NUMBER, p_Type VARCHAR2, p_Balance NUMBER) IS
    BEGIN
        INSERT INTO Accounts (AccountID, CustomerID, AccountType, Balance, LastModified)
        VALUES (p_AccountID, p_CustomerID, p_Type, p_Balance, SYSDATE);
    END;

    PROCEDURE CloseAccount(p_AccountID NUMBER) IS
    BEGIN
        DELETE FROM Accounts WHERE AccountID = p_AccountID;
    END;

    FUNCTION GetTotalBalance(p_CustomerID NUMBER) RETURN NUMBER IS
        total_balance NUMBER := 0;
    BEGIN
        SELECT SUM(Balance) INTO total_balance
        FROM Accounts
        WHERE CustomerID = p_CustomerID;

        RETURN total_balance;
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            RETURN 0;
    END;

END AccountOperations;
EXEC AccountOperations.OpenAccount(201, 10, 'Savings', 5000);
EXEC AccountOperations.CloseAccount(201);
