package br.com.api.g3.exceptions;

import java.time.LocalDateTime;
import java.util.List;

public class ErroResposta {
    	
	private LocalDateTime dataHora;
	private List<MensagemErro> erros;
	
	public ErroResposta() {
	}
	public ErroResposta(LocalDateTime dataHora, List<MensagemErro> erros) {
		this.dataHora = dataHora;
		this.erros = erros;
	}
	
	public LocalDateTime getDataHora() {
		return dataHora;
	}
	public void setDataHora(LocalDateTime dataHora) {
		this.dataHora = dataHora;
	}


	public List<MensagemErro> getErros() {
		return erros;	
	}


	public void setErros(List<MensagemErro> erros) {
		this.erros = erros;
	}
	
}
