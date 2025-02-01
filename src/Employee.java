import java.util.Objects;

public class Employee {

    private String fullname;
    private String department;
    private double salary;
    private static int counter;
    private final int id;

    public Employee(String fullname, String department, double salary) {
        this.fullname = fullname;
        this.department = department;
        this.salary = salary;
        this.id = ++counter;
    }

    public String getFullname() {
        return fullname;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public int getId() {
        return id;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Сотрудник '" + fullname + " (id " + id + ")'" + ", отдел '" + department + "', зарплата " + String.format("%.2f", salary);
    }

    public String toString(boolean exceptDepartment) {
        if (exceptDepartment) {
            return "Сотрудник '" + fullname + " (id " + id + ")'" + ", зарплата " + String.format("%.2f", salary);
        } else {
            return this.toString();
        }

    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id && Objects.equals(fullname, employee.fullname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullname, id);
    }
}
