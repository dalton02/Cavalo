package classes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class Tradutor {

	
	
	public Medico inicializarMedico(File userFile) {
		
		Medico user = new Medico();
		

		ArrayList<String> linhas = new ArrayList<>();
	    
		try {
			FileReader userReader = new FileReader(userFile);
			BufferedReader userBuffer = new BufferedReader(userReader);
			String linha;
            while ((linha = userBuffer.readLine()) != null) {
					linhas.add(linha);
            }
            userReader.close();
            userBuffer.close();
            
		} 
		
		
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		user.setNome(linhas.get(0));
		user.setSenha(linhas.get(1));
		
		return user;
		
	}
	
	public Cliente inicializarCliente(File userFile){
		
		
		Cliente user = new Cliente();
		
		Banco banco = new Banco();
		Status status = new Status();
		Data dataInicio = new Data();
		Data dataFinal = new Data();
		Data dataPagamento = new Data();
		
		ArrayList<String> linhas = new ArrayList<>();
	    
		try {
			FileReader userReader = new FileReader(userFile);
			BufferedReader userBuffer = new BufferedReader(userReader);
			String linha;
            while ((linha = userBuffer.readLine()) != null) {
					linhas.add(linha);
            }
            userReader.close();
            userBuffer.close();
            
		} 
		
		
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		String dataS = String.valueOf(linhas.get(15));
		int dia = Integer.valueOf(dataS.substring(0, 2));
		int mes = Integer.valueOf(dataS.substring(3, 5));
		int ano = Integer.valueOf(dataS.substring(6, 10));
		
		dataInicio.setDia(dia);
		dataInicio.setMes(mes);
		dataInicio.setAno(ano);
		
		dataS = String.valueOf(linhas.get(16));
		dia = Integer.valueOf(dataS.substring(0, 2));
		mes = Integer.valueOf(dataS.substring(3, 5));
		ano = Integer.valueOf(dataS.substring(6, 10));

		dataFinal.setDia(dia);
		dataFinal.setMes(mes);
		dataFinal.setAno(ano);
		
		dataS = String.valueOf(linhas.get(17));
		dia = Integer.valueOf(dataS.substring(0, 2));
		mes = Integer.valueOf(dataS.substring(3, 5));
		ano = Integer.valueOf(dataS.substring(6, 10));

		
		dataPagamento.setDia(dia);
		dataPagamento.setAno(ano);
		dataPagamento.setMes(mes);
		
			 
		LocalDate c1 = LocalDate.now();
		LocalDate dataPay = LocalDate.of(ano, mes, dia);
		//Caso a data de pagamento tenha expirado
		if(dataPay.isBefore(c1) || dataPay.equals(c1)) {
			user.setLiberado(false);
		}
		else
			user.setLiberado(true);
		
		
		Plano plano;
		if(Integer.valueOf(linhas.get(2))==0) 
		plano = new PlanoFrango();
		else if(Integer.valueOf(linhas.get(2))==1) 
		plano = new PlanoMaromba();
		else if(Integer.valueOf(linhas.get(2))==2) 
		plano = new PlanoCavalo();
		else {
		   plano = null; // Tratar caso em que nÃ£o hÃ¡ um plano definido
		}
		
			
		user.setMeuBanco(banco);
		user.setMeuPlano((Plano) plano);
		user.setMeuStatus(status);
		user.setDataInicio(dataInicio);
		user.setDataFinal(dataFinal);
		user.setDataPagamento(dataPagamento);
		user.setNome(linhas.get(0));
		user.setSenha(linhas.get(1));
		
		user.getMeuPlano().setMeuPacote(Integer.valueOf(linhas.get(3)));
		user.getMeuBanco().setSaldo(Double.valueOf(linhas.get(5)));
		user.getMeuBanco().setBanco(linhas.get(4));
		
		user.getMeuStatus().setAltura(0,Integer.valueOf(linhas.get(6)));
		user.getMeuStatus().setIdade(0,Integer.valueOf(linhas.get(7)));
		user.getMeuStatus().setSexo(linhas.get(8).charAt(0));
		user.getMeuStatus().setPeso(0,Double.valueOf(linhas.get(9)));
		user.getMeuStatus().setGordura(0, Double.valueOf(linhas.get(10)));
		user.getMeuStatus().setAltura(1,Integer.valueOf(linhas.get(11)));
		user.getMeuStatus().setIdade(1,Integer.valueOf(linhas.get(12)));
		user.getMeuStatus().setPeso(1, Double.valueOf(linhas.get(13)));
		user.getMeuStatus().setGordura(1, Double.valueOf(linhas.get(14)));
		
		user.getMeuPlano().aplicarDesconto();
	
		return user;
	}

}
