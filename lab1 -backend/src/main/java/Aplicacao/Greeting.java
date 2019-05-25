package Aplicacao;

public class Greeting {
	private String nome;
	private String saudacao;

	Greeting(String nome, String saudacao) {
		this.setNome(nome);
		this.setSaudacao(saudacao);

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSaudacao() {
		return saudacao;
	}

	public void setSaudacao(String saudacao) {
		this.saudacao = saudacao;
	}
}
