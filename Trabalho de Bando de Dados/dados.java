package trabalho;

public class dados {
	private String descricao;
	private String classificacao;
	private double preco;
	private String codigo;
	
	public dados(String cassificacao, double preco, String codigo, String descricao) {
		this.descricao = descricao;
		this.classificacao = classificacao;
		this.descricao = descricao;
		this.preco = preco;
		this.codigo = codigo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public void setClassificacao(String classificacao) {
		this.classificacao = classificacao;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getCodigo() {
		return this.codigo;
	}
	public String getClassificacao() {
		return this.classificacao;
	}
	
	public String retornaLinhaProduto() {
		return ("Codigo: "+this.codigo+", Classificacao: "+this.classificacao+", Preço: R$ "+this.preco);
	}
	
	public String retornaLinhaUnimed() {
		return("Codigo: "+this.codigo+", Descrição: "+this.descricao);
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}


}
