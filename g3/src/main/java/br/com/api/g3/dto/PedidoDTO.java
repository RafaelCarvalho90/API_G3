package br.com.api.g3.dto;

import java.util.List;

public class PedidoDTO {
	
	
	private List<Long> produtoId;
	
	private Long clienteId;

	public PedidoDTO(List<Long> produtoId, Long clienteId) {
		
		this.produtoId = produtoId;
		this.clienteId = clienteId;
	}
	
	public PedidoDTO() {
		
		
	}

	public List<Long> getProdutoId() {
		return produtoId;
	}

	public void setProdutoId(List<Long> produtoId) {
		this.produtoId = produtoId;
	}

	public Long getClienteId() {
		return clienteId;
	}

	public void setClienteId(Long clienteId) {
		this.clienteId = clienteId;
	}
	
	
}
