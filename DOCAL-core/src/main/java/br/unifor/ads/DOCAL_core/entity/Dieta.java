package br.unifor.ads.DOCAL_core.entity;

import java.io.Serializable;

public class Dieta implements Serializable {

	private static final long serialVersionUID = -3956463124025421223L;

	private Integer id;
	private Usuario usuario_id;
	private String nome;
	private Float carboidratos;
	private Float proteinas;
	private Float gorduras;

	public Dieta() {
	}

	public Dieta(Usuario usuario_id, String nome, Float carboidratos,
			Float proteinas, Float gorduras) {
		this.usuario_id = usuario_id;
		this.nome = nome;
		this.carboidratos = carboidratos;
		this.proteinas = proteinas;
		this.gorduras = gorduras;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Usuario getUsuario_id() {
		return usuario_id;
	}

	public void setUsuario_id(Usuario usuario_id) {
		this.usuario_id = usuario_id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Float getCarboidratos() {
		return carboidratos;
	}

	public void setCarboidratos(Float carboidratos) {
		this.carboidratos = carboidratos;
	}

	public Float getProteinas() {
		return proteinas;
	}

	public void setProteinas(Float proteinas) {
		this.proteinas = proteinas;
	}

	public Float getGorduras() {
		return gorduras;
	}

	public void setGorduras(Float gorduras) {
		this.gorduras = gorduras;
	}

	public Float getCalorias() {
		Float calorias = carboidratos * 4 + proteinas * 4 + gorduras * 9;
		return calorias;
	}

}
