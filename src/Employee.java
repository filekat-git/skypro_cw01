import java.util.Objects;

public class Employee {

    private String fullname;
    private String department;
    private int salary;
    private static int counter;
    private int id;

    public Employee(String fullname, String department, int salary) {
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

    public int getSalary() {
        return salary;
    }

    public int getId() {
        return id;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Сотрудник '" + fullname + " (id " + id + ")'" + ", отдел '" + department + "', зарплата " + salary;
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
