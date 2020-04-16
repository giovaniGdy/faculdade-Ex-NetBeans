package agendacontatos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class Listar {

	private FabricaConexao fabrica;
	
	public Listar() throws SQLException {
		fabrica = FabricaConexao.getIntancia();
	}
	
	public void executar() throws SQLException {
		String sql = "SELECT id, nome, email, data_nasc"
				+ "   FROM contatos"
				+ "   ORDER BY nome";
		
		String resultado = "";
		
		Statement st = fabrica.getConexao().createStatement();
		
		ResultSet rs = st.executeQuery(sql);
		
		while (rs.next()) {
			resultado += rs.getInt("id") + " - ";
			resultado += rs.getString("nome") + " - ";
			resultado += rs.getString("email") + " - ";
			resultado += rs.getString("data_nasc") + "\n";
		}
		
		rs.close();
		st.close();
		JOptionPane.showMessageDialog(null, resultado);
	}
}
