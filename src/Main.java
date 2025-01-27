public class Main {

    public static void main(String[] args) {

        Employee[] employees = new Employee[10];
        employees[0] = new Employee("Столярчук Юлия Владимировна", "4", 65000);
        employees[1] = new Employee("Косткин Андрей Александрович", "1", 280000);
        employees[2] = new Employee("Кузьмин Михаил Евгеньевич", "3", 80000);
        employees[3] = new Employee("Шестакова Светлана Анатольевна", "2", 140000);
        employees[4] = new Employee("Анисимова Нина Михайловна", "5", 50000);
        employees[5] = new Employee("Бакунин Максим Дмитреевич", "2", 100000);
        employees[6] = new Employee("Блохин Андрей Иванович", "3", 90000);
        employees[7] = new Employee("Соболькова Светлана Николаевна", "4", 60000);
        employees[8] = new Employee("Зайцева Марина Александровна", "5", 52300);
        employees[9] = new Employee("Карсаков Владимир Иванович", "5", 51000);

        System.out.println(printEmployees(employees));
        int wageFund = countDefenses(employees);
        System.out.println("Сумма затрат на ЗП в месяц = " + wageFund);
        System.out.println("Сотрудник с минимальной ЗП = " + minSalaryEmployee(employees));
        System.out.println("Сотрудник с максимальной ЗП = " + maxSalaryEmployee(employees));
        int middleSalary = employees.length == 0 ? 0 : wageFund / employees.length;
        System.out.println("Среднее значение зарплат = " + middleSalary);
        printNames(employees);

    }

    public static String printEmployees(Employee[] employeesToPrint) {
        StringBuilder sb = new StringBuilder();
        for (Employee employee : employeesToPrint) {
            sb.append(employee.toString()).append("\n");
        }
        return sb.toString();
    }

    public static int countDefenses(Employee[] employees) {
        int wageFund = 0;
        for (Employee employee : employees) {
            wageFund += employee.getSalary();
        }
        return wageFund;
    }

    public static String minSalaryEmployee(Employee[] employees) {
        int minSalary = Integer.MAX_VALUE;
        int indexOfEmployee = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getSalary() < minSalary) {
                minSalary = employees[i].getSalary();
                indexOfEmployee = i;
            }
        }
        return employees[indexOfEmployee].getFullname();
    }

    public static String maxSalaryEmployee(Employee[] employees) {
        int maxSalary = Integer.MIN_VALUE;
        int indexOfEmployee = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getSalary() > maxSalary) {
                maxSalary = employees[i].getSalary();
                indexOfEmployee = i;
            }
        }
        return employees[indexOfEmployee].getFullname();
    }

    public static void printNames(Employee[] employees) {
        System.out.println();
        for (Employee employee : employees) {
            System.out.println(employee.getFullname());
        }
    }
}