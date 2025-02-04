import java.util.List;
import java.util.ArrayList;

public class EmployeeBook {

    private final Employee[] EMPLOYEES;

    public EmployeeBook(int capacity) {
        this.EMPLOYEES = new Employee[capacity];
    }

    public boolean addEmployee(String fullname, String department, double salary) {
        for (int i = 0; i < EMPLOYEES.length; i++) {
            if (EMPLOYEES[i] == null) {
                EMPLOYEES[i] = new Employee(fullname, department, salary);
                return true;
            }
        }
        return false;
    }

    public Employee findEmployeeByID(int id) {
        for (int i = 0; i < EMPLOYEES.length; i++) {
            if (EMPLOYEES[i] != null && EMPLOYEES[i].getId() == id) {
                return EMPLOYEES[i];
            }
        }
        return null;
    }

    public boolean removeEmployee(int id) {
        for (int i = 0; i < EMPLOYEES.length; i++) {
            if (EMPLOYEES[i] != null && EMPLOYEES[i].getId() == id) {
                EMPLOYEES[i] = null;
                return true;
            }
        }
        return false;
    }

    public int getActualSize() {
        int actualSize = 0;
        for (int i = 0; i < EMPLOYEES.length; i++) {
            if (EMPLOYEES[i] != null) {
                actualSize++;
            }
        }
        return actualSize;
    }

    public void printBook() {
        for (int i = 0; i < EMPLOYEES.length; i++) {
            if (EMPLOYEES[i] != null) {
                System.out.println(EMPLOYEES[i]);
            }
        }
    }

    public double calculateTotalSalary() {
        double wageFund = 0;
        for (int i = 0; i < EMPLOYEES.length; i++) {
            if (EMPLOYEES[i] != null) {
                wageFund += EMPLOYEES[i].getSalary();
            }
        }
        return wageFund;
    }

    public Employee minSalaryEmployee() {
        Employee minEmployeeSalary = null;
        for (int i = 0; i < EMPLOYEES.length; i++) {
            if (EMPLOYEES[i] != null && (minEmployeeSalary == null || EMPLOYEES[i].getSalary() < minEmployeeSalary.getSalary())) {
                minEmployeeSalary = EMPLOYEES[i];
            }
        }
        return minEmployeeSalary;
    }

    public Employee maxSalaryEmployee() {
        Employee maxEmployeeSalary = null;
        for (int i = 0; i < EMPLOYEES.length; i++) {
            if (EMPLOYEES[i] != null && (maxEmployeeSalary == null || EMPLOYEES[i].getSalary() > maxEmployeeSalary.getSalary())) {
                maxEmployeeSalary = EMPLOYEES[i];
            }
        }
        return maxEmployeeSalary;
    }

    public void printNames() {
        System.out.println();
        for (int i = 0; i < EMPLOYEES.length; i++) {
            if (EMPLOYEES[i] != null) {
                System.out.println(EMPLOYEES[i].getFullname());
            }
        }
    }

    public void increaseSalary(double percentageIncrease) {
        for (int i = 0; i < EMPLOYEES.length; i++) {
            if (EMPLOYEES[i] != null) {
                EMPLOYEES[i].setSalary(EMPLOYEES[i].getSalary() * (1 + percentageIncrease / 100));
            }
        }
    }

    private List<Employee> findEmployeeByDepartment(String department) {
        List<Employee> employeesInDepartment = new ArrayList<>();
        if (department != null) {
            for (int i = 0; i < EMPLOYEES.length; i++) {
                if (EMPLOYEES[i] != null && EMPLOYEES[i].getDepartment().equals(department)) {
                    employeesInDepartment.add(EMPLOYEES[i]);
                }
            }
        } else {
            System.out.println("Неверно задан отдел (findEmployeeInDepartment)");
        }
        return employeesInDepartment;
    }

    public Employee findEmployeeWithMinSalaryInDepartment(String department) {
        Employee minSalaryEmployee = null;
        if (department != null) {
            for (int i = 0; i < EMPLOYEES.length; i++) {
                if (EMPLOYEES[i] != null && EMPLOYEES[i].getDepartment().equals(department) && (minSalaryEmployee == null || EMPLOYEES[i].getSalary() < minSalaryEmployee.getSalary())) {
                    minSalaryEmployee = EMPLOYEES[i];
                }
            }
        } else {
            System.out.println("Неверно задан отдел (findEmployeeWithMinSalaryInDepartment)");
        }
        return minSalaryEmployee;
    }

    public Employee findEmployeeWithMaxSalaryInDepartment(String department) {
        Employee maxSalaryEmployee = null;
        if (department != null) {
            for (int i = 0; i < EMPLOYEES.length; i++) {
                if (EMPLOYEES[i] != null && EMPLOYEES[i].getDepartment().equals(department) && (maxSalaryEmployee == null || EMPLOYEES[i].getSalary() > maxSalaryEmployee.getSalary())) {
                    maxSalaryEmployee = EMPLOYEES[i];
                }
            }
        } else {
            System.out.println("Неверно задан отдел (findEmployeeWithMaxSalaryInDepartment)");
        }
        return maxSalaryEmployee;
    }

    public double calculateTotalSalaryInDepartment(String department) {
        double wageFund = 0;
        if (department != null) {
            for (int i = 0; i < EMPLOYEES.length; i++) {
                if (EMPLOYEES[i] != null && EMPLOYEES[i].getDepartment().equals(department)) {
                    wageFund += EMPLOYEES[i].getSalary();
                }
            }
        } else {
            System.out.println("Неверно задан отдел (calculateTotalSalaryInDepartment)");
        }
        return wageFund;
    }

    public double calculateMiddleSalaryInDepartment(String department) {
        double wageFund = 0;
        int numberOfEmployees = 0;
        if (department != null) {
            for (int i = 0; i < EMPLOYEES.length; i++) {
                if (EMPLOYEES[i] != null && EMPLOYEES[i].getDepartment().equals(department)) {
                    wageFund += EMPLOYEES[i].getSalary();
                    numberOfEmployees++;
                }
            }
        } else {
            System.out.println("Неверно задан отдел (calculateMiddleSalaryInDepartment)");
        }
        return numberOfEmployees == 0 ? 0 : wageFund / numberOfEmployees;
    }

    public void increaseSalaryInDepartment(String department, double percentageIncrease) {
        if (department != null) {
            for (int i = 0; i < EMPLOYEES.length; i++) {
                if (EMPLOYEES[i] != null && EMPLOYEES[i].getDepartment().equals(department)) {
                    EMPLOYEES[i].setSalary(EMPLOYEES[i].getSalary() * (1 + percentageIncrease / 100));
                }
            }
            System.out.println("Индексация ЗП...");
        } else {
            System.out.println("Неверно задан отдел (increaseSalaryInDepartment)");
        }
    }

    public void printEmployeesInDepartment(String department) {
        if (department != null) {
            List<Employee> employeesInDepartment = findEmployeeByDepartment(department);
            for (Employee employee : employeesInDepartment) {
                System.out.println(employee.toString(true));
            }
        } else {
            System.out.println("Неверно задан отдел (printEmployeesInDepartment)");
        }
    }

    public Employee[] findEmployeesWithSalaryLessThan(double salaryCompared) {
        List<Employee> employeeWithSalaryLessThanCompared = new ArrayList<>();
        for (int i = 0; i < EMPLOYEES.length; i++) {
            if (EMPLOYEES[i] != null && EMPLOYEES[i].getSalary() < salaryCompared) {
                employeeWithSalaryLessThanCompared.add(EMPLOYEES[i]);
            }
        }
        Employee[] employeeFound = new Employee[employeeWithSalaryLessThanCompared.size()];
        for (int i = 0; i < employeeWithSalaryLessThanCompared.size(); i++) {
            employeeFound[i] = employeeWithSalaryLessThanCompared.get(i);
        }
        return employeeFound;
    }

    public Employee[] findEmployeesWithSalaryMoreThan(double salaryCompared) {
        List<Employee> employeeWithSalaryMoreThanCompared = new ArrayList<>();
        for (int i = 0; i < EMPLOYEES.length; i++) {
            if (EMPLOYEES[i] != null && EMPLOYEES[i].getSalary() >= salaryCompared) {
                employeeWithSalaryMoreThanCompared.add(EMPLOYEES[i]);
            }
        }
        Employee[] employeeFound = new Employee[employeeWithSalaryMoreThanCompared.size()];
        for (int i = 0; i < employeeWithSalaryMoreThanCompared.size(); i++) {
            employeeFound[i] = employeeWithSalaryMoreThanCompared.get(i);
        }
        return employeeFound;
    }

}