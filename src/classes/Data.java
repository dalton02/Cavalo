package classes;

import java.text.NumberFormat;

public class Data {
	
	private int mes;
	private int dia;
	private int ano;
	
	
	public String mostrarData() {
	    NumberFormat nf = NumberFormat.getNumberInstance();
	    nf.setGroupingUsed(false);
		nf.setMinimumIntegerDigits(2);
		nf.setMaximumIntegerDigits(4);
	    String data = nf.format(dia)+"/"+nf.format(mes)+"/"+nf.format(ano);
		
		return data;
	}
	
	
	public int getMes() {
		return mes;
	}
	public void setMes(int mes) {
		this.mes = mes;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	
	public int getDia() {
		return dia;
	}
	public void setDia(int dia) {
		this.dia = dia;
	}

}
