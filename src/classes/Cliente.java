package classes;

public class Cliente extends Usuario{

		private Banco meuBanco;
		private Plano meuPlano;
		private Status meuStatus;
		private Data dataInicio;
		private Data dataFinal;
		
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
		
	}
