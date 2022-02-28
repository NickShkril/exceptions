package pro.sky.exceptions;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final List<Employee> employeeList;

    public EmployeeServiceImpl() {
        employeeList = new ArrayList<>();
    }

    @Override
    public Employee add(String firstName, String lastName) {
        Employee newEmployee = new Employee(firstName, lastName);
        return add(newEmployee);
    }

    @Override
    public Employee add(Employee employee) {
        if (!employeeList.add(employee)) {
            throw new EmployeeExistsException("Сотрудник добавлен");
        } else if (!employeeList.contains(employee)) {
            throw new EmployeeExistsException("Сотрудник уже добавлен");
        }
        return employee;
    }


    @Override
    public Employee remove(String firstName, String lastName) {
        Employee newEmployee = new Employee(firstName, lastName);
        return remove(newEmployee);
    }

    @Override
    public Employee remove(Employee employee) {
        if (!employeeList.remove(employee)) {
            throw new EmployeeNotFoundExceptiion("Сотрудник удален");
        }
        return employee;
    }


    @Override
    public Employee find(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (!employeeList.contains(employee)) {
            throw new RuntimeException("Сотрудник не найден");
        }
        return employee;
    }


    @Override
    public Collection<Employee> getAll() {
        return List.copyOf(employeeList);
    }
}
