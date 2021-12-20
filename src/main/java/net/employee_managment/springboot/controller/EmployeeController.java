package net.employee_managment.springboot.controller;

import net.employee_managment.springboot.model.Employee;
import net.employee_managment.springboot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	//	public EmployeeController(EmployeeService employeeService) {
	//		super();
	//		this.employeeService = employeeService;
	//	}


	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long id){
		return new ResponseEntity<Employee>(employeeService.getEmployeeById(id), HttpStatus.OK);
	}

	// build get all employees REST API
	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> getAllEmployees(){
		List<Employee> e = employeeService.getAllEmployees();
		////System.out.println(e.toString());
		return new ResponseEntity<List<Employee>>(e,HttpStatus.OK);
		//return e;
	}

	// build get employee by id REST API
	// http://localhost:8080/api/employees/1


	// build create employee REST API
	@PostMapping("/employees")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
		System.out.println(employee);
		System.out.println("employee");
		return new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.CREATED);

	}

//	@PostMapping()
//	public void addEmployees(@RequestBody Employee employee){
//		employeeService.addEmployees(employee);
//	}



	// build update employee REST API
	// http://localhost:8080/api/employees/1
	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long id
												  ,@RequestBody Employee employee){
		return new ResponseEntity<Employee>(employeeService.updateEmployee(employee, id), HttpStatus.CREATED);
	}

	// build delete employee REST API
	// http://localhost:8080/api/employees/1
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") long id){

		// delete employee from DB
		employeeService.deleteEmployee(id);

		return new ResponseEntity<String>("Employee deleted successfully!.", HttpStatus.NO_CONTENT);
	}
//	Link link = linkTo(methodOn(EmployeeController.class)
//			.getAllEmployees())
//			.withRel("employees");
//
//// Method 2
//
//	Method method = WebController.class.getMethod("getActorById", Long.class);
//	Link link = linkTo(method, 2L).withSelfRel();
	
}
