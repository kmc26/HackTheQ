package app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import app.db.Employee;
import app.db.EmployeeRepository;

@Controller
public class MyController {
	@Autowired
	private EmployeeRepository repo;
	
	@RequestMapping("/")
	@ResponseBody
	public long helloWorld() {
		return repo.count();
	}
	
	@RequestMapping("/test")
	@ResponseBody
	public void addNewEmployee(@RequestParam(value="name") String firstName, @RequestParam(value="lastName") String lastname, 
			@RequestParam(value="desc") String desc) {
		repo.save(new Employee(firstName, lastname, desc));
	}
}
