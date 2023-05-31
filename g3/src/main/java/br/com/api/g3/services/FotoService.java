package br.com.api.g3.services;

import java.io.IOException;
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
	
	public Foto inserir(Produto produto,MultipartFile file) throws IOException {
		
		
		Foto fotoproduto= new Foto();
		fotoproduto.setDados(file.getBytes()); // não encontra o getBytes
		fotoproduto.setTipo(file.getContentType());
		fotoproduto.setNome(file.getName());
		fotoproduto.setProduto(produto);		
		return  fotoRepository.save(fotoproduto);
		
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
