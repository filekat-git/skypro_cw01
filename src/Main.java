import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final Employee[] EMPLOYEES = new Employee[10];

    public static void main(String[] args) {

        EMPLOYEES[0] = new Employee("Столярчук Юлия Владимировна", "4", 65000);
        EMPLOYEES[1] = new Employee("Косткин Андрей Александрович", "1", 280000);
        EMPLOYEES[2] = new Employee("Кузьмин Михаил Евгеньевич", "3", 80000);
        EMPLOYEES[3] = new Employee("Шестакова Светлана Анатольевна", "2", 140000);
        EMPLOYEES[4] = new Employee("Анисимова Нина Михайловна", "5", 50000);
        EMPLOYEES[5] = new Employee("Бакунин Максим Дмитриевич", "2", 100000);
        EMPLOYEES[6] = new Employee("Блохин Андрей Иванович", "3", 90000);
        EMPLOYEES[7] = new Employee("Соболькова Светлана Николаевна", "4", 60000);
        EMPLOYEES[8] = new Employee("Зайцева Марина Александровна", "5", 52300);
        EMPLOYEES[9] = new Employee("Карсаков Владимир Иванович", "5", 51000);

        printEmployees();
        double wageFund = calculateTotalSalary();
        System.out.println();
        System.out.println("Сумма затрат на ЗП в месяц = " + String.format("%.2f", wageFund));
        System.out.println();
        System.out.println("Сотрудник с минимальной ЗП = " + minSalaryEmployee());
        System.out.println();
        System.out.println("Сотрудник с максимальной ЗП = " + maxSalaryEmployee());
        double middleSalary = EMPLOYEES.length == 0 ? 0 : wageFund / EMPLOYEES.length;
        System.out.println();
        System.out.println("Среднее значение зарплат = " + String.format("%.2f", middleSalary));
        printNames();
        System.out.println();
        System.out.println("Повышенная сложность");
        System.out.println();
        System.out.println("Индексация ЗП...");
        increaseSalary(10);
        printEmployees();
        System.out.println();
        System.out.println("Сотрудник с минимальной ЗП в выбранном отделе = " + findEmployeeWithMinSalaryInDepartment("5"));
        System.out.println();
        System.out.println("Сотрудник с максимальной ЗП в выбранном отделе = " + findEmployeeWithMaxSalaryInDepartment("5"));
        System.out.println();
        System.out.println("Сумма затрат на ЗП в месяц в выбранном отделе = " + String.format("%.2f", calculateTotalSalaryInDepartment("5")));
        System.out.println();
        System.out.println("Среднее значение зарплат в выбранном отделе " + String.format("%.2f", calculateMiddleSalaryInDepartment("5")));
        System.out.println();
        increaseSalaryInDepartment("5", 10);
        printEmployeesInDepartment("5");
        System.out.println();
        System.out.println("Все сотрудники с актуальными ЗП (после всех индексаций)");
        printEmployees();
        Employee[] employeeFound;
        double salaryCompared = 63283;
        employeeFound = findEmployeesWithSalaryLessThan(salaryCompared);
        System.out.println();
        System.out.println("Сотрудники с ЗП меньше, чем " + salaryCompared);
        for (Employee employee : employeeFound) {
            System.out.println(employee.toString(true));
        }
        employeeFound = findEmployeesWithSalaryMoreThan(salaryCompared);
        System.out.println();
        System.out.println("Сотрудники с ЗП больше или равной " + salaryCompared);
        for (Employee employee : employeeFound) {
            System.out.println(employee.toString(true));
        }

    }

    public static void printEmployees() {
        for (Employee employee : EMPLOYEES) {
            System.out.println(employee);
        }
    }

    public static double calculateTotalSalary() {
        double wageFund = 0;
        for (Employee employee : EMPLOYEES) {
            wageFund += employee.getSalary();
        }
        return wageFund;
    }

    public static Employee minSalaryEmployee() {
        Employee minEmployeeSalary = null;

        for (Employee employee : EMPLOYEES) {
            if (minEmployeeSalary == null || employee.getSalary() < minEmployeeSalary.getSalary()) {
                minEmployeeSalary = employee;
            }
        }
        return minEmployeeSalary;
    }

    public static Employee maxSalaryEmployee() {
        Employee maxEmployeeSalary = null;
        for (Employee employee : EMPLOYEES) {
            if (maxEmployeeSalary == null || employee.getSalary() > maxEmployeeSalary.getSalary()) {
                maxEmployeeSalary = employee;
            }
        }
        return maxEmployeeSalary;
    }

    public static void printNames() {
        System.out.println();
        for (Employee employee : EMPLOYEES) {
            System.out.println(employee.getFullname());
        }
    }

    public static void increaseSalary(double percentageIncrease) {
        for (Employee employee : EMPLOYEES) {
            employee.setSalary(employee.getSalary() * (1 + percentageIncrease / 100));
        }
    }

    public static List<Employee> findEmployeeInDepartment(String department) {
        List<Employee> employeesInDepartment = new ArrayList<>();
        for (Employee employee : EMPLOYEES) {
            if (employee.getDepartment().equals(department)) {
                employeesInDepartment.add(employee);
            }
        }
        return employeesInDepartment;
    }

    public static Employee findEmployeeWithMinSalaryInDepartment(String department) {
        Employee minSalaryEmployee = null;
        for (Employee employee : EMPLOYEES) {
            if (employee.getDepartment().equals(department) && (minSalaryEmployee == null || employee.getSalary() < minSalaryEmployee.getSalary())) {
                minSalaryEmployee = employee;
            }
        }
        return minSalaryEmployee;
    }

    public static Employee findEmployeeWithMaxSalaryInDepartment(String department) {
        Employee maxSalaryEmployee = null;
        for (Employee employee : EMPLOYEES) {
            if (employee.getDepartment().equals(department) && (maxSalaryEmployee == null || employee.getSalary() > maxSalaryEmployee.getSalary())) {
                maxSalaryEmployee = employee;
            }
        }
        return maxSalaryEmployee;
    }

    public static double calculateTotalSalaryInDepartment(String department) {
        double wageFund = 0;
        for (Employee employee : EMPLOYEES) {
            if (employee.getDepartment().equals(department)) {
                wageFund += employee.getSalary();
            }
        }
        return wageFund;
    }

    public static double calculateMiddleSalaryInDepartment(String department) {
        double wageFund = 0;
        int numberOfEmployees = 0;
        for (Employee employee : EMPLOYEES) {
            if (employee.getDepartment().equals(department)) {
                wageFund += employee.getSalary();
                numberOfEmployees++;
            }

        }
        return numberOfEmployees == 0 ? 0 : wageFund / numberOfEmployees;
    }

    public static void increaseSalaryInDepartment(String department, double percentageIncrease) {
        for (Employee employee : EMPLOYEES) {
            if (employee.getDepartment().equals(department)) {
                employee.setSalary(employee.getSalary() * (1 + percentageIncrease / 100));
            }
        }
        System.out.println("Индексация ЗП...");
    }

    public static void printEmployeesInDepartment(String department) {
        List<Employee> employeesInDepartment = findEmployeeInDepartment(department);
        for (Employee employee : employeesInDepartment) {
            System.out.println(employee.toString(true));
        }
    }

    public static Employee[] findEmployeesWithSalaryLessThan(double salaryCompared) {
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

    public static Employee[] findEmployeesWithSalaryMoreThan(double salaryCompared) {
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