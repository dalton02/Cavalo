package classes;

import javax.swing.JOptionPane;

public class Cliente extends Usuario{

		private Banco meuBanco;
		private Plano meuPlano;
		private Status meuStatus;
		private Data dataInicio;
		private Data dataFinal;
		private Data dataPagamento;
		private boolean liberado;
		
		public Cliente() {
			super.setNome(getNome());
			super.setSenha(getSenha());
		}
		
		public Plano getMeuPlano() {
			return meuPlano;
		}
		public void setMeuPlano(Plano meuPlano) {
			this.meuPlano = meuPlano;
		}
		public Status getMeuStatus() {
			return meuStatus;
		}
		public void setMeuStatus(Status meuStatus) {
			this.meuStatus = meuStatus;
		}
		public Data getDataInicio() {
			return dataInicio;
		}
		public void setDataInicio(Data dataInicio) {
			this.dataInicio = dataInicio;
		}
		public Data getDataFinal() {
			return dataFinal;
		}
		public void setDataFinal(Data dataFinal) {
			this.dataFinal = dataFinal;
		}		
		public Banco getMeuBanco() {
			return meuBanco;
		}
		public void setMeuBanco(Banco meuBanco) {
			this.meuBanco = meuBanco;
		}

		public Data getDataPagamento() {
			return dataPagamento;
		}

		public void setDataPagamento(Data dataPagamento) {
			this.dataPagamento = dataPagamento;
		}

		public boolean isLiberado() {
			return liberado;
		}

		public void setLiberado(boolean liberado) {
			this.liberado = liberado;
		}
		
		@Override
		public void exibirInfo() {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(null, 
		"Usuario: "+super.getNome()+"\nPlano Atual: "+meuPlano.getMeuPlano()+
		"\nPacote Atual: "+meuPlano.getMeuPacote()+"\nData de Pagamento: "+dataPagamento.mostrarData());
		
		}
		
	}
