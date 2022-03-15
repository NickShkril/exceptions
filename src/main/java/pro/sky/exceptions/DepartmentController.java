package pro.sky.exceptions;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping(path = "/max-salary")
    public Employee maxSalary(@RequestParam("department") int department) {
        return departmentService.employeeWithMaxSalary(department);
    }

    @GetMapping(path = "/min-salary")
    public Employee minSalary(@RequestParam("department") int department) {
        return departmentService.employeeWithMinSalary(department);
    }

    @GetMapping(path = "/all", params = "departmentId")
    public Collection<Employee> findEmployeesByDepartment(@RequestParam("departmentId") int department) {
        return departmentService.findEmployeesByDepartment(department);
    }

    @GetMapping(path = "/all")
    public Map<Integer, List<Employee>> findEmployeesByDepartment() {
        return departmentService.findAllEmployees();
    }
}



