package agendacontatos;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Alterar {

	private FabricaConexao fabrica;
	
	public Alterar() throws SQLException {
		fabrica = FabricaConexao.getIntancia();
	}
	
	public void alterar(int id, String nome, String email, String dataNasc) throws SQLException {
		String sql = "UPDATE contatos set nome = ? "
				+ "  , email = ?, data_nasc = ?"
				+ "  WHERE id = ?";
		
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		PreparedStatement pst = fabrica.getConexao().prepareStatement(sql);
		pst.setString(1, nome);
		pst.setString(2, email);
		pst.setDate(3, Date.valueOf(LocalDate.parse(dataNasc, formato)));
		pst.setInt(4, id);
		pst.execute();
		pst.close();
	}
}
