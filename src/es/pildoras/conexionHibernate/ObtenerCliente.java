package es.pildoras.conexionHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ObtenerCliente {

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

			// Obtener detalles cliente

			DetallesCliente detallesCliente = session.get(DetallesCliente.class, 1);

			System.out.println(detallesCliente);
			System.out.println(detallesCliente.getCliente());

			// COMMIT
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// CERRAR FACTORIA y SESSION
			session.close();
			factory.close();
		}

	}

}
