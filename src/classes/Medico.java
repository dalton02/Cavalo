package classes;

public class Medico extends Usuario{

	public boolean verificarPlano(int seuPlano) {
		
		if(seuPlano == 0) 
			return false;

		else if(seuPlano == 1) 
			return false;

		else if(seuPlano == 2) 
			return true;
		else
		return false;
		
	}
	
	@Override
	public void exibirInfo() {
	// TODO Auto-generated method stub
	super.exibirInfo();
	
	}
	
}
