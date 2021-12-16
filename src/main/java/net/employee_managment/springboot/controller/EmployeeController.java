package net.employee_managment.springboot.controller;

import java.util.List;

import net.employee_managment.springboot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.employee_managment.springboot.model.Employee;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

//	public EmployeeController(EmployeeService employeeService) {
//		super();
//		this.employeeService = employeeService;
//	}
	
	// build create employee REST API
	    @PostMapping("/employees")
		public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
			System.out.println(employee);
			return new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.CREATED);

		}

	//	@PostMapping()
	//	public void addEmployees(@RequestBody Employee employee){
	//		employeeService.addEmployees(employee);
	//	}

		// build get all employees REST API
		@GetMapping("/employees")
		public List<Employee> getAllEmployees(){
			List<Employee> e = employeeService.getAllEmployees();
			System.out.println(e.toString());
			return e;
		}

		// build get employee by id REST API
		// http://localhost:8080/api/employees/1
		@GetMapping("/employees/{id}")
		public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long id){
			return new ResponseEntity<Employee>(employeeService.getEmployeeById(id), HttpStatus.OK);
		}

		// build update employee REST API
		// http://localhost:8080/api/employees/1
		@PutMapping("/employees/{id}")
		public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long id
													  ,@RequestBody Employee employee){
			return new ResponseEntity<Employee>(employeeService.updateEmployee(employee, id), HttpStatus.OK);
		}

		// build delete employee REST API
		// http://localhost:8080/api/employees/1
		@DeleteMapping("/employees/{id}")
		public ResponseEntity<String> deleteEmployee(@PathVariable("id") long id){

			// delete employee from DB
			employeeService.deleteEmployee(id);

			return new ResponseEntity<String>("Employee deleted successfully!.", HttpStatus.OK);
		}
	
}
