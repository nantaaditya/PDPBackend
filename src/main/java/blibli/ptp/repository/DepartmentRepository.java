package blibli.ptp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import blibli.ptp.entity.Department;

@Repository
public interface DepartmentRepository extends CrudRepository<Department, String>{

}
