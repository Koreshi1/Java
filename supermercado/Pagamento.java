package sa4.supermercado;

public class Pagamento extends Venda {
	private int tipoPagamento, id_pagamento;

	public void selecionarTipoPagamento(int pag) {
		tipoPagamento = pag;

	}

	public void realizarPagamento(Pagamento pag) {
		String descTipoPagamento = "Forma de pagamento não reconhecida";
		
		if (pag.getTipoPagamento() == 1) {
			descTipoPagamento = "Dinheiro";
		}
		if (pag.getTipoPagamento() == 2) {
			descTipoPagamento = "Cheque";
		}
		if (pag.getTipoPagamento() == 3) {
			descTipoPagamento = "Cartão";
		}
		System.out.println("O pagamento foi realizado!");
		System.out.println("O tipo de pagamento escolhido foi o tipo: " + descTipoPagamento);

	}

	// GETTER AND SETTER
	public int getTipoPagamento() {
		return tipoPagamento;
	}

	public void setTipoPagamento(int tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
	}

	public int getId_pagamento() {
		return id_pagamento;
	}

	public void setId_pagamento(int id_pagamento) {
		this.id_pagamento = id_pagamento;
	}

	// CONSTRUTOR
	public Pagamento() {

	}

	public Pagamento(int id_pagamento) {
		super();
		this.id_pagamento = id_pagamento;
	}
}
