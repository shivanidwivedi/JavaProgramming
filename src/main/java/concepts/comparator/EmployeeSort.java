package concepts.comparator;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Objective: Sort employees in ascending salary order
 */
public class EmployeeSort {

    public static List<Employee> sortEmployeesBySalary(List<Employee> employees) {
         Collections.sort(employees, new EmployeeComparatorSalary());
         return employees;
    }

    /**
     * TODO: sort employee by name
     * @param employees
     * @return
     */
    public static List<Employee> sortEmployeeByName(List<Employee> employees) {
        return employees;
    }

    /**
     * TODO: sort employees by age
     * @param employees
     * @return
     */
    public static List<Employee> sortEmployeeByAge(List<Employee> employees) {
        return employees;
    }
}

class EmployeeComparatorSalary implements Comparator<Employee> {

    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.getSalary() - o2.getSalary();
    }
}
