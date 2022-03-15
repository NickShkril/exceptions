package pro.sky.exceptions;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public abstract class EmployeeServiceImpl implements EmployeeService {
    private final Map<String, Employee> employeeList;

    public EmployeeServiceImpl() {
        employeeList = new HashMap<>();
        employeeList.put("one", new Employee("Petya","Petya"));
        employeeList.put("two", new Employee("Vasya","Vasya"));
        employeeList.put("three", new Employee("Sasha","Sasha"));

    }



    @Override
    public Employee add(String firstName, String lastName, int department, int salary) {
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
//
//    @Override
//    public Collection<Employee> getAll() {
//        return Collections.unmodifiableCollection(employeeList.values());
//    }
//
//    @Override
//    public Collection<Employee> max_salary(int department) {
//        Collection<Employee> values = employeeList.values();
//        values.stream()
//                .forEach(employee -> System.out.println(employee));
//        return values;
//
//    }


//
//    @Override
//    public Employee min_salary(String firstName, String lastName, int department, int salary) {
//        return null;
//    }
//
//    @Override
//    public Employee allInDep(String firstName, String lastName, int department, int salary) {
//        return null;
//    }
//
//    @Override
//    public Employee all(String firstName, String lastName, int department, int salary) {
//        return null;
//    }


    private String getKey(String firstName, String lastName) {
        return firstName + " " + lastName;
    }
}


























