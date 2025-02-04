public class Main {

    public static void main(String[] args) {

        int capacity = 10;
        EmployeeBook empBook = new EmployeeBook(capacity);
        if (empBook.addEmployee("Столярчук Юлия Владимировна", "4", 65000)) {
            System.out.println("Добавлен новый сотрудник");
        } else {
            System.out.println("Нет места для добавления нового сотрудника");
        }
        if (empBook.addEmployee("Косткин Андрей Александрович", "1", 280000)) {
            System.out.println("Добавлен новый сотрудник");
        } else {
            System.out.println("Нет места для добавления нового сотрудника");
        }
        if (empBook.addEmployee("Кузьмин Михаил Евгеньевич", "3", 80000)) {
            System.out.println("Добавлен новый сотрудник");
        } else {
            System.out.println("Нет места для добавления нового сотрудника");
        }
        if (empBook.addEmployee("Шестакова Светлана Анатольевна", "2", 140000)) {
            System.out.println("Добавлен новый сотрудник");
        } else {
            System.out.println("Нет места для добавления нового сотрудника");
        }
        if (empBook.addEmployee("Анисимова Нина Михайловна", "5", 50000)) {
            System.out.println("Добавлен новый сотрудник");
        } else {
            System.out.println("Нет места для добавления нового сотрудника");
        }
        if (empBook.addEmployee("Бакунин Максим Дмитриевич", "2", 100000)) {
            System.out.println("Добавлен новый сотрудник");
        } else {
            System.out.println("Нет места для добавления нового сотрудника");
        }
        if (empBook.addEmployee("Блохин Андрей Иванович", "3", 90000)) {
            System.out.println("Добавлен новый сотрудник");
        } else {
            System.out.println("Нет места для добавления нового сотрудника");
        }
        if (empBook.addEmployee("Соболькова Светлана Николаевна", "4", 60000)) {
            System.out.println("Добавлен новый сотрудник");
        } else {
            System.out.println("Нет места для добавления нового сотрудника");
        }
        if (empBook.addEmployee("Зайцева Марина Александровна", "5", 52300)) {
            System.out.println("Добавлен новый сотрудник");
        } else {
            System.out.println("Нет места для добавления нового сотрудника");
        }
        if (empBook.addEmployee("Карсаков Владимир Иванович", "5", 51000)) {
            System.out.println("Добавлен новый сотрудник");
        } else {
            System.out.println("Нет места для добавления нового сотрудника");
        }

        System.out.println();
        if (empBook.removeEmployee(4)) {
            System.out.println("Сотрудник удален");
        } else {
            System.out.println("Сотрудник с указанным id не найден");
        }
        if (empBook.removeEmployee(8)) {
            System.out.println("Сотрудник удален");
        } else {
            System.out.println("Сотрудник с указанным id не найден");
        }
        if (empBook.removeEmployee(5)) {
            System.out.println("Сотрудник удален");
        } else {
            System.out.println("Сотрудник с указанным id не найден");
        }

        System.out.println();
        empBook.printBook();

        System.out.println();
        if (empBook.addEmployee("Копейкина Мария Сергеевна", "2", 135000)) {
            System.out.println("Добавлен новый сотрудник");
        } else {
            System.out.println("Нет места для добавления нового сотрудника");
        }

        System.out.println();
        empBook.printBook();

        double wageFund = empBook.calculateTotalSalary();
        int actualSize = empBook.getActualSize();
        double middleSalary = actualSize == 0 ? 0 : wageFund / actualSize;
        double salaryCompared = 63283;
        Employee[] employeesFound;
        Employee employeeFound;

        System.out.println();
        empBook.printBook();

        System.out.println();
        System.out.println("Сумма затрат на ЗП в месяц = " + String.format("%.2f", wageFund));

        System.out.println();
        System.out.println("Сотрудник с минимальной ЗП = " + empBook.minSalaryEmployee());
        System.out.println();
        System.out.println("Сотрудник с максимальной ЗП = " + empBook.maxSalaryEmployee());

        System.out.println();
        System.out.println("Среднее значение зарплат = " + String.format("%.2f", middleSalary));
        empBook.printNames();
        System.out.println();
        System.out.println("Индексация ЗП...");
        empBook.increaseSalary(10);
        empBook.printBook();
        System.out.println();
        Employee employeeWithMinSalaryInDepartment = empBook.findEmployeeWithMinSalaryInDepartment(null);
        if (employeeWithMinSalaryInDepartment != null) {
            System.out.println("Сотрудник с минимальной ЗП в выбранном отделе = " + employeeWithMinSalaryInDepartment);
            System.out.println();
        }
        Employee employeeWithMaxSalaryInDepartment = empBook.findEmployeeWithMaxSalaryInDepartment("5");
        if (employeeWithMaxSalaryInDepartment != null) {
            System.out.println("Сотрудник с максимальной ЗП в выбранном отделе = " + employeeWithMaxSalaryInDepartment);
            System.out.println();
        }
        System.out.println("Сумма затрат на ЗП в месяц в выбранном отделе = " + String.format("%.2f", empBook.calculateTotalSalaryInDepartment("5")));
        System.out.println();
        System.out.println("Среднее значение зарплат в выбранном отделе " + String.format("%.2f", empBook.calculateMiddleSalaryInDepartment("5")));
        System.out.println();
        empBook.increaseSalaryInDepartment("5", 10);
        System.out.println();
        empBook.printEmployeesInDepartment("5");
        System.out.println();
        System.out.println("Все сотрудники с актуальными ЗП (после всех индексаций)");
        empBook.printBook();

        employeesFound = empBook.findEmployeesWithSalaryLessThan(salaryCompared);
        System.out.println();
        System.out.println("Сотрудники с ЗП меньше, чем " + salaryCompared);
        for (Employee employee : employeesFound) {
            System.out.println(employee.toString(true));
        }
        employeesFound = empBook.findEmployeesWithSalaryMoreThan(salaryCompared);
        System.out.println();
        System.out.println("Сотрудники с ЗП больше или равной " + salaryCompared);
        for (Employee employee : employeesFound) {
            System.out.println(employee.toString(true));
        }

        System.out.println();
        employeeFound = empBook.findEmployeeByID(12);
        if (employeeFound != null) {
            System.out.println(employeeFound);
        } else {
            System.out.println("Сотрудник не найден");
        }

        System.out.println();
        System.out.println("Еще можно добавить сотрудников: " + (capacity - empBook.getActualSize()));

    }

}
