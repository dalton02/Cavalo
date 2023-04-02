package classes;

public class Usuario {

	private String nome;
	private String senha;
	private Banco meuBanco;
	private Plano meuPlano;
	private Status meuStatus;
	private Data dataInicio;
	private Data dataFinal;
	//Getters Setters
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Banco getMeuBanco() {
		return meuBanco;
	}
	public void setMeuBanco(Banco meuBanco) {
		this.meuBanco = meuBanco;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public Plano getMeuPlano() {
		return meuPlano;
	}
	public void setMeuPlano(Plano meuPlano) {
		this.meuPlano = meuPlano;
	}
	public Status getMeuStatus() {
		return meuStatus;
	}
	public void setMeuStatus(Status meuStatus) {
		this.meuStatus = meuStatus;
	}
	public Data getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(Data dataInicio) {
		this.dataInicio = dataInicio;
	}
	public Data getDataFinal() {
		return dataFinal;
	}
	public void setDataFinal(Data dataFinal) {
		this.dataFinal = dataFinal;
	}
	
	
	
	
}
