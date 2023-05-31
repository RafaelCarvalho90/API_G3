package br.com.api.g3.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="foto")
public class Foto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "foto_cd_id")
	private Long id;
	
	@Lob
	@Column(name="foto_bl_dados")
	private byte[] dados;
	
	@Column(name="foto_tx_tipo")
	private String tipo;
	
	@Column(name="foto_tx_nome")
	private String nome;
	
	@OneToOne
	@JoinColumn(name = "fk_cli_cd_id")
	private Cliente cliente;
	
	@OneToOne
	@JoinColumn(name="fk_prod_cd_id")
	private Produto produto;
	
	@OneToOne
	@JoinColumn(name = "fk_func_cd_id")
	private Funcionario funcionario;
	

	public Foto() {
	
	}
	public Foto(Long id, byte[] dados, String tipo, String nome, Cliente cliente, Produto produto,
			Funcionario funcionario) {
		
		this.id = id;
		this.dados = dados;
		this.tipo = tipo;
		this.nome = nome;
		this.cliente = cliente;
		this.produto = produto;
		this.funcionario = funcionario;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Funcionario getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
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



	public Produto getProduto() {
		return produto;
	}



	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	

	
	
	
}
