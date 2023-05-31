package br.com.api.g3.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.g3.security.domain.Role;
import br.com.api.g3.security.repositories.RoleRepository;

@Service
public class RoleService {
	@Autowired
	RoleRepository roleRepository;
	
	// metodo usado para salvar a regra do usuario no banco de dados
	public Role save(Role role) {
		return roleRepository.save(role);
	}
}
