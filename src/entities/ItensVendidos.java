package entities;

public class ItensVendidos {
	
	private String name;
	private Double preco;
	private Integer quantidade;
	
	public ItensVendidos(String name, Double preco, Integer quantidade) {

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

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	
	public double valorTotal() {
		return this.preco * this.quantidade;
	}
	
}
