package sa4.supermercado;

import java.util.ArrayList;

public class Principal {

	public static void main(String[] args) {
		//PRODUTO
		
		Produto produto = new Produto();
		ProdutoDAO produtoDAO = new ProdutoDAO();
		ArrayList<Produto> listaprodutos = new ArrayList<>();
		
		//System.out.println("Digite o nome do produto: ");
		//produto.setNome(ler.nextLine());
		
		produto.setId_produto(3);
		produto.setNome("Carne");
		produto.setPreco(5);
		produto.setQuantidadeEstoque(3);
		
		//produtoDAO.create(produto); //CREATE
	
		//produtoDAO.update(produto); //UPDATE
		
		//produtoDAO.delete(produto); //DELETE
		
		//listaprodutos = produtoDAO.read(); //READ
				listaprodutos.forEach(prod -> {
					System.out.println("Id: " + prod.getId_produto() +
									   " | Nome: " + prod.getNome() + 
									   " | Preço: " + prod.getPreco() +
									   " | Quantidade Estoque: " + prod.getQuantidadeEstoque());
				});
		
		//=============================================
		//VENDA
		
		Venda venda = new Venda();
		VendaDAO vendaDAO = new VendaDAO();
		ArrayList<Venda> listavendas = new ArrayList<>();
		
		venda.setVlrTotal(4.20);
		venda.setId_venda(1);
		
		//vendaDAO.create(venda); //CREATE
		
		//vendaDAO.update(venda); //UPDATE
		
		//vendaDAO.delete(venda); //DELETE
		
		//listavendas = vendaDAO.read(); //READ
				listavendas.forEach(vend -> {
					System.out.println("Id: " + vend.getId_venda() +
									   " | vlrTotal: " + vend.getVlrTotal());
				});
		
		//============================================= 
		//PAGAMENTO
		
		Pagamento pagamento = new Pagamento();
		PagamentoDAO pagamentoDAO = new PagamentoDAO();
		ArrayList<Pagamento> listapagamentos = new ArrayList<>();
		
		pagamento.setId_pagamento(1);
		//pagamento.setTipoPagamento(3);
		
		//pagamentoDAO.create(pagamento); //CREATE
		
		//pagamentoDAO.update(pagamento); //UPDATE
		
		//pagamentoDAO.delete(pagamento); //DELETE
		
		//listapagamentos = pagamentoDAO.read(); //READ
		listapagamentos.forEach(pag -> {
			System.out.println("Id: " + pag.getId_pagamento() +
							   " | tipoPagamento: " + pag.getTipoPagamento());
		});
				
	}
}
