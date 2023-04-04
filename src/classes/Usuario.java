package classes;

public abstract class Usuario {

	private String nome;
	private String senha;
	//Getters Setters
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public class Medico extends Usuario{}
	
}
