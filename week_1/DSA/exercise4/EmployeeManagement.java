public class EmployeeManagement {

    // Employee class
    static class Employee {
        int employeeId;
        String name;
        String position;
        double salary;

        public Employee(int employeeId, String name, String position, double salary) {
            this.employeeId = employeeId;
            this.name = name;
            this.position = position;
            this.salary = salary;
        }

        public void display() {
            System.out.println("ID: " + employeeId + ", Name: " + name + ", Position: " + position + ", Salary: " + salary);
        }
    }

    // EmployeeManager class
    static class EmployeeManager {
        private Employee[] employees;
        private int count;

        public EmployeeManager(int size) {
            employees = new Employee[size];
            count = 0;
        }

        // Add an employee
        public void addEmployee(Employee emp) {
            if (count < employees.length) {
                employees[count++] = emp;
                System.out.println("Employee added successfully.");
            } else {
                System.out.println("Cannot add more employees. Array is full.");
            }
        }

        // Search employee by ID
        public Employee searchEmployee(int id) {
            for (int i = 0; i < count; i++) {
                if (employees[i].employeeId == id) {
                    return employees[i];
                }
            }
            return null;
        }

        // Traverse all employees
        public void traverseEmployees() {
            if (count == 0) {
                System.out.println("No employees to display.");
            } else {
                for (int i = 0; i < count; i++) {
                    employees[i].display();
                }
            }
        }

        // Delete employee by ID
        public void deleteEmployee(int id) {
            boolean found = false;
            for (int i = 0; i < count; i++) {
                if (employees[i].employeeId == id) {
                    found = true;
                    for (int j = i; j < count - 1; j++) {
                        employees[j] = employees[j + 1];
                    }
                    employees[count - 1] = null;
                    count--;
                    System.out.println("Employee deleted successfully.");
                    break;
                }
            }
            if (!found) {
                System.out.println("Employee not found.");
            }
        }
    }

    // Main method
    public static void main(String[] args) {
        EmployeeManager manager = new EmployeeManager(5);

        // Adding employees
        manager.addEmployee(new Employee(101, "Alice", "Developer", 60000));
        manager.addEmployee(new Employee(102, "Bob", "Designer", 55000));
        manager.addEmployee(new Employee(103, "Charlie", "Manager", 75000));

        // Traversing
        System.out.println("\nAll employees:");
        manager.traverseEmployees();

        // Searching
        System.out.println("\nSearching for employee with ID 102:");
        Employee emp = manager.searchEmployee(102);
        if (emp != null) emp.display();
        else System.out.println("Employee not found.");

        // Deleting
        System.out.println("\nDeleting employee with ID 102:");
        manager.deleteEmployee(102);

        // Traversing again
        System.out.println("\nAll employees after deletion:");
        manager.traverseEmployees();
    }
}
