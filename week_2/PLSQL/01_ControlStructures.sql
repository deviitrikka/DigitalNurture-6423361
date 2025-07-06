-- SCENARIO 1
DECLARE
    CURSOR CUST_CURSOR IS
        SELECT CUSTOMERID, DOB FROM CUSTOMERS;
    
    AGE NUMBER;
BEGIN
    FOR CUST_REC IN CUST_CURSOR LOOP
        AGE := FLOOR(MONTHS_BETWEEN(SYSDATE, CUST_REC.DOB)/12);
        IF AGE > 60 THEN
            UPDATE LOANS
                SET INTERESTRATE = INTERESTRATE*0.99
                WHERE CUSTOMERID = CUST_REC.CUSTOMERID;
                DBMS_OUTPUT.PUT_LINE('Updated interest rate for CustomerID: ' || cust_rec.CustomerID || ' (Age: ' || age || ')');
        ELSE
            DBMS_OUTPUT.PUT_LINE('No update for CustomerID: ' || cust_rec.CustomerID || ' (Age: ' || age || ')');
        END IF;
    END LOOP;
END;

-- SCENARIO 2
DECLARE
    CURSOR CUST_CURSOR IS
        SELECT CUSTOMERID, BALANCE FROM CUSTOMERS;
    ISVIP BOOLEAN;
BEGIN
    FOR CUST IN CUST_CURSOR LOOP
        IF CUST.BALANCE > 10000 THEN
            ISVIP := TRUE;
            DBMS_OUTPUT.PUT_LINE('Customer No. ' || CUST.CUSTOMERID || ' is VIP with balance ' || CUST.BALANCE);
        ELSE
            ISVIP := FALSE;
        END IF;
        
    END LOOP;
END;

-- SCENARIO 3
DECLARE
    CURSOR CUR_LOAN IS
        SELECT LOANID, CUSTOMERID, ENDDATE FROM LOANS;
    DAYSLEFT NUMBER;
BEGIN
    FOR LOAN_REC IN CUR_LOAN LOOP 
        DAYSLEFT := LOAN_REC.ENDDATE - SYSDATE;
        IF DAYSLEFT <= 30 THEN
            DBMS_OUTPUT.PUT_LINE('Loan ID ' || LOAN_REC.LOANID || ' is due from Customer ' || LOAN_REC.CUSTOMERID || ' on ' || LOAN_REC.ENDDATE);
        END IF;
    END LOOP;
END;