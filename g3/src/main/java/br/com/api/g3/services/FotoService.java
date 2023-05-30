package br.com.api.g3.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.com.api.g3.domain.Foto;
import br.com.api.g3.domain.Produto;
import br.com.api.g3.repositories.FotoRepository;

import jakarta.transaction.Transactional;

@Service
public class FotoService {
	@Autowired
	FotoRepository fotoRepository;
	
	public Foto inserir(Produto produto,MultipartFile file) {
		
		Foto foto= new Foto();
		foto.setNome(file.getName());
		foto.setTipo(file.getContentType());
		//foto.setDados(file.getBytes()); // não encontra o getBytes
		foto.setProduto(produto);		
		return  fotoRepository.save(foto);
		
	}
	
	@Transactional
	public Foto buscarPorIdFuncionario(Long id) {
		Produto produto = new Produto();
		produto.setProdutoId(id);
		Optional<Foto> foto = fotoRepository.findByProduto(produto);
		if (!foto.isPresent()) {
			return null;
		}
		return foto.get();

	}
	
	
	
	
	
	
	
	
	
	
}
