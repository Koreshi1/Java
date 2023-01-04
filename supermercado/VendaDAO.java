package sa4.supermercado;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class VendaDAO {// Criarmos o CRUD referente à entidade Produto

	public void create(Venda venda) {
		Connection conexao = ConexaoMySQL.iniciarConexao(); // Abrir conexão com BD
		PreparedStatement stmt = null; // Cria um Statement
		try {
			stmt = conexao.prepareStatement("INSERT INTO venda (vlrTotal) VALUES (?)");
			stmt.setDouble(1, venda.getVlrTotal());
			stmt.executeUpdate(); // Executar o SQL no BD
		} catch (SQLException erro) {
			erro.printStackTrace();
		} finally {
			ConexaoMySQL.encerrarConexao(conexao, stmt);
		}
	}

	public ArrayList<Venda> read(){
		Connection conexao = ConexaoMySQL.iniciarConexao(); // Abrir conexão com BD
		PreparedStatement stmt = null; // Cria um Statement
		ResultSet rs = null; //Cria um ResultSet
		ArrayList<Venda> listavendas = new ArrayList<>(); //Cria uma ArrayList que vai armazenar o retorno do ResultSet
		
		try {
			stmt = conexao.prepareStatement("SELECT * FROM venda"); //SQL
			rs = stmt.executeQuery(); //Armazenar o retorno do SQL dentro do ResultSet
			while (rs.next()) {
				Venda venda = new Venda(); //Cria o objeto que irá compor o ArrayList
				venda.setId_venda(rs.getInt("id_venda"));
				venda.setVlrTotal(rs.getDouble("VlrTotal"));
				listavendas.add(venda);
			}
		} catch (SQLException erro){
			erro.printStackTrace();
		} finally {
			ConexaoMySQL.encerrarConexao(conexao, stmt, rs);
		}
		return listavendas;
	}
	
	public void update(Venda venda) {
		Connection conexao = ConexaoMySQL.iniciarConexao(); // Abrir conexão com BD
		PreparedStatement stmt = null; // Cria um Statement
		try {
			stmt = conexao.prepareStatement("UPDATE venda SET vlrTotal = ? WHERE id_venda = ?");
		
			stmt.setDouble(1, venda.getVlrTotal());
			stmt.setInt(2, venda.getId_venda());
			stmt.executeUpdate(); // Executar o SQL no BD
		} catch (SQLException erro) {
			erro.printStackTrace();
		} finally {
			ConexaoMySQL.encerrarConexao(conexao, stmt);
		}
	}
	
	public void delete(Venda venda) {
		Connection conexao = ConexaoMySQL.iniciarConexao(); // Abrir conexão com BD
		PreparedStatement stmt = null; // Cria um Statement
		try {
			stmt = conexao.prepareStatement("DELETE FROM venda WHERE id_venda = ?");
			stmt.setInt(1, venda.getId_venda());
			stmt.executeUpdate(); // Executar o SQL no BD
		} catch (SQLException erro) {
			erro.printStackTrace();
		} finally {
			ConexaoMySQL.encerrarConexao(conexao, stmt);
		}
	}
}