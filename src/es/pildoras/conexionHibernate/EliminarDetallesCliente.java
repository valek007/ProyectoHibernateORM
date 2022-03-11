package es.pildoras.conexionHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EliminarDetallesCliente {

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

			DetallesCliente detallesCliente = session.get(DetallesCliente.class, 7);

			if (detallesCliente != null) {
				System.out.println("Voy a elminiar al detalles Cliente ");
				session.delete(detallesCliente);
			}

			// COMMIT
			session.getTransaction().commit();
			if (detallesCliente != null)
				System.out.println("Registro eliminado correctamente en BBDD.");
			else
				System.out.println("Nada que eliminar.");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// CERRAR FACTORIA y SESSION
			session.close();
			factory.close();
		}

	}

}
