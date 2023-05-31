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

import br.com.api.g3.domain.Categoria;
import br.com.api.g3.services.CategoriaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import jakarta.mail.MessagingException;

@RestController
@RequestMapping("/categorias")
@SecurityScheme(
        name = "Bearer Auth",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        scheme = "bearer"
    )
public class CategoriaController {

	@Autowired
	CategoriaService categoriaService;

	@GetMapping("/listar")
	@SecurityRequirement(name="Bearer Auth")
	@PreAuthorize("hasRole('ADMIN')")
	public List<Categoria> listar() {
		return categoriaService.findAll();
	}

	@GetMapping("/{id}")
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
	public Categoria cadastrarCategoria(@RequestBody Categoria categoria) throws MessagingException {
		return categoriaService.cadastrarCategoria(categoria);
	}
	@PutMapping("/{id}")
	public Categoria atualizar(@PathVariable Long id, @RequestBody Categoria categoria) {
		return categoriaService.atualizarCategoria(categoria, id);
	}
	@DeleteMapping("/{id}")
	@SecurityRequirement(name="Bearer Auth")
	@PreAuthorize("hasRole('ADMIN')")
	@Operation( summary  = "Deletar Categoria - ADMIN", description = "Delete de categoria")
	public void deletarCategoria(@PathVariable Long id) {
		categoriaService.deletarCategoria(id);
	
	}
}
