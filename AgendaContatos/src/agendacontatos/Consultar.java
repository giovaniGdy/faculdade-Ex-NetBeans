package agendacontatos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import modelo.Contato;

public class Consultar {

	private FabricaConexao fabrica;
	
	public Consultar() throws SQLException {
		fabrica = FabricaConexao.getIntancia();
	}
        
        public Contato consultar(int id) throws SQLException {
            String sql = "SELECT id, nome, email, data_nasc FROM contatos "
                    + " WHERE id = ?";
            
            PreparedStatement pst = fabrica.getConexao().prepareStatement(sql);
            pst.setInt(1, id);
            
            ResultSet rs = pst.executeQuery();
            
            Contato contato = new Contato();
            
            if (rs.next()) {
                contato.setId(rs.getInt("id"));
                contato.setNome(rs.getString("nome"));
                contato.setEmail(rs.getString("email"));
             
                LocalDate dtnasc = Instant.ofEpochMilli(rs.getDate("data_nasc").getTime())
                    .atZone(ZoneId.systemDefault()).toLocalDate();
                    
                contato.setDataNasc(dtnasc);
            }
            
            return contato;

        }
	
	public List<Contato> consultar(String nome) throws SQLException {
		String sql = "SELECT id, nome, email, data_nasc FROM contatos "
				+  " WHERE nome LIKE ?";
		
		PreparedStatement pst = fabrica.getConexao().prepareStatement(sql);
		pst.setString(1, "%" + nome + "%");
		
		ResultSet rs = pst.executeQuery();
		
		List<Contato> lista = new ArrayList<>();
		
		while (rs.next()) {
                    Contato contato = new Contato();
                    contato.setId(rs.getInt("id"));
                    contato.setNome(rs.getString("nome"));
                    contato.setEmail(rs.getString("email"));
                    
                    LocalDate dtnasc = Instant.ofEpochMilli(rs.getDate("data_nasc").getTime())
                            .atZone(ZoneId.systemDefault()).toLocalDate();
                    
                    contato.setDataNasc(dtnasc);
                    
                    lista.add(contato);
  
		}
		

		rs.close();
		pst.close();
                
                return lista;
        
		
	}
}
