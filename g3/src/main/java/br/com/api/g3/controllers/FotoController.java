package br.com.api.g3.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.api.g3.services.ProdutoService;

public class FotoController {
	
	@Autowired
	ProdutoService produtoService;
	
}
