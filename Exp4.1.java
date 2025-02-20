import java.util.*;

class Employee {
    int id;
    String name;
    double salary;
    Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Salary: " + salary;
    }
}

public class EmployeeManagement {
    static List<Employee> employees = new ArrayList<>();
    
    static void addEmployee(int id, String name, double salary) {
        for (Employee e : employees) {
            if (e.id == id) {
                System.out.println("Error: Employee with ID " + id + " already exists.");
                return;
            }
        }
        employees.add(new Employee(id, name, salary));
        System.out.println("Employee Added: ID=" + id + ", Name=" + name + ", Salary=" + salary);
    }
    
    static void updateEmployee(int id, double newSalary) {
        for (Employee e : employees) {
            if (e.id == id) {
                e.salary = newSalary;
                System.out.println("Employee ID " + id + " updated successfully.");
                return;
            }
        }
        System.out.println("Employee ID " + id + " not found.");
    }
    
    static void removeEmployee(int id) {
        Iterator<Employee> it = employees.iterator();
        while (it.hasNext()) {
            if (it.next().id == id) {
                it.remove();
                System.out.println("Employee ID " + id + " removed successfully.");
                return;
            }
        }
        System.out.println("Employee ID " + id + " not found.");
    }
    
    static void searchEmployee(int id) {
        for (Employee e : employees) {
            if (e.id == id) {
                System.out.println("Employee Found: " + e);
                return;
            }
        }
        System.out.println("Employee not found.");
    }
    
    static void displayEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees found.");
        } else {
            for (Employee e : employees) {
                System.out.println(e);
            }
        }
    }
    
    public static void main(String[] args) {
        addEmployee(101, "Anish", 50000);
        addEmployee(102, "Bobby", 60000);
        updateEmployee(101, 55000);
        searchEmployee(102);
        removeEmployee(101);
        displayEmployees();
        addEmployee(101, "Charlie", 70000);
    }
}
