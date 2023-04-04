package classes;

public class PlanoFrango extends Plano{
	
	public PlanoFrango() {
		super.setMeuPlano(0);
		super.setValor(49.99);
	}
	
	public void aplicarDesconto() {
		
		super.setTipoPacote(0,0);
		super.setTipoPacote(90,1);
		super.setTipoPacote(140,2);
		super.setTipoPacote(210,3);
						
	}


}

