package concepts.comparator;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * TODO: complete the remaining tests
 */
public class EmployeeSortTest {

    @Test
    public void sortEmployeesBySalary() {
        Assert.assertEquals("Employee{salary=500, age=28, name='Manmeet'}",
                EmployeeSort.sortEmployeesBySalary(getEmployees()).get(0).toString());
        Assert.assertEquals("Employee{salary=5000, age=40, name='Roku'}",
                EmployeeSort.sortEmployeesBySalary(getEmployees()).get(3).toString());
    }


    @Test
    public void sortEmployeeByName() {
        Assert.assertEquals("Employee{salary=2000, age=31, name='Gagan'}",
                EmployeeSort.sortEmployeeByName(getEmployees()).get(0).toString());
        Assert.assertEquals("Employee{salary=1000, age=27, name='Shivani'}",
                EmployeeSort.sortEmployeeByName(getEmployees()).get(3).toString());
    }


    @Test
    public void sortEmployeeByAge() {
        Assert.assertEquals("Employee{salary=1000, age=27, name='Shivani'}",
                EmployeeSort.sortEmployeeByAge(getEmployees()).get(0).toString());
        Assert.assertEquals("Employee{salary=5000, age=40, name='Roku'}",
                EmployeeSort.sortEmployeeByAge(getEmployees()).get(3).toString());
    }


    private List<Employee> getEmployees() {
        Employee e1 = new Employee(1000, 27, "Shivani");
        Employee e2 = new Employee(2000, 31, "Gagan");
        Employee e3 = new Employee(500, 28, "Manmeet");
        Employee e4 = new Employee(5000, 40, "Roku");
        List<Employee> employees = new ArrayList();
        employees.add(e1);
        employees.add(e2);
        employees.add(e3);
        employees.add(e4);
        return employees;
    }
}