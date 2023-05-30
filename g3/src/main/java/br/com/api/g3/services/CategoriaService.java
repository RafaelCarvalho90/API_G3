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
        return categoriaRepository.findAll();
    }


    public Optional <Categoria> findById(Long id){
        return categoriaRepository.findById(id);

    }

    public Categoria cadastrarCategoria(Categoria categoria) {

           return categoriaRepository.save(categoria);
        }


    public Categoria atualizarCategoria(Categoria categoriaAtualizada, Long id) {
        Optional<Categoria> opt = categoriaRepository.findById(id);
        if(opt.isPresent()) {
            Categoria categoriaAntiga = opt.get();
            categoriaAntiga.setNome(categoriaAtualizada.getNome());
            categoriaAntiga.setDescricao(categoriaAtualizada.getDescricao());
            categoriaRepository.save(categoriaAntiga);
        }
        return null;
    }

    public void deleteById(Long id) {
    	categoriaRepository.deleteById(id);

        }
}
