package es.pildoras.conexionHibernate;

import java.util.GregorianCalendar;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CrearPedidosCliente {

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
			Cliente cliente=session.get(Cliente.class, 8);
			
			//Crear Pedidos del Cliente
			Pedido pedido1 = new Pedido(new GregorianCalendar(2022,6,4));
			Pedido pedido2 = new Pedido(new GregorianCalendar(2022,5,3));
			Pedido pedido3 = new Pedido(new GregorianCalendar(2022,7,2));
			
			//agregar Pedidos creados al Cliente creado
			cliente.agregarPedidos(pedido1);
			cliente.agregarPedidos(pedido2);
			cliente.agregarPedidos(pedido3);
			
			//Guardar los Pedidos en la BBDD en la tabla Pedido
			session.save(pedido1);
			session.save(pedido2);
			session.save(pedido3);
			
			// COMMIT
			session.getTransaction().commit();
			System.out.println("Registros insertados correctamente en BBDD");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//4. CERRAR FACTORIA y SESSION
			session.close();
			factory.close();
		}

	}

}
