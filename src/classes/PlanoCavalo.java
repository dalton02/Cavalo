package classes;


public class PlanoCavalo extends Plano{
	
	public PlanoCavalo() {
		super.setMeuPlano(2);
		super.setValor(99.99);
	}
	
	public void aplicarDesconto() {
		
		super.setTipoPacote(0,0);
		super.setTipoPacote(65,1);
		super.setTipoPacote(110,2);
		super.setTipoPacote(150,3);
						
	}


}