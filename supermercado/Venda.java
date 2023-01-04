package sa4.supermercado;

import java.util.ArrayList;


public class Venda {
	private int id_venda;
	private Double vlrTotal;
	private ArrayList<String> listaVendas = new ArrayList<String>();
	private ArrayList<Double> listaPreco = new ArrayList<Double>();

	// METODOS
	public void adicionarItemVenda(Produto prod) {
		int cont;
		String produto;

		produto = prod.getNome();
		listaVendas.add(produto);

		vlrTotal = prod.getPreco();
		listaPreco.add(vlrTotal);
		vlrTotal = 0.0;

		for (cont = 0; cont < listaPreco.size(); cont++) {
			vlrTotal = vlrTotal + listaPreco.get(cont);
		}

	}

	public void visualizarVenda() {
		System.out.println(listaVendas);
	}

	public void concluirVenda(Pagamento pag) {
		System.out.println("O valor total da venda foi R$ " + vlrTotal);
		pag.realizarPagamento(pag);
		listaVendas.clear();
		listaPreco.clear();

	}

	// GETTERS AND SETTERS

	public Double getVlrTotal() {
		return vlrTotal;
	}

	public void setVlrTotal(Double vlrTotal) {
		this.vlrTotal = vlrTotal;
	}

	public int getId_venda() {
		return id_venda;
	}

	public void setId_venda(int id_venda) {
		this.id_venda = id_venda;
	}

	public ArrayList<Double> getListaPreco() {
		return listaPreco;
	}

	public void setListaPreco(ArrayList<Double> listaPreco) {
		this.listaPreco = listaPreco;
	}

	public ArrayList<String> getListavendas() {
		return listaVendas;
	}

	public void setListavendas(ArrayList<String> listavendas) {
		this.listaVendas = listavendas;
	}

	// METODO CONSTRUTOR
	public Venda() {

	}

	public Venda(int id_venda, Double vlrTotal, ArrayList<String> listaVendas, ArrayList<Double> listaPreco) {
		super();
		this.id_venda = id_venda;
		this.vlrTotal = vlrTotal;
		this.listaVendas = listaVendas;
		this.listaPreco = listaPreco;
	}

	

	
}
