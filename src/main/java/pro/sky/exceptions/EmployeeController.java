package pro.sky.exceptions;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;


    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping(path = "/add")
    public String add(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        Employee result = employeeService.add(firstName, lastName);
        String message = "Сотрудник " + result.getFirstName() + " " + result.getLastName() + " Успешно создан.";
        return message;
    }


    @GetMapping(path = "/remove")
    public String remove(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        Employee result = employeeService.remove(firstName, lastName);
        String message = "Сотрудник " + result.getFirstName() + " " + result.getLastName() + " Успешно удален.";
        return message;
    }

    @GetMapping(path = "/find")
    public Employee find(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        return employeeService.find(firstName, lastName);
    }

    @GetMapping(path = "/all")
    public Collection<Employee> all() {
        return employeeService.getAll();
    }
}