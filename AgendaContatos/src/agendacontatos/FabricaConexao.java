package agendacontatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaConexao {
	
	private static FabricaConexao instancia;

	private String usuario = "root";
	private String senha = ""; //coloquem root
	private String url = "jdbc:mysql://localhost:3306/LTPII";
	
	private Connection conn;
	
	private FabricaConexao() throws SQLException {
		conn = DriverManager.getConnection(url, usuario, senha);
	}
	
	public static FabricaConexao getIntancia() throws SQLException { 
		if (instancia == null) {
			instancia = new FabricaConexao();
		}
		
		return instancia;
	}
	
	public Connection getConexao() {
		return conn;
	}
}