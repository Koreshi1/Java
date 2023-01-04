package sa4.supermercado;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PagamentoDAO {// Criarmos o CRUD referente à entidade Produto

	public void create(Pagamento pagamento) {
		Connection conexao = ConexaoMySQL.iniciarConexao(); // Abrir conexão com BD
		PreparedStatement stmt = null; // Cria um Statement
		try {
			stmt = conexao.prepareStatement("INSERT INTO pagamento (tipoPagamento) VALUES (?)");
			stmt.setDouble(1, pagamento.getTipoPagamento());
			stmt.executeUpdate(); // Executar o SQL no BD
		} catch (SQLException erro) {
			erro.printStackTrace();
		} finally {
			ConexaoMySQL.encerrarConexao(conexao, stmt);
		}
	}

	public ArrayList<Pagamento> read(){
		Connection conexao = ConexaoMySQL.iniciarConexao(); // Abrir conexão com BD
		PreparedStatement stmt = null; // Cria um Statement
		ResultSet rs = null; //Cria um ResultSet
		ArrayList<Pagamento> listapagamentos = new ArrayList<>(); //Cria uma ArrayList que vai armazenar o retorno do ResultSet
		
		try {
			stmt = conexao.prepareStatement("SELECT * FROM pagamento"); //SQL
			rs = stmt.executeQuery(); //Armazenar o retorno do SQL dentro do ResultSet
			while (rs.next()) {
				Pagamento pagamento = new Pagamento(); //Cria o objeto que irá compor o ArrayList
				pagamento.setId_pagamento(rs.getInt("id_pagamento"));
				pagamento.setTipoPagamento(rs.getInt("tipoPagamento"));
				listapagamentos.add(pagamento);
			}
		} catch (SQLException erro){
			erro.printStackTrace();
		} finally {
			ConexaoMySQL.encerrarConexao(conexao, stmt, rs);
		}
		return listapagamentos;
	}
	
	public void update(Pagamento pagamento) {
		Connection conexao = ConexaoMySQL.iniciarConexao(); // Abrir conexão com BD
		PreparedStatement stmt = null; // Cria um Statement
		try {
			stmt = conexao.prepareStatement("UPDATE pagamento SET tipoPagamento = ? WHERE id_pagamento = ?");
		
			stmt.setInt(1, pagamento.getTipoPagamento());
			stmt.setInt(2, pagamento.getId_venda());
			stmt.executeUpdate(); // Executar o SQL no BD
		} catch (SQLException erro) {
			erro.printStackTrace();
		} finally {
			ConexaoMySQL.encerrarConexao(conexao, stmt);
		}
	}
	
	public void delete(Pagamento pagamento) {
		Connection conexao = ConexaoMySQL.iniciarConexao(); // Abrir conexão com BD
		PreparedStatement stmt = null; // Cria um Statement
		try {
			stmt = conexao.prepareStatement("DELETE FROM pagamento WHERE id_pagamento = ?");
			stmt.setInt(1, pagamento.getId_pagamento());
			stmt.executeUpdate(); // Executar o SQL no BD
		} catch (SQLException erro) {
			erro.printStackTrace();
		} finally {
			ConexaoMySQL.encerrarConexao(conexao, stmt);
		}
	}
}