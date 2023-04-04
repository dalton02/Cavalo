package classes;

public class PlanoMaromba extends Plano{
	
	public PlanoMaromba() {
		super.setMeuPlano(1);
		super.setValor(79.99);
	}
	
	public void aplicarDesconto() {
		
		super.setTipoPacote(0,0);
		super.setTipoPacote(75,1);
		super.setTipoPacote(120,2);
		super.setTipoPacote(192,3);
						
	}


}