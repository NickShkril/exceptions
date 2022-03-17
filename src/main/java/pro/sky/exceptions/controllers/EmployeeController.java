package pro.sky.exceptions.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.exceptions.Employee;
import pro.sky.exceptions.services.EmployeeService;


@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping(path = "/add")
    public Employee add(@RequestParam("firstName") String firstName,
                        @RequestParam("lastName") String lastName,
                        @RequestParam("department") int department,
                        @RequestParam("salary") int salary) {
        return employeeService.add(firstName, lastName, department, salary);

    }


    @GetMapping(path = "/remove")
    public Employee remove(@RequestParam("firstName") String firstName,
                           @RequestParam("lastName") String lastName) {
        return employeeService.remove(firstName, lastName);
    }

    @GetMapping(path = "/find")
    public Employee find(@RequestParam("firstName") String firstName,
                         @RequestParam("lastName") String lastName) {
        return employeeService.find(firstName, lastName);
    }

//    @GetMapping(path = "/all")
//    public Collection<Employee> all() {
//        return employeeService.getAll();
//    }
}

//    @GetMapping(path = "/max-salary")
//    public String maxSalary(@RequestParam("firstName") String firstName,
//                            @RequestParam("lastName") String lastName,
//                            @RequestParam("department") int department,
//                            @RequestParam("salary") int salary) {
//        Employee result = employeeService.max_salary(firstName, lastName, department, salary);
//        String message = "Сотрудник с наибеольшей зарплатой " + result.getFirstName() + " " + result.getLastName() + " в отделе под номером " + result.getDepartment();
//        return message;
//    }
//
//    @GetMapping(path = "/min-salary")
//    public String minSalary(@RequestParam("firstName") String firstName,
//                            @RequestParam("lastName") String lastName,
//                            @RequestParam("department") int department,
//                            @RequestParam("salary") int salary) {
//        Employee result = employeeService.add(firstName, lastName, department, salary);
//        String message = "Сотрудник с наименьшей зарплатой " + result.getFirstName() + " " + result.getLastName() + " в отделе под номером " + result.getDepartment();
//        return message;
//    }
//
//    @GetMapping(path = "/allInDep")
//    public String allInDep(@RequestParam("firstName") String firstName,
//                           @RequestParam("lastName") String lastName,
//                           @RequestParam("department") int department,
//                           @RequestParam("salary") int salary) {
//        Employee result = employeeService.add(firstName, lastName, department, salary);
//        String message = "Сотрудники отдела " + result.getDepartment() + ": " + result.getFirstName() + " " + result.getLastName();
//        return message;
//    }

//    @GetMapping(path = "/pizda")
//    public String all(@RequestParam("firstName") String firstName,
//                      @RequestParam("lastName") String lastName,
//                      @RequestParam("department") int department,
//                      @RequestParam("salary") int salary) {
//        Employee result = employeeService.add(firstName, lastName, department, salary);
//        String message = "Сотрудники отдела " + result.getDepartment() + ": " + result.getFirstName() + " " + result.getLastName();
//        return message;
//    }


