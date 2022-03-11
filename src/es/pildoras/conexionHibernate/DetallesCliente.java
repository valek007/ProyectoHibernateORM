package es.pildoras.conexionHibernate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "detalles_cliente")
public class DetallesCliente {

	// ----------------------FIELDS----------------------------------------
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "web")
	private String web;
	@Column(name = "telf")
	private String telf;
	@Column(name = "comentario")
	private String comentario;
	
	@OneToOne(mappedBy = "detallesCliente", cascade = CascadeType.ALL)
	private Cliente cliente;


	// --------------------CONSTRUCTORS---------------------------------------
	public DetallesCliente() {
	}

	public DetallesCliente(String web, String telf, String comentario) {
		this.web = web;
		this.telf = telf;
		this.comentario = comentario;
	}

	// -------------------GETTERS & SETTERS------------------------------------

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getWeb() {
		return web;
	}

	public void setWeb(String web) {
		this.web = web;
	}

	public String getTelf() {
		return telf;
	}

	public void setTelf(String telf) {
		this.telf = telf;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	// ------------------OVERRIDE METHODS-----------------------------------------

	@Override
	public String toString() {
		return "DetallesCliente [id=" + id + ", web=" + web + ", telf=" + telf + ", comentario=" + comentario
				+ ", cliente=" + cliente + "]";
	}
	
	

}
