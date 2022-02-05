package entities;

public class ItensVendidos {
	
	private String name;
	private double preco;
	private Integer quantidade;
	
	public ItensVendidos(String name, double preco, Integer quantidade) {

		this.name = name;
		this.preco = preco;
		this.quantidade = quantidade;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	
	public double valorTotal(double preco, Integer quantidade) {
		return this.preco * this.quantidade;
	}
	
}
