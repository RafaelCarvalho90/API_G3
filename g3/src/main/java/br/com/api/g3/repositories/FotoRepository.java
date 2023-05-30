package br.com.api.g3.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.api.g3.domain.Foto;
import br.com.api.g3.domain.Produto;


public interface FotoRepository extends JpaRepository<Foto, Long> {

	Optional<Foto> findByProduto(Produto produto);

}
