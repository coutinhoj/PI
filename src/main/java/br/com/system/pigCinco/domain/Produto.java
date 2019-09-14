package br.com.system.pigCinco.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Produto implements Serializable {
	
	private static final long serialVersionUID = -7668058712997689811L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int produto_id;
	private String produto_descricao;
	private String produto_status;
	//chave estrangeira
	
	public int getProduto_id() {
		return produto_id;
	}
	public void setProduto_id(int produto_id) {
		this.produto_id = produto_id;
	}
	public String getProduto_descricao() {
		return produto_descricao;
	}
	public void setProduto_descricao(String produto_descricao) {
		this.produto_descricao = produto_descricao;
	}
	public String getProduto_status() {
		return produto_status;
	}
	public void setProduto_status(String produto_status) {
		this.produto_status = produto_status;
	}
	
	
	
	

}
