package es.pildoras.conexionHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class ObtenerPedidosCliente {

	public static void main(String[] args) {

		// 1. CREAR SESSION FACTORY
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Cliente.class)
				.addAnnotatedClass(Pedido.class).addAnnotatedClass(DetallesCliente.class).buildSessionFactory();

		// 2. CREAR OBJETO SESSION
		Session session = factory.openSession();

		try {

			// 3. EJECUTAR LA TRANSACCIÓN SQL:

			// Comenzar transacción
			session.beginTransaction();
			
			//Obtener el Cliente de la tabla Clientes de la BBDD
//			Cliente cliente=session.get(Cliente.class, 7);
			
			Query<Cliente> consulta =session.createQuery("SELECT CL FROM Cliente CL JOIN FETCH CL.pedidos WHERE CL.id=:clienteId", Cliente.class);
			consulta.setParameter("clienteId", 7);
			
			Cliente cliente=consulta.getSingleResult();
			
			System.out.println("Cliente: "+cliente);
			
			
			// COMMIT
			session.getTransaction().commit();

			session.close();
			System.out.println("Pedidos: "+cliente.getPedidos());

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//4. CERRAR FACTORIA y SESSION
			session.close();
			factory.close();
		}

	}

}
