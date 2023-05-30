package br.com.api.g3.enums;


public enum CategoriaEnum {
    CELULAR,
    VIDEOGAME,
    ELETRODOMESTICO,
    RELOGIO;

    private String tipo;



	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
 
}
