package classes;

public abstract class Plano {

	private double[] tipoPacote; //0 = Pré treinos, 1 = Anabolizantes, 2 = All inclused
	private int meuPacote;
	private int meuPlano;
	private double valor;
	
	public Plano(){
		tipoPacote = new double[4];
	}
	
	public abstract void aplicarDesconto();
	

	public double[] getTipoPacote() {
		return tipoPacote;
	}

	public void setTipoPacote(double valor,int x) {
		this.tipoPacote[x] = valor;
	}
	
	public int getMeuPacote() {
		return meuPacote;
	}


	public void setMeuPacote(int meuPacote) {
		this.meuPacote = meuPacote;
	}
	

	public int getMeuPlano() {
		return meuPlano;
	}


	public void setMeuPlano(int meuPlano) {
		this.meuPlano = meuPlano;
	}
	
	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
	


	}





