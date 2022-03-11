package es.pildoras.conexionHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EliminarCliente {

	public static void main(String[] args) {

		// 1. CREAR SESSION FACTORY
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Cliente.class)
				.addAnnotatedClass(DetallesCliente.class).buildSessionFactory();

		// 2. CREAR OBJETO SESSION
		Session session = factory.openSession();

		try {

			// 4. EJECUTAR LA TRANSACCIÓN SQL:

			// Comenzar transacción
			session.beginTransaction();

			Cliente cliente = session.get(Cliente.class, 4);

			if (cliente != null) {
				System.out.println("Voy a elminiar al cliente "+cliente.getNombre());
				session.delete(cliente);
			}

			// COMMIT
			session.getTransaction().commit();
			if (cliente != null)
				System.out.println("Registro eliminado correctamente en BBDD.");
			else
				System.out.println("Nada que eliminar.");
			
			// 5. CERRAR SESSION
			session.close();

		} finally {
			// CERRAR FACTORIA
			factory.close();
		}

	}

}
