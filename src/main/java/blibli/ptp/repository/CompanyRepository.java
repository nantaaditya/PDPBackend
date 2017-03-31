package blibli.ptp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import blibli.ptp.entity.Company;
@Repository
public interface CompanyRepository extends CrudRepository<Company, String>{

}
