package classes;

public class Plano {

	private double [] tipoPlano; //0 = Plano Frango, 1 = Plano Maromba, 2 = Plano Cavalo
	private double[] tipoPacote; //0 = Pré treinos, 1 = Anabolizantes, 2 = All inclused
	private int meuPlano;
	private int meuPacote;
	
	public Plano(){

		tipoPlano = new double[3];
		tipoPacote = new double[4];
		tipoPacote[0] = 0.0;
		tipoPacote[1] = 50.00;
		tipoPacote[2] = 70.00;
		tipoPacote[3] = 100.00;
		tipoPlano[0] = 40.00;
		tipoPlano[1] = 79.99;
		tipoPlano[2] = 99.99;
		
	}
	
	
	public void aplicarDesconto(int tipoPlano) {
		
		if(tipoPlano==1) {

			this.tipoPacote[0] = 0.00;
			this.tipoPacote[1] = 42.00;
			this.tipoPacote[2] = 52.00;
			this.tipoPacote[3] = 78.00;
			
			
		}
		else if (tipoPlano==2) {
			this.tipoPacote[0]=  0.00;
			this.tipoPacote[1] = 35.00;
			this.tipoPacote[2] = 45.00;
			this.tipoPacote[3] = 70.00;
			
		}
		
	}


	public double[] getTipoPlano() {
		return tipoPlano;
	}

	public void setTipoPlano(double[] tipoPlano) {
		this.tipoPlano = tipoPlano;
	}

	public double[] getTipoPacote() {
		return tipoPacote;
	}

	public void setTipoPacote(double[] tipoPacote) {
		this.tipoPacote = tipoPacote;
	}
	
	public int getMeuPlano() {
		return meuPlano;
	}


	public void setMeuPlano(int meuPlano) {
		this.meuPlano = meuPlano;
	}


	public int getMeuPacote() {
		return meuPacote;
	}


	public void setMeuPacote(int meuPacote) {
		this.meuPacote = meuPacote;
	}
	


}
