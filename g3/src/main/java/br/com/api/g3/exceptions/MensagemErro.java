package br.com.api.g3.exceptions;

public class MensagemErro {
    private String atributo;
	private String mensagem;
	
	
	
	public MensagemErro() {
		
	}
	
	public MensagemErro(String atributo, String mensagem) {
		
		this.atributo = atributo;
		this.mensagem = mensagem;
	}
	public String getAtributo() {
		return atributo;
	}
	public void setAtributo(String atributo) {
		this.atributo = atributo;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
}
