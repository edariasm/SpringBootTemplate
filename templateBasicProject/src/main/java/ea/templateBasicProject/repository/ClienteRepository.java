package ea.templateBasicProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ea.templateBasicProject.model.Cliente;

public interface ClienteRepository extends JpaRepository <Cliente, Integer> {
	
	

}
