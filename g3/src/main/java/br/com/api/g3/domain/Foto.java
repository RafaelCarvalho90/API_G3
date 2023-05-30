package br.com.api.g3.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToOne;

@Entity
public class Foto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "id_foto")
	private Long id;
	
	@Lob
	private byte[] dados;
	private String tipo;
	private String nome;
	
	
	@OneToOne
	@JoinColumn(name="prod_cd_id")
	private Produto produto;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public byte[] getDados() {
		return dados;
	}

	public void setDados(byte[] dados) {
		this.dados = dados;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	

	public Foto() {
		
	}

	public Foto(Long id, byte[] dados, String tipo, String nome, Produto produto) {
		super();
		this.id = id;
		this.dados = dados;
		this.tipo = tipo;
		this.nome = nome;
		this.produto = produto;
	}

	public void setProduto(Produto produto2) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
