package pro.sky.exceptions;

import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final Employee[] employees;
    private int size;

    public EmployeeServiceImpl() {
        employees = new Employee[10];
    }

    @Override
    public Employee add(String firstName, String lastName) {
        Employee newEmployee = new Employee(firstName, lastName);
        return add(newEmployee);
    }

    @Override
    public Employee add(Employee employee) {
        if (size == employees.length) {
            throw new EmployeeBookOverflowException("Книга переполнна");
        }
        int index = indexOf(employee);
        if (index != -1) {
            throw new EmployeeExistsException("Сотрудник уже существует");
        }
        employees[size++] = employee;
        return employee;
    }


    @Override
    public Employee remove(String firstName, String lastName) {
        Employee newEmployee = new Employee(firstName, lastName);
        return remove(newEmployee);
    }

    @Override
    public Employee remove(Employee employee) {
        int index = indexOf(employee);

        if (index != -1) {
            Employee result = employees[index];
            System.arraycopy(employees, index + 1, employees, index, size - index);
            size--;
            return result;
        }
        throw new EmployeeNotFoundExceptiion("Сотрудник не найден");
    }

    @Override
    public Employee find(String firstName, String lastName) {
        Employee newEmployee = new Employee(firstName, lastName);
        int index = indexOf(newEmployee);

        if (index != -1) {
            return employees[index];
        }
        throw new EmployeeNotFoundExceptiion("Сотрудник не найден");
    }

    private int indexOf(Employee employee) {
        for (int i = 0; i < size; i++) {
            if (employees[i].equals(employee)) {
                return i;
            }
        }
        return -1;
    }
}
