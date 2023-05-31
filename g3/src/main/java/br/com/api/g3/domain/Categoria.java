package br.com.api.g3.domain;

import br.com.api.g3.enums.CategoriaEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
@Entity
@Table(name="categoria")
public class Categoria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long categoriaId;
	
	@Column(name="cat_tx_nome")
	private String nome;
	
	@Enumerated(EnumType.STRING)
	@Column(name="cat_tx_string")
	private CategoriaEnum tipo;

	@ManyToOne
	@JoinColumn(name="fk_prod_cd_id")
	private Produto produtoRel;
	
	
	public Categoria() {
		
	}

	public Categoria(Long categoriaId, String nome, CategoriaEnum tipo) {
		super();
		this.categoriaId = categoriaId;
		this.nome = nome;
		this.tipo = tipo;
	}

	public Long getCategoriaId() {
		return categoriaId;
	}

	public void setCategoriaId(Long categoriaId) {
		this.categoriaId = categoriaId;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public CategoriaEnum getTipo() {
		return tipo;
	}

	public void setTipo(CategoriaEnum tipo) {
		this.tipo = tipo;
	}

	
//	public Object atualizarCategoria(Categoria categoria, Long id) {
//	
//		return null;
//	}
	
	
	
	
	
	
	
	
}
