package br.com.api.g3.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.g3.domain.Endereco;
import br.com.api.g3.services.EnderecoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import jakarta.mail.MessagingException;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/enderecos")
@SecurityScheme(
        name = "Bearer Auth",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        scheme = "bearer"
    )
public class EnderecoController {
		
    @Autowired
	EnderecoService enderecoService;

	@GetMapping("/listar")
	@SecurityRequirement(name="Bearer Auth")
	@PreAuthorize("hasRole('ADMIN')")
	@Operation( summary  = "Lista todos os Endereço - ADMIN", description = "Listagem de endereços")
	@ApiResponses( value = {
			@ApiResponse(responseCode= "200", description="Retorna todos os endereços"),
			@ApiResponse(responseCode= "401", description="Erro de autenticacao")
	})
	public List<Endereco> listaEndereco() {
		return enderecoService.findAll();
	}

	@GetMapping("/{id}")
	@SecurityRequirement(name="Bearer Auth")
	@PreAuthorize("hasRole('ADMIN')")
	@Operation( summary  = "Lista de Endereços por Id - ADMIN", description = "Lista por Id")
	public ResponseEntity<Endereco> buscaEndereco(@PathVariable Long id){
		Optional <Endereco> opt = enderecoService.findById(id);
		if(opt.isPresent()) {
			return ResponseEntity.ok(opt.get());
		
		}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	@SecurityRequirement(name="Bearer Auth")
	@PreAuthorize("hasRole('ADMIN')")
	@Operation(summary  = "Cadastrar novo Endereço - ADMIN", description = "Cadastro de endereços")
	public Endereco adicionaEndereco(@Valid @RequestBody Endereco endereco) throws MessagingException {
		return enderecoService.adicionaEndereco(endereco);
	}
	
	@PutMapping("/{id}")
	@SecurityRequirement(name="Bearer Auth")
	@PreAuthorize("hasRole('ADMIN')")
	@Operation( summary  = "Atualizar os Endereços - ADMIN", description = "Atualização de endereços")
	public Endereco atualizaEndereco(@PathVariable Long id, @RequestBody Endereco endereco) {
		return enderecoService.alteraEndereco(id, endereco);
	}
	
	@DeleteMapping("/{id}")
	@SecurityRequirement(name="Bearer Auth")
	@PreAuthorize("hasRole('ADMIN')")
	@Operation( summary  = "Deletar Endereços - ADMIN", description = "Delete de endereços")
	public void deletaEndereco(@PathVariable Long id) {
		enderecoService.deletaEndereco(id);
	
	}

}
