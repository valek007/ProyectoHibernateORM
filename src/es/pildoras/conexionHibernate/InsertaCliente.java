package es.pildoras.conexionHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class InsertaCliente {

	public static void main(String[] args) {

		// 1. CREAR SESSION FACTORY
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Cliente.class)
				.addAnnotatedClass(Pedido.class).addAnnotatedClass(DetallesCliente.class).buildSessionFactory();

		// 2. CREAR OBJETO SESSION
		Session session = factory.openSession();

		try {

			// 3. CREAR OBJETO CLIENTES
			Cliente cliente = new Cliente("Carmen", "Gutierrez", "Gran Vía");
			DetallesCliente detallesCliente = new DetallesCliente("www.ramirez.com","633234532","Bolsa");
			
			// Asociar los objetos
			cliente.setDetallesCliente(detallesCliente);

			// 4. EJECUTAR LA TRANSACCIÓN SQL:

			// Comenzar transacción
			session.beginTransaction();

			// Guardar objeto en BBDD
			session.save(cliente);

			// COMMIT
			session.getTransaction().commit();
			System.out.println("Registro insertado correctamente en BBDD");

			// 5. CERRAR SESSION
			session.close();

		} finally {
			// CERRAR FACTORIA
			factory.close();
		}

	}

}
