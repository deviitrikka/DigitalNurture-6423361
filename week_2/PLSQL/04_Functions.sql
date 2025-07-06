-- Scenario 1
CREATE OR REPLACE FUNCTION CalculateAge(
    DOB DATE
) RETURN NUMBER IS
AGE NUMBER;
BEGIN
    AGE := FLOOR(MONTHS_BETWEEN(SYSDATE,DOB)/12);
    RETURN AGE;
EXCEPTION
WHEN OTHERS THEN
    DBMS_OUTPUT.PUT_LINE('Error calculating age: ' || SQLERRM);
    RETURN NULL;
END;


-- Scenario 2
CREATE OR REPLACE FUNCTION CalculateMonthlyInstallment(
    p_LoanAmount IN NUMBER,
    p_InterestRate IN NUMBER,  -- Annual interest rate in percentage, e.g., 6 for 6%
    p_Years IN NUMBER
) RETURN NUMBER IS
    v_MonthlyInterestRate NUMBER;
    v_NumberOfPayments NUMBER;
    v_Installment NUMBER;
BEGIN
    v_MonthlyInterestRate := p_InterestRate / 100 / 12;
    v_NumberOfPayments := p_Years * 12;

    -- Formula for EMI (Equated Monthly Installment):
    -- EMI = P * r * (1 + r)^n / ((1 + r)^n - 1)
    IF v_MonthlyInterestRate = 0 THEN
        -- No interest loan
        v_Installment := p_LoanAmount / v_NumberOfPayments;
    ELSE
        v_Installment := p_LoanAmount * v_MonthlyInterestRate *
                         POWER(1 + v_MonthlyInterestRate, v_NumberOfPayments) /
                         (POWER(1 + v_MonthlyInterestRate, v_NumberOfPayments) - 1);
    END IF;

    RETURN ROUND(v_Installment, 2);
EXCEPTION
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error calculating monthly installment: ' || SQLERRM);
        RETURN NULL;
END;


-- Scenario 3
CREATE OR REPLACE FUNCTION HasSufficientBalance(
    p_AccountID IN NUMBER,
    p_Amount IN NUMBER
) RETURN BOOLEAN IS
    v_Balance NUMBER;
BEGIN
    SELECT Balance INTO v_Balance FROM Accounts WHERE AccountID = p_AccountID;

    IF v_Balance >= p_Amount THEN
        RETURN TRUE;
    ELSE
        RETURN FALSE;
    END IF;

EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('Account ' || p_AccountID || ' not found.');
        RETURN FALSE;
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error checking balance: ' || SQLERRM);
        RETURN FALSE;
END;




DECLARE
    v_Age NUMBER;
BEGIN
    SELECT CalculateAge(TO_DATE('1980-01-01', 'YYYY-MM-DD'))
    INTO v_Age
    FROM dual;

    DBMS_OUTPUT.PUT_LINE('Age is: ' || v_Age);
END;

SELECT CalculateMonthlyInstallment(100000, 6, 5) AS MonthlyInstallment FROM dual;
DECLARE
    v_Result BOOLEAN;
BEGIN
    v_Result := HasSufficientBalance(1, 500);
    IF v_Result THEN
        DBMS_OUTPUT.PUT_LINE('Sufficient balance.');
    ELSE
        DBMS_OUTPUT.PUT_LINE('Insufficient balance.');
    END IF;
END;