package br.com.api.g3.domain;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="ped_cd_id", nullable=false, unique=true)
    private Long pedidoId;

//	@OneToMany(mappedBy="pedidoRel")
//	private List<Produto> produtos;

	@ManyToOne
	@JoinColumn(name="fk_cli_cd_id")
	private Cliente cliente;

	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "pedido_produto", joinColumns = @JoinColumn(name = "fk_ped_cd_id"), inverseJoinColumns = @JoinColumn(name = "fk_prod_cd_id"))
	private List<Produto> produtos;


	public Pedido(Long pedidoId) {
		this.pedidoId = pedidoId;
		this.produtos = new ArrayList<Produto>();
	}
	
	public Pedido() {
		this.produtos = new ArrayList<Produto>();
	}

	public Long getPedidoId() {
		return pedidoId;
	}

	public void setPedidoId(Long pedidoId ) {
		this.pedidoId = pedidoId;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	
	

    
}
