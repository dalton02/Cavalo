package classes;

import javax.swing.JOptionPane;

public abstract class Usuario implements Exibivel {

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
	
	@Override
	public void exibirInfo() {
		
		JOptionPane.showMessageDialog(null, "Usuario: "+nome+"\nSenha:"+senha);
		
	}
	
	
}
