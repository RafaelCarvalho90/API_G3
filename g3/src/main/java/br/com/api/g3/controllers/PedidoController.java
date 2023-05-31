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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.g3.domain.Pedido;
import br.com.api.g3.dto.PedidoDTO;
import br.com.api.g3.services.PedidoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import jakarta.mail.MessagingException;

@RestController
@RequestMapping("/pedidos")
@SecurityScheme(
        name = "Bearer Auth",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        scheme = "bearer"
    )
public class PedidoController {
	
	@Autowired
	PedidoService pedidoService;

    @GetMapping("/listar")
	@SecurityRequirement(name="Bearer Auth")
	@PreAuthorize("hasRole('USER')")
	@Operation( summary  = "Lista todos os Pedidos - USER", description = "Listagem de pedidos")
	@ApiResponses( value = {
			@ApiResponse(responseCode= "200", description="Retorna todos os pedidos"),
			@ApiResponse(responseCode= "401", description="Erro de autenticacao")
	})
	public Object listar() {
		return pedidoService.findAll();
	}

	@GetMapping("/{id}")
	@SecurityRequirement(name="Bearer Auth")
	@PreAuthorize("hasRole('USER')")
	@Operation( summary  = "Lista de pedidos por Id - USER", description = "Lista pedidos Id")
	public ResponseEntity<Pedido> procurarId(@PathVariable Long id){
		Optional <Pedido> opt = pedidoService.findById(id);
		if(opt.isPresent()) {
			return ResponseEntity.ok(opt.get());
		
		}
		return ResponseEntity.notFound().build();
	}

	
	@PostMapping
	@SecurityRequirement(name="Bearer Auth")
	@PreAuthorize("hasRole('USER')")
	@Operation( summary  = "Cadastrar novo Pedido - USER", description = "Cadastro de pedidos")
	public Object cadastrarPedido(@RequestBody PedidoDTO pedidoDTO) throws MessagingException {
		return pedidoService.cadastrarPedido(pedidoDTO);
	}
	

	@PutMapping("/{id}")
	@SecurityRequirement(name="Bearer Auth")
	@PreAuthorize("hasRole('USER')")
	@Operation( summary  = "Atualizar  Pedido - USER", description = "Atualização de pedidos")
	public ResponseEntity<Object> atualizarPedido(@RequestBody Pedido pedido, @PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(pedidoService.atualizarPedido(pedido, id));
	}

	@DeleteMapping("/{id}")
	@SecurityRequirement(name="Bearer Auth")
	@PreAuthorize("hasRole('USER')")
	@Operation( summary  = "Deletar Pedido - USER", description = "Delete de pedidos")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		pedidoService.deleteById(id);
		return ResponseEntity.status(HttpStatus.OK).build();
	}


}
