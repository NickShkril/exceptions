package pro.sky.exceptions.imple;

import org.springframework.stereotype.Service;
import pro.sky.exceptions.Employee;
import pro.sky.exceptions.excep.EmployeeExistsException;
import pro.sky.exceptions.excep.EmployeeNotFoundExceptiion;
import pro.sky.exceptions.services.EmployeeService;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static org.apache.commons.lang3.StringUtils.isAlpha;
import static org.apache.commons.lang3.StringUtils.capitalize;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final Map<String, Employee> employeeList;

    public EmployeeServiceImpl() {
        employeeList = new HashMap<>();
        employeeList.put("one", new Employee("Petya", "Petya", 2, 222));
        employeeList.put("two", new Employee("Vasya", "Vasya", 2, 222));
        employeeList.put("three", new Employee("Sasha", "Sasha", 3, 333));
        employeeList.put("three", new Employee("Sasha", "Sasha", 3, 3333));
    }


    public Employee add(String firstName, String lastName, int department, int salary) {
        validateNames(firstName, lastName);
        Employee newEmployee = new Employee(
                capitalize(firstName),
                capitalize(lastName),
                department,
                salary
        );
        if (employeeList.containsKey(getKey(firstName, lastName))) {
            throw new EmployeeExistsException("Сотрудник уже есть в списке");
        }

        employeeList.put(getKey(firstName, lastName), newEmployee);
        return newEmployee;
    }

    private void validateNames(String... names) {
        for (String name : names) {
            if (!isAlpha(name)) {
                throw new EmployeeExistsException("Неправильное имя");
            }
        }
    }

    @Override
    public Employee remove(String firstName, String lastName) {
        return null;
    }


    public Employee remove(String firstName, String lastName, int department, int salary) {
        String key = getKey(firstName, lastName);
        if (employeeList.remove(key) == null) {
            throw new EmployeeNotFoundExceptiion("Сотрудника нет в списке");
        }
        Employee removedEmployee = new Employee(firstName, lastName, department, salary);
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
        return firstName + lastName;
    }
}


























