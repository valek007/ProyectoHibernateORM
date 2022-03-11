package es.pildoras.pruebasHibernate;

import java.sql.Connection;
import java.sql.DriverManager;

public class PruebasJDBC {

	private static String pathJDBC = "jdbc:mysql://localhost:3306/pruebas_hibernate_orm?useSSL=false";
	private static String user = "root";
	private static String pass = "";

	@SuppressWarnings("unused")
	public static void main(String[] args) {

		try {
			
			System.out.println("Conectando con la Base de datos....");

			// 1. CREAR CONEXI�N
			Connection connection = DriverManager.getConnection(pathJDBC, user, pass);
			
			System.out.println("Conexi�n exitosa.\n");

		} catch (Exception e) {
			System.out.println("�Fallo con la conexion!");
			e.printStackTrace();
		}

	}
}
