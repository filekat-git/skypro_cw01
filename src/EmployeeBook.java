import java.util.List;
import java.util.ArrayList;

public class EmployeeBook {

    private final Employee[] EMPLOYEES;
    private int counter;

    public EmployeeBook(int capacity) {
        this.EMPLOYEES = new Employee[capacity];
    }

    public void addEmployee(String fullname, String department, double salary) {
        if (this.counter < this.EMPLOYEES.length) {
            this.EMPLOYEES[counter++] = new Employee(fullname, department, salary);
            System.out.println("Сотрудник '" + this.EMPLOYEES[counter - 1].getFullname() + "' создан");
        } else {
            System.out.println("Книга сотрудников заполнена");
        }
    }

    public int getActualSize() {
        int actualSize = 0;
        for (Employee employee : EMPLOYEES) {
            if (employee.getFullname() != null) {
                actualSize++;
            }
        }
        return actualSize;
    }

    public void printBook() {
        for (Employee employee : EMPLOYEES) {
            System.out.println(employee);
        }
    }

    public double calculateTotalSalary() {
        double wageFund = 0;
        for (Employee employee : EMPLOYEES) {
            wageFund += employee.getSalary();
        }
        return wageFund;
    }

    public Employee minSalaryEmployee() {
        Employee minEmployeeSalary = null;

        for (Employee employee : EMPLOYEES) {
            if (minEmployeeSalary == null || employee.getSalary() < minEmployeeSalary.getSalary()) {
                minEmployeeSalary = employee;
            }
        }
        return minEmployeeSalary;
    }

    public Employee maxSalaryEmployee() {
        Employee maxEmployeeSalary = null;
        for (Employee employee : EMPLOYEES) {
            if (maxEmployeeSalary == null || employee.getSalary() > maxEmployeeSalary.getSalary()) {
                maxEmployeeSalary = employee;
            }
        }
        return maxEmployeeSalary;
    }

    public void printNames() {
        System.out.println();
        for (Employee employee : EMPLOYEES) {
            System.out.println(employee.getFullname());
        }
    }

    public void increaseSalary(double percentageIncrease) {
        for (Employee employee : EMPLOYEES) {
            employee.setSalary(employee.getSalary() * (1 + percentageIncrease / 100));
        }
    }

    public List<Employee> findEmployeeInDepartment(String department) {
        List<Employee> employeesInDepartment = new ArrayList<>();
        if (department != null) {
            for (Employee employee : EMPLOYEES) {
                if (employee.getDepartment().equals(department)) {
                    employeesInDepartment.add(employee);
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
            for (Employee employee : EMPLOYEES) {
                if (employee.getDepartment().equals(department) && (minSalaryEmployee == null || employee.getSalary() < minSalaryEmployee.getSalary())) {
                    minSalaryEmployee = employee;
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
            for (Employee employee : EMPLOYEES) {
                if (employee.getDepartment().equals(department) && (maxSalaryEmployee == null || employee.getSalary() > maxSalaryEmployee.getSalary())) {
                    maxSalaryEmployee = employee;
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
            for (Employee employee : EMPLOYEES) {
                if (employee.getDepartment().equals(department)) {
                    wageFund += employee.getSalary();
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
            for (Employee employee : EMPLOYEES) {
                if (employee.getDepartment().equals(department)) {
                    wageFund += employee.getSalary();
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
            for (Employee employee : EMPLOYEES) {
                if (employee.getDepartment().equals(department)) {
                    employee.setSalary(employee.getSalary() * (1 + percentageIncrease / 100));
                }
            }
            System.out.println("Индексация ЗП...");
        } else {
            System.out.println("Неверно задан отдел (increaseSalaryInDepartment)");
        }
    }

    public void printEmployeesInDepartment(String department) {
        if (department != null) {
            List<Employee> employeesInDepartment = findEmployeeInDepartment(department);
            for (Employee employee : employeesInDepartment) {
                System.out.println(employee.toString(true));
            }
        } else {
            System.out.println("Неверно задан отдел (printEmployeesInDepartment)");
        }
    }

    public Employee[] findEmployeesWithSalaryLessThan(double salaryCompared) {
        List<Employee> employeeWithSalaryLessThanCompared = new ArrayList<>();
        for (Employee employee : EMPLOYEES) {
            if (employee.getSalary() < salaryCompared) {
                employeeWithSalaryLessThanCompared.add(employee);
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
        for (Employee employee : EMPLOYEES) {
            if (employee.getSalary() >= salaryCompared) {
                employeeWithSalaryMoreThanCompared.add(employee);
            }
        }
        Employee[] employeeFound = new Employee[employeeWithSalaryMoreThanCompared.size()];
        for (int i = 0; i < employeeWithSalaryMoreThanCompared.size(); i++) {
            employeeFound[i] = employeeWithSalaryMoreThanCompared.get(i);
        }
        return employeeFound;
    }

}