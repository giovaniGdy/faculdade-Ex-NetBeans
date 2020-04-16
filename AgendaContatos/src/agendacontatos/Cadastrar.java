package agendacontatos;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Cadastrar {

	private FabricaConexao fabrica;
	
	public Cadastrar() throws SQLException {
		fabrica = FabricaConexao.getIntancia();
	}
	
	public void inserir(String nome, String email, String dtNasc) throws SQLException {
		String sql = "INSERT INTO contatos (nome, email, data_nasc) "
					+ " VALUES (?, ?, ?);";
		
		PreparedStatement pst = fabrica.getConexao().prepareStatement(sql);
		pst.setString(1, nome);
		pst.setString(2, email);
		
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		pst.setDate(3, Date.valueOf(LocalDate.parse(dtNasc, formato)));
		
		pst.execute();
		pst.close();
	}
}