package blibli.ptp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import blibli.ptp.entity.Accessibility;

@Repository
public interface AccessibilityRepository extends JpaRepository<Accessibility, String>{

}
