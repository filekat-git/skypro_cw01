public class Main {

    private static final Employee[] EMPLOYEES = new Employee[10];

    public static void main(String[] args) {

        EMPLOYEES[0] = new Employee("Столярчук Юлия Владимировна", "4", 65000);
        EMPLOYEES[1] = new Employee("Косткин Андрей Александрович", "1", 280000);
        EMPLOYEES[2] = new Employee("Кузьмин Михаил Евгеньевич", "3", 80000);
        EMPLOYEES[3] = new Employee("Шестакова Светлана Анатольевна", "2", 140000);
        EMPLOYEES[4] = new Employee("Анисимова Нина Михайловна", "5", 50000);
        EMPLOYEES[5] = new Employee("Бакунин Максим Дмитреевич", "2", 100000);
        EMPLOYEES[6] = new Employee("Блохин Андрей Иванович", "3", 90000);
        EMPLOYEES[7] = new Employee("Соболькова Светлана Николаевна", "4", 60000);
        EMPLOYEES[8] = new Employee("Зайцева Марина Александровна", "5", 52300);
        EMPLOYEES[9] = new Employee("Карсаков Владимир Иванович", "5", 51000);

        printEmployees();
        double wageFund = calculateTotalSalary();
        System.out.println("Сумма затрат на ЗП в месяц = " + String.format("%.2f", wageFund));
        System.out.println("Сотрудник с минимальной ЗП = " + minSalaryEmployee());
        System.out.println("Сотрудник с максимальной ЗП = " + maxSalaryEmployee());
        double middleSalary = EMPLOYEES.length == 0 ? 0 : wageFund / EMPLOYEES.length;
        System.out.println("Среднее значение зарплат = " + String.format("%.2f", middleSalary));
        printNames();

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
}