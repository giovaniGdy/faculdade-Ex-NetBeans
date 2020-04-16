package agendacontatos;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Excluir {

	private FabricaConexao fabrica;
	
	public Excluir() throws SQLException {
		fabrica = FabricaConexao.getIntancia();
	}
	
	public void executar() throws SQLException {
		int id;
		id = Integer.parseInt(
				JOptionPane.showInputDialog("Digite o ID para excluir:"));
		
		excluir(id);
	}
	
	public void excluir(int id) throws SQLException {
		String sql = "DELETE FROM contatos WHERE id = ?";
		
		PreparedStatement pst = fabrica.getConexao().prepareStatement(sql);
		pst.setInt(1, id);
		
		int n = pst.executeUpdate();
		if (n > 0) {
			JOptionPane.showMessageDialog(null, "Registro excluído!");
		}
		pst.close();
	}
}
