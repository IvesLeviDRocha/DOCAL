package br.unifor.ads.DOCAL_core.entity;

import java.io.Serializable;
import java.util.Vector;

public class Refeicao implements Serializable {

	private static final long serialVersionUID = -6520562816881021020L;

	private Integer id;
	private Usuario usuario_id;
	private String nome;
	private Float carboidratos;
	private Float proteinas;
	private Float gorduras;

	public Refeicao() {
	}

	public Refeicao(Usuario usuario_id, String nome, Float carboidratos,
			Float proteinas, Float gorduras) {
		this.usuario_id = usuario_id;
		this.nome = nome.toLowerCase();
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

	public Vector<String> getRowData() {
		Vector<String> vector = new Vector<String>();
		vector.add(nome);
		vector.add(carboidratos + "g");
		vector.add(proteinas + "g");
		vector.add(gorduras + "g");
		return vector;
	}

}
