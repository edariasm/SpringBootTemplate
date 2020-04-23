package ea.templateBasicProject.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ea.templateBasicProject.model.Cliente;
import ea.templateBasicProject.repository.ClienteRepository;

@Service
public class ClienteDAO {
	
	@Autowired
	ClienteRepository clienteRepo;
	
	//CRUD operations are part of JPA which Cliente extends
	
	/*Create or save Cliente */
	
	public Cliente save(Cliente cliente) {
		return clienteRepo.save(cliente);
		
	}
	

	/*Read all or find all Clientes */
	
	public List<Cliente> findall() {
		
		return clienteRepo.findAll();
	}
	
	/*Read one or find by ID Clientes */
	
	public Cliente findone(int clienteid) {
		
		return clienteRepo.findOne(clienteid);
	}
	
	
	/*Update Cliente */
	
	
	
	/*Delete Cliente */
	
	public void deleteCliete(Cliente cliente) {
		
		clienteRepo.delete(cliente);
	}
	
	
	
}
