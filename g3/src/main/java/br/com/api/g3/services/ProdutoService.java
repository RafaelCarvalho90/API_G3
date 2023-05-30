package br.com.api.g3.services;

import java.io.IOException;
import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.api.g3.domain.Produto;
import br.com.api.g3.repositories.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	ProdutoRepository produtoRepository;
	@Autowired
	private FotoService fotoService;
	
	public Produto adcionarImagemUri(Produto produto) {
		URI uri = ServletUriComponentsBuilder
				.fromCurrentContextPath()
				.path("produtos/{id}/foto")
				.buildAndExpand(produto.getProdutoId())
				.toUri();
		Produto prod = new Produto();
		prod.setNome(produto.getNome());
		prod.setDescricao(produto.getDescricao());
		prod.setValor(produto.getValor());
		prod.setUrl(uri.toString());
		return prod;
		
	}
	
	public Produto buscar(Long Id) {
		Optional<Produto> produto = produtoRepository.findById(Id);
		
		return adcionarImagemUri(produto.get());
		
	}
	
	public Produto inserir(Produto produto, MultipartFile file) throws IOException {
		produto = produtoRepository.save(produto);
		fotoService.inserir(produto, file);
		return adcionarImagemUri(produto);
		}

	public List<Produto> findAll(){
        return produtoRepository.findAll();
    }


    public Optional <Produto> findById(Long id){
        return produtoRepository.findById(id);

    }

    public Produto cadastrarProduto(Produto produto) {

           return produtoRepository.save(produto);
        }


    public Produto atualizarProduto(Produto produtoAtualizado, Long id) {
        Optional<Produto> opt = produtoRepository.findById(id);
        if(opt.isPresent()) {
            Produto produtoAntigo = opt.get();
            produtoAntigo.setNome(produtoAtualizado.getNome());
            produtoAntigo.setDescricao(produtoAtualizado.getDescricao());
            produtoAntigo.setValor(produtoAtualizado.getValor());
            produtoRepository.save(produtoAntigo);
        }
        return null;
    }

    public void deleteById(Long id) {
    	produtoRepository.deleteById(id);

        }
    }
