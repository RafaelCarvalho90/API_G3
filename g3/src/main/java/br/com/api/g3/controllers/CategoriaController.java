package br.com.api.g3.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.g3.domain.Categoria;
import br.com.api.g3.services.CategoriaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.mail.MessagingException;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

@Autowired
CategoriaService categoriaService;

@GetMapping("/listar")
	@SecurityRequirement(name="Bearer Auth")
	@PreAuthorize("hasRole('ADMIN')")
	@Operation( summary  = "Lista todos as Categorias - ADMIN", description = "Listagem de categorias")
	@ApiResponses( value = {
			@ApiResponse(responseCode= "200", description="Retorna todos os clientes"),
			@ApiResponse(responseCode= "401", description="Erro de autenticacao")
	})
	public Object listar() {
		return categoriaService.findAll();
	}

	@GetMapping("/{id}")
	@SecurityRequirement(name="Bearer Auth")
	@PreAuthorize("hasRole('ADMIN')")
	@Operation( summary  = "Lista de Categorias por Id - ADMIN", description = "Lista categorias Id")
	public ResponseEntity<Categoria> procurarId(@PathVariable Long id){
		Optional <Categoria> opt = categoriaService.findById(id);
		if(opt.isPresent()) {
			return ResponseEntity.ok(opt.get());
		
		}
		return ResponseEntity.notFound().build();
	}

	
	@PostMapping
	@SecurityRequirement(name="Bearer Auth")
	@PreAuthorize("hasRole('ADMIN')")
	@Operation( summary  = "Cadastrar nova categoria - ADMIN", description = "Cadastro de categorias")
	public Object cadastrarCategoria(@RequestParam String email, @RequestBody Categoria categoria) throws MessagingException {
		return categoriaService.cadastrarCategoria(categoria);
	}
	

	@PutMapping("/{id}")
	@SecurityRequirement(name="Bearer Auth")
	@PreAuthorize("hasRole('ADMIN')")
	@Operation( summary  = "Atualizar  Categoria - ADMIN", description = "Atualização de categorias")
	public ResponseEntity<Object> atualizarCategoria(@RequestBody Categoria categoria, @PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(categoria.atualizarCategoria(categoria, id));
	}

	@DeleteMapping("/{id}")
	@SecurityRequirement(name="Bearer Auth")
	@PreAuthorize("hasRole('ADMIN')")
	@Operation( summary  = "Deletar Categoria - ADMIN", description = "Delete de categorias")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		categoriaService.deleteById(id);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

}
