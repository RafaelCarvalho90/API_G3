package br.com.api.g3.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.g3.domain.Pedido;
import br.com.api.g3.repositories.PedidoRepository;

@Service
public class PedidoService {
    @Autowired
	PedidoRepository pedidoRepository;

	public List<Pedido> findAll(){
        return pedidoRepository.findAll();
    }


    public Optional <Pedido> findById(Long id){
        return pedidoRepository.findById(id);

    }

    public Pedido cadastrarPedido(Pedido pedido) {

           return pedidoRepository.save(pedido);
        }


    public Pedido atualizarPedido(Pedido pedidoAtualizado, Long id) {
        Optional<Pedido> opt = pedidoRepository.findById(id);
        if(opt.isPresent()) {
            Pedido pedidoAntigo = opt.get();
            pedidoAntigo.setProdutos(pedidoAtualizado.getProdutos());
            pedidoAntigo.setCliente(pedidoAtualizado.getCliente());
            pedidoRepository.save(pedidoAntigo);
        }
        return null;
    }

    public void deleteById(Long id) {
    	pedidoRepository.deleteById(id);

        }
    }

