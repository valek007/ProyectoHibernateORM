package es.pildoras.conexionHibernate;

import java.util.GregorianCalendar;

import javax.persistence.*;

@Entity
@Table(name = "Pedido")
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;
	@Column(name = "FECHA")
	private GregorianCalendar fecha;
	@Column(name = "FORMA_PAGO")
	private String formaPago;
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
	@JoinColumn(name = "CLIENTE_ID")
	private Cliente cliente;

	// ----------CONSTRUCTORS----------------------------

	public Pedido() {
	}

	public Pedido(GregorianCalendar fecha) {
		this.fecha = fecha;
	}

	// ------------GETTER & SETTERS------------------------

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public GregorianCalendar getFecha() {
		return fecha;
	}

	public void setFecha(GregorianCalendar fecha) {
		this.fecha = fecha;
	}

	public String getFormaPago() {
		return formaPago;
	}

	public void setFormaPago(String formaPago) {
		this.formaPago = formaPago;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	// ------------OVERRIDE METHODS ------------------------

	@Override
	public String toString() {
		return "Pedido [fecha=" + fecha + ", formaPago=" + formaPago + ", cliente=" + cliente + "]";
	}

}
