package br.com.api.g3.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.g3.services.ProdutoService;
@RestController
@RequestMapping("/fotos")
public class FotoController {
	
	@Autowired
	ProdutoService produtoService;
	
	
	
}
