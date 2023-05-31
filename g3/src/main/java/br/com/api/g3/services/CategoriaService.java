package br.com.api.g3.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.g3.domain.Categoria;
import br.com.api.g3.repositories.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	CategoriaRepository categoriaRepository;
	
	public List<Categoria> findAll(){ 
	return categoriaRepository.findAll();// repository do JPA .getContent 
}
	

	public Optional <Categoria> findById(Long id){
	return categoriaRepository.findById(id);
	
}

	public Categoria cadastrarCategoria(Categoria categoria) {
		Categoria categoriaB = new Categoria();
		categoriaB.setTipo(categoria.getTipo());
		categoriaB.setNome(categoria.getNome());
	return categoriaRepository.save(categoria);
}

	public Categoria atualizarCategoria(Categoria categoriaAtualizado, Long id) {
		Optional<Categoria> opt = categoriaRepository.findById(id);
		if(opt.isPresent()) {
			Categoria categoriaAntiga = opt.get();
			categoriaAntiga.setTipo(categoriaAtualizado.getTipo());
			categoriaAntiga.setNome(categoriaAtualizado.getNome());
			
			categoriaRepository.save(categoriaAntiga);
		}
		return null;
	}
	 public void deletarCategoria(Long id) {
	    	categoriaRepository.deleteById(id);

	 }
}
