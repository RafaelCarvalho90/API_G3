package br.com.api.g3.security.dto;

import java.util.Set;

import jakarta.validation.constraints.*;

// reponsavel para criar um novo usuario, aqui é definido as roles

public class SignupRequestDTO {
	@NotBlank // não pode ficar em branco
	@Size(min = 3, max = 20) //define o tamanho da strign
	private String username;

	@NotBlank
	@Size(max = 50)
	@Email // anotação para validação de email
	private String email;

	private Set<String> role; 

	@NotBlank
	@Size(min = 6, max = 40)
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<String> getRole() {
		return this.role;
	}

	public void setRole(Set<String> role) {
		this.role = role;
	}
}