package br.unifor.ads.DOCAL_core.entity;

import java.io.Serializable;

public class Usuario implements Serializable {

	private static final long serialVersionUID = 412425978108264680L;

	private Integer id;
	private String nome;
	private String login;
	private String senha;
	private Float altura;
	private Float peso;
	
	public Usuario() {}
	
	public Usuario(String nome, String login, String senha, Float altura, Float peso) {
		this.nome = nome;
		this.login = login;
		this.senha = senha;
		this.altura = altura;
		this.peso = peso;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Float getAltura() {
		return altura;
	}

	public void setAltura(Float altura) {
		this.altura = altura;
	}

	public Float getPeso() {
		return peso;
	}

	public void setPeso(Float peso) {
		this.peso = peso;
	}

}
