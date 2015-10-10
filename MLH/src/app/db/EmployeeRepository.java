package app.db;

import org.springframework.boot.json.JsonParser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	Employee save(Employee employee);
}
