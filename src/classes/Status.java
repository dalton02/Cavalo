package classes;

public class Status {

	private double[] peso;
	private double[] gordura;
	private int altura;
	private int idade;
	private char sexo;
	
	
	public Status() {
		peso = new double[2];
		gordura = new double[2];
	}
	
	public double calculoGorduraIdeal(int x) {
		
		double gIdeal;
		
		if(sexo=='F')
		gIdeal= 1.20*gerarImc(x)+(0.23*idade)-5.4;
		else
		gIdeal= 1.20*gerarImc(x)+(0.23*idade)-(10.38)-5.4;
			
		return gIdeal;
		
	}
	
	
	public double gerarImc(int x) {
		
		double imc= (peso[x]*10000)/(altura*altura);
		return imc;
		
	}
	
	public double calculoMassaGorda(int x) {
		
		double massaG = (gordura[x]/100)*peso[x];
		return massaG;
		
	}
	
	public double calculoMassaMagra(int x) {
		
		double massaM = peso[x] - calculoMassaGorda(x); 
		return massaM;
		
	}
	
	public double calculoTMB(char sexo, int x) {
		
		double tmb;
		if(sexo=='M') {
			
			tmb = 1.55*(66+(13.7*peso[x] + 5*altura - 6.8*idade));
			
		}
		else
			tmb = 1.55*(665+(9.6*peso[x] + 1.8*altura - 4.7*idade));
		
		return tmb;
	}
	
	//Getters Setters
	
	
	public double[] getPeso() {
		return peso;
	}
	public void setPeso(int pos,double peso) {
		this.peso[pos] = peso;
	}
	
	
	public double[] getGordura() {
		return gordura;
	}
	public void setGordura(int pos,double gordura) {
		this.gordura[pos] = gordura;
	}
	public int getAltura() {
		return altura;
	}
	public void setAltura(int altura) {
		this.altura = altura;
	}
	public char getSexo() {
		return sexo;
	}
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
}
