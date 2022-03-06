package pro.sky.exceptions;

import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final Map<String, Employee> employeeList;

    public EmployeeServiceImpl() {
        employeeList = new HashMap<>();
    }

    @Override
    public Employee add(String firstName, String lastName) {
        String key = getKey(firstName, lastName);
        if (employeeList.containsKey(key)) {
            throw new EmployeeExistsException("Сотрудник уже есть в списке");
        }
        Employee newEmployee = new Employee(firstName, lastName);
        employeeList.put(key, newEmployee);
        return newEmployee;
    }

    @Override
    public Employee remove(String firstName, String lastName) {
        String key = getKey(firstName, lastName);
        if (employeeList.remove(key) == null) {
            throw new EmployeeNotFoundExceptiion("Сотрудника нет в списке");
        }
        Employee removedEmployee = new Employee(firstName, lastName);
        return removedEmployee;
    }

    @Override
    public Employee find(String firstName, String lastName) {
        String key = getKey(firstName, lastName);
        Employee employee = employeeList.get(key);
        if (employee == null) {
            throw new RuntimeException("Сотрудник не найден");
        }

        return employee;
    }

    @Override
    public Collection<Employee> getAll() {
        return Collections.unmodifiableCollection(employeeList.values());
    }

    private String getKey(String firstName, String lastName) {
        return firstName + " " + lastName;
    }
}
