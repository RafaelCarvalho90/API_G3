package br.com.api.g3.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.g3.domain.Cliente;
import br.com.api.g3.domain.Pedido;
import br.com.api.g3.domain.Produto;
import br.com.api.g3.dto.PedidoDTO;
import br.com.api.g3.repositories.ClienteRepository;
import br.com.api.g3.repositories.PedidoRepository;
import br.com.api.g3.repositories.ProdutoRepository;

@Service
public class PedidoService {
    @Autowired
	PedidoRepository pedidoRepository;
    
    @Autowired
    ClienteService clienteService;
    
    @Autowired
    ProdutoService produtoService;

    @Autowired
    ProdutoRepository produtoRepository;
    
    @Autowired
    ClienteRepository clienteRepository;
    
	public List<Pedido> findAll(){
        return pedidoRepository.findAll();
    }


    public Optional <Pedido> findById(Long id){
        return pedidoRepository.findById(id);

    }

    public Pedido cadastrarPedido(PedidoDTO pedidoDTO) {
    		Pedido pedido = new Pedido();
    		Optional<Cliente> cliente = clienteRepository.findById(pedidoDTO.getClienteId());
    		List<Produto> produtos = produtoRepository.findAllById(pedidoDTO.getProdutoId());
    		pedido.setProdutos(produtos);
    		pedido.setCliente(cliente.get());
    	
    		
           return pedidoRepository.save(pedido);
        }	


    public Pedido atualizarPedido(Pedido pedidoAtualizado, Long id) {
        Optional<Pedido> opt = pedidoRepository.findById(id);
        if(opt.isPresent()) {
            Pedido pedidoAntigo = opt.get();
            pedidoAntigo.setProdutos(pedidoAtualizado.getProdutos());
            //pedidoAntigo.setCliente(pedidoAtualizado.getCliente());
            pedidoRepository.save(pedidoAntigo);
        }
        return null;
    }

    public void deleteById(Long id) {
    	pedidoRepository.deleteById(id);

       }

    }

