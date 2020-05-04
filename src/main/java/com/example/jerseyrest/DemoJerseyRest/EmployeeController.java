package com.example.jerseyrest.DemoJerseyRest;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("Employees")
public class EmployeeController {

	private EmployeeRepository repo = new EmployeeRepository();
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<Employee> getEmployee() {
		
		
		return repo.getEmployees();
	}
	
	@GET
	@Path("Employee/{id}")
	@Produces(MediaType.APPLICATION_XML)
	
	public Employee getEmployeeByID(@PathParam("id") int id ) {
		Employee emp = repo.getEmployee(id);
		System.out.println(emp);
		return emp;
	}
	
	@POST
	@Path("Employee")
	public Employee createEmployee(Employee emp1) {
		
		repo.addEmployee(emp1);
		System.out.println(emp1);
		return emp1;
	}
	
	@PUT
	@Path("Employee")
	public Employee updateEmployee(Employee emp1) {
		if ( repo.getEmployee(emp1.getId()).getId() == 0 ) {
			repo.addEmployee(emp1);
		} else {
			repo.updateEmployee(emp1);
		}
		
		System.out.println(emp1);
		return emp1;
	}
	
	@DELETE
	@Path("Employee/{id}")
	public Employee deleteEmployee(@PathParam("id") int id ) {
		Employee emp = repo.getEmployee(id);
		
		if(emp.getId() != 0)
			repo.deleteEmployee(id);
		
		return emp;
	}
	
}
