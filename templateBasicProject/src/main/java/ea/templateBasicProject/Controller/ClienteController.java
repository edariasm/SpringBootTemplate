package ea.templateBasicProject.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ea.templateBasicProject.dao.ClienteDAO;
import ea.templateBasicProject.model.Cliente;

@RestController
@RequestMapping("/company")
public class ClienteController {
	
	@Autowired
	ClienteDAO clientedao;
	
	//Save an employee. We are connecting to postman with post
	
	@PostMapping("/clientes")
	public Cliente createCliente(@Valid @RequestBody Cliente cliente) {
		return clientedao.save(cliente);
	}
	
	
	//get all employees. We are connecting to postman with get
	@GetMapping("/clientes")
	public List<Cliente> getAllClientes() {
		return clientedao.findall();
	}
	
	//get employee by id
	
	@GetMapping("/clientes/{id}")
	public ResponseEntity<Cliente> getClienteById(@PathVariable(value = "id") int clienteid){
		Cliente cliente = clientedao.findone(clienteid);
		if(cliente==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(cliente);		
	}
	
	//update a client
	@PutMapping("/clientes/{id}")
	public ResponseEntity<Cliente> updateCliente(@PathVariable(value= "id") int clienteid, @Valid @RequestBody Cliente clienteDetails){
		
		Cliente cliente = clientedao.findone(clienteid);
		if(cliente==null) {
			return ResponseEntity.notFound().build();
		}

		cliente.setNombre(clienteDetails.getNombre());
		cliente.setApellido1(clienteDetails.getApellido1());
		cliente.setApellido2(clienteDetails.getApellido2());
		cliente.setDireccion(clienteDetails.getDireccion());
		cliente.setFechaNac(clienteDetails.getFechaNac());
		
		Cliente updateCliente = clientedao.save(cliente);
		return ResponseEntity.ok().body(updateCliente);		
	}
	
	//delete cliente
	@DeleteMapping("clientes/{id}")
	public ResponseEntity<Cliente> deleteCliente(@PathVariable(value = "{id}") int clienteid){
		
		Cliente cliente = clientedao.findone(clienteid);
		if(cliente==null) {
			return ResponseEntity.notFound().build();
		}

		clientedao.deleteCliete(cliente);
		return ResponseEntity.ok().build();
		
	}

}
