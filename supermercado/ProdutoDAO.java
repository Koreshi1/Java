package sa4.supermercado;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProdutoDAO {
	// Criarmos o CRUD referente à entidade Produto

	public void create(Produto produto) {
		Connection conexao = ConexaoMySQL.iniciarConexao(); // Abrir conexão com BD
		PreparedStatement stmt = null; // Cria um Statement
		try {
			stmt = conexao.prepareStatement("INSERT INTO produto (nome, preco, quantidadeEstoque) VALUES (?,?,?)");
			stmt.setString(1, produto.getNome());
			stmt.setDouble(2, produto.getPreco());
			stmt.setInt(3, produto.getQuantidadeEstoque());
			stmt.executeUpdate(); // Executar o SQL no BD
		} catch (SQLException erro) {
			erro.printStackTrace();
		} finally {
			ConexaoMySQL.encerrarConexao(conexao, stmt);
		}
	}

	public ArrayList<Produto> read(){
		Connection conexao = ConexaoMySQL.iniciarConexao(); // Abrir conexão com BD
		PreparedStatement stmt = null; // Cria um Statement
		ResultSet rs = null; //Cria um ResultSet
		ArrayList<Produto> listaprodutos = new ArrayList<>(); //Cria uma ArrayList que vai armazenar o retorno do ResultSet
		
		try {
			stmt = conexao.prepareStatement("SELECT * FROM produto"); //SQL
			rs = stmt.executeQuery(); //Armazenar o retorno do SQL dentro do ResultSet
			while (rs.next()) {
				Produto produto = new Produto(); //Cria o objeto que irá compor o ArrayList
				produto.setId_produto(rs.getInt("id_produto"));
				produto.setNome(rs.getString("nome"));
				produto.setPreco(rs.getDouble("preco"));
				produto.setQuantidadeEstoque(rs.getInt("quantidadeEstoque"));
				listaprodutos.add(produto);
			}
		} catch (SQLException erro){
			erro.printStackTrace();
		} finally {
			ConexaoMySQL.encerrarConexao(conexao, stmt, rs);
		}
		return listaprodutos;
	}
	
	public void update(Produto produto) {
		Connection conexao = ConexaoMySQL.iniciarConexao(); // Abrir conexão com BD
		PreparedStatement stmt = null; // Cria um Statement
		try {
			stmt = conexao.prepareStatement("UPDATE produto SET nome = ?, preco = ?, quantidadeEstoque = ? WHERE id_produto = ?");
			stmt.setString(1, produto.getNome());
			stmt.setDouble(2, produto.getPreco());
			stmt.setInt(3, produto.getQuantidadeEstoque());
			stmt.setInt(4, produto.getId_produto());
			stmt.executeUpdate(); // Executar o SQL no BD
		} catch (SQLException erro) {
			erro.printStackTrace();
		} finally {
			ConexaoMySQL.encerrarConexao(conexao, stmt);
		}
	}
	
	public void delete(Produto produto) {
		Connection conexao = ConexaoMySQL.iniciarConexao(); // Abrir conexão com BD
		PreparedStatement stmt = null; // Cria um Statement
		try {
			stmt = conexao.prepareStatement("DELETE FROM produto WHERE id_produto = ?");
			stmt.setInt(1, produto.getId_produto());
			stmt.executeUpdate(); // Executar o SQL no BD
		} catch (SQLException erro) {
			erro.printStackTrace();
		} finally {
			ConexaoMySQL.encerrarConexao(conexao, stmt);
		}
	}
}

