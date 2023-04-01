package academia;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import classes.*;
import java.awt.Color;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.awt.Component;
import java.awt.event.ActionListener;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GerenciarAcademia extends JFrame {

	private JPanel contentPane;
	private JPanel panelMenu;
	private JLabel lblProgresso;
	private JLabel lblPlano;
	private JLabel lblDespesas;
	private JLabel lblSobre;
	private JPanel panelProgresso;
	private JPanel panelPlano;
	private JPanel panelSobre;
	private JPanel panelDespesas;
	private JLabel lblGorduraAnt;
	private JLabel lblPesoAnt;
	private JLabel lblImcAnt;
	private JPanel panelLblStatusAtual;
	private JLabel lblGorduraAtual;
	private JLabel lblPesoAtual;
	private JLabel lblImcAtual;
	private JLabel lblPlanoAtual;
	private JLabel lblPacoteAtual;
	private JLabel lblDespesaPlano;
	private JLabel btnPlano;
	private JLabel btnPacote;
	private JLabel lblDespesaPacote;
	private JLabel lblDespesaTotal;
	private JLabel btnPagarMensalidade;
	private JLabel lblSeuSaldo;
	private JLabel btnAtualizarSaldo;
	private JLabel lblTitle2;
	private Usuario user;
	private File userFile;
	private FileReader userReader;
	private BufferedReader userBuffer;
	private JPanel panelLblStatusAnt_1;
	private JLabel lblMassaM;
	private JLabel lblTmb;
	private JLabel lblMassaG;
	private JLabel lblMassaMagraAnt;
	private JLabel lblTmbAnt;
	private JLabel lblMassaGordaAnt;
	private JPanel panelLblStatusAtual_2;
	private JLabel lblMassaM_1;
	private JLabel lblTmb_1;
	private JLabel lblMassaG_1;
	private JLabel lblMassaMagraAtual;
	private JLabel lblTmbAtual;
	private JLabel lblMassaGordaAtual;
	
	public GerenciarAcademia(File arquivo){
		userFile = arquivo;
		inicializarUsuario();
		init();
	}
	
	private void inicializarUsuario(){
		user = new Usuario();
		Banco banco = new Banco();
		Plano plano = new Plano();
		Status status = new Status();
		ArrayList<String> linhas = new ArrayList<>();
	    
		try {
			userReader = new FileReader(userFile);
			userBuffer = new BufferedReader(userReader);
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
		
		user.setMeuBanco(banco);
		user.setMeuPlano(plano);
		user.setMeuStatus(status);
		user.setNome(linhas.get(0));
		user.setSenha(linhas.get(1));
		user.getMeuPlano().setMeuPlano(Integer.valueOf(linhas.get(2)));
		user.getMeuPlano().setMeuPacote(Integer.valueOf(linhas.get(3)));
		user.getMeuBanco().setSaldo(Double.valueOf(linhas.get(5)));
		user.getMeuBanco().setBanco(linhas.get(4));
		user.getMeuStatus().setAltura(Integer.valueOf(linhas.get(6)));
		user.getMeuStatus().setIdade(Integer.valueOf(linhas.get(7)));
		user.getMeuStatus().setSexo(linhas.get(8).charAt(0));
		user.getMeuStatus().setPeso(0,Double.valueOf(linhas.get(9)));
		user.getMeuStatus().setGordura(0, Double.valueOf(linhas.get(10)));
		
		if(linhas.size()<=11) {
			user.getMeuStatus().setGordura(1, Double.valueOf(linhas.get(10)));
			user.getMeuStatus().setPeso(1, Double.valueOf(linhas.get(9)));
		}
		else {		
			user.getMeuStatus().setGordura(1, Double.valueOf(linhas.get(12)));
			user.getMeuStatus().setPeso(1, Double.valueOf(linhas.get(11)));
		}
		
		user.getMeuPlano().aplicarDesconto(user.getMeuPlano().getMeuPlano());
		
	}
	
	private void acoesMenu() {
		 lblPlano.addMouseListener(new MouseAdapter() {
	        	@Override
	        	public void mouseEntered(MouseEvent e) {
	        	lblPlano.setForeground(Color.WHITE);
	        	}
	        	public void mouseExited(MouseEvent e) {
	        	lblPlano.setForeground(Color.DARK_GRAY);
	        	}
	        	public void mouseClicked(MouseEvent e) {
	        		panelPlano.setVisible(true);
	        		panelDespesas.setVisible(false);
	        		panelProgresso.setVisible(false);
	        		panelSobre.setVisible(false);
	        	}
	        });
		 lblProgresso.addMouseListener(new MouseAdapter() {
	        	@Override
	        	public void mouseEntered(MouseEvent e) {
	        	lblProgresso.setForeground(Color.WHITE);
	        	}
	        	public void mouseExited(MouseEvent e) {
	        	lblProgresso.setForeground(Color.DARK_GRAY);
	        	}
	        	public void mouseClicked(MouseEvent e) {
	        		panelPlano.setVisible(false);
	        		panelDespesas.setVisible(false);
	        		panelProgresso.setVisible(true);
	        		panelSobre.setVisible(false);
	        	}
	        	
	        });
		 
		 lblDespesas.addMouseListener(new MouseAdapter() {
	        	@Override
	        	public void mouseEntered(MouseEvent e) {
	        	lblDespesas.setForeground(Color.WHITE);
	        	}
	        	public void mouseExited(MouseEvent e) {
	        	lblDespesas.setForeground(Color.DARK_GRAY);
	        	}
	        	public void mouseClicked(MouseEvent e) {
	        		panelPlano.setVisible(false);
	        		panelDespesas.setVisible(true);
	        		panelProgresso.setVisible(false);
	        		panelSobre.setVisible(false);
	        	}
	        });
		 
		 lblSobre.addMouseListener(new MouseAdapter() {
	        	@Override
	        	public void mouseEntered(MouseEvent e) {
	        	lblSobre.setForeground(Color.WHITE);
	        	}
	        	public void mouseExited(MouseEvent e) {
	        	lblSobre.setForeground(Color.DARK_GRAY);
	        	}
	        	public void mouseClicked(MouseEvent e) {
	        		panelPlano.setVisible(false);
	        		panelDespesas.setVisible(false);
	        		panelProgresso.setVisible(false);
	        		panelSobre.setVisible(true);
	        	}
	        });
	}
	
	
	private void acoesProgresso() {
		
	}
	
	private void acoesPlano() {
		btnPlano.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {

				btnPlano.setBackground(new Color(89, 213, 106));
			}
			public void mouseExited(MouseEvent e) {

				btnPlano.setBackground(new Color(55, 213, 106));
			}
			public void mouseClicked(MouseEvent e) {
				String []options = {"Plano Frango","Plano Maromba","Plano Cavalo"};
				int escolha = JOptionPane.showOptionDialog(null, "Escolha seu novo plano","Escolha",JOptionPane.CLOSED_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
				modificarLinha(2, String.valueOf(escolha));
				atualizarTela();
				
			}	
		});
		btnPacote.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {

				btnPacote.setBackground(new Color(89, 213, 106));
			}
			public void mouseExited(MouseEvent e) {

				btnPacote.setBackground(new Color(55, 213, 106));
				
			}
			public void mouseClicked(MouseEvent e) {

				String []options = {"Nenhum :(","TREM-BALA","FREAKY","SUICIDA"};
				int escolha = JOptionPane.showOptionDialog(null, "Escolha seu novo pacote","Escolha",JOptionPane.CLOSED_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
				modificarLinha(3, String.valueOf(escolha));
				atualizarTela();
			}
		});
	}
	
	private void acoesDespesas() {
		btnAtualizarSaldo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {

				btnAtualizarSaldo.setBackground(new Color(89, 213, 106));
			}
			public void mouseExited(MouseEvent e) {

				btnAtualizarSaldo.setBackground(new Color(55, 213, 106));
				
			}
			public void mouseClicked(MouseEvent e) {
				
				double saldoNovo = Double.valueOf(JOptionPane.showInputDialog(null,"Informe seu novo saldo: "));
				modificarLinha(5, String.valueOf(saldoNovo));
				atualizarTela();
			}
		});
		btnPagarMensalidade.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnPagarMensalidade.setBackground(new Color(89, 213, 106));
			}
			public void mouseExited(MouseEvent e) {
				btnPagarMensalidade.setBackground(new Color(55, 213, 106));
				
			}
			public void mouseClicked(MouseEvent e) {
				
				double valorPlano = user.getMeuPlano().getTipoPlano()[user.getMeuPlano().getMeuPlano()];
				double valorPacote = user.getMeuPlano().getTipoPacote()[user.getMeuPlano().getMeuPacote()];
				
				if(user.getMeuBanco().getSaldo()>(valorPacote+valorPlano)) {
					
				int x = JOptionPane.showConfirmDialog(null,"Deseja pagar a mensalidade atual?\nValor Pacote: "+valorPacote+
				"\nPlano Atual: "+valorPlano+"\nTotal: "+(valorPlano+valorPacote));
				if(x==0) {
					modificarLinha(5, String.valueOf(user.getMeuBanco().getSaldo()-(valorPacote+valorPlano)));
					JOptionPane.showMessageDialog(null, "Mensalidade Paga!!!");
					atualizarTela();
				
				}
				
			}
				else
					JOptionPane.showMessageDialog(null, "Vai trabalhar!!!!");
			}
			
			
		});	
	}
	
	private void atualizarTela() {
		
		GerenciarAcademia c1 = new GerenciarAcademia(userFile);
		c1.setVisible(true);
		dispose();
		
	}
	
	private void modificarLinha(int linhaModificada,String textoNovo) {
		
		try {
			userReader = new FileReader(userFile);
			userBuffer = new BufferedReader(userReader);
			int i=0;
			String linha; 
			 StringBuilder sb = new StringBuilder();
			while ((linha = userBuffer.readLine()) != null) {
				
				if(linhaModificada==i) {
					sb.append(textoNovo).append("\n");
				}
				else
					sb.append(linha).append("\n");
				
				i++;
	        }
			userReader.close();
			
			FileWriter escritor = new FileWriter(userFile);
			escritor.write(sb.toString());
			escritor.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private void inicializarMenu() {
	    panelMenu = new JPanel();
        panelMenu.setBounds(30,40,245,589);
        panelMenu.setOpaque(false);
        contentPane.add(panelMenu);
        panelMenu.setLayout(null);
        
        lblPlano = new JLabel("Seu Plano");
        lblPlano.setForeground(Color.DARK_GRAY);
        lblPlano.setHorizontalAlignment(SwingConstants.CENTER);
        lblPlano.setFont(new Font("Source Code Pro Semibold", Font.BOLD, 26));
        lblPlano.setBounds(0, 120, 245, 40);
        
        panelMenu.add(lblPlano);
        
        lblProgresso = new JLabel("Progresso");
        lblProgresso.setForeground(Color.DARK_GRAY);
        lblProgresso.setHorizontalAlignment(SwingConstants.CENTER);
        lblProgresso.setFont(new Font("Source Code Pro Semibold", Font.BOLD, 26));
        lblProgresso.setBounds(0, 220, 245, 40);
        panelMenu.add(lblProgresso);
        
        lblSobre = new JLabel("Sobre");
        lblSobre.setForeground(Color.DARK_GRAY);
        lblSobre.setHorizontalAlignment(SwingConstants.CENTER);
        lblSobre.setFont(new Font("Source Code Pro Semibold", Font.BOLD, 26));
        lblSobre.setBounds(0, 420, 245, 40);
        panelMenu.add(lblSobre);
        
        lblDespesas = new JLabel("Despesas");
        lblDespesas.setForeground(Color.DARK_GRAY);
        lblDespesas.setHorizontalAlignment(SwingConstants.CENTER);
        lblDespesas.setFont(new Font("Source Code Pro Semibold", Font.BOLD, 26));
        lblDespesas.setBounds(0, 320, 245, 40);
        panelMenu.add(lblDespesas);
        acoesMenu();
	}
	
	private void inicializarProgresso() {
		
    	   NumberFormat nf =NumberFormat.getInstance();
    	   nf.setMaximumFractionDigits(2);
    	   nf.setMinimumFractionDigits(2);
	       JPanel panelLblStatusAnt = new JPanel();
	       panelLblStatusAnt.setBounds(40, 58, 565, 75);
	       panelLblStatusAnt.setOpaque(false);
	       panelProgresso.add(panelLblStatusAnt);
	       panelLblStatusAnt.setLayout(null);
	       
	       JLabel lblTitle1 = new JLabel("Quando você começou:");
	       lblTitle1.setForeground(Color.WHITE);
	       lblTitle1.setFont(new Font("DejaVu Sans", Font.BOLD, 18));
	       lblTitle1.setBounds(40, 11, 235, 36);
	       panelProgresso.add(lblTitle1);
	       
	       
	       JLabel lblGordura = new JLabel("Gordura Corporal:");
	       lblGordura.setAlignmentX(Component.RIGHT_ALIGNMENT);
	       lblGordura.setHorizontalAlignment(SwingConstants.CENTER);
	       lblGordura.setForeground(Color.WHITE);
	       lblGordura.setFont(new Font("DejaVu Sans", Font.BOLD, 16));
	       lblGordura.setBounds(0, 12, 159, 19);
	       panelLblStatusAnt.add(lblGordura);
	       
	       JLabel lblPeso = new JLabel("Peso:");
	       lblPeso.setHorizontalAlignment(SwingConstants.LEFT);
	       lblPeso.setForeground(Color.WHITE);
	       lblPeso.setFont(new Font("DejaVu Sans", Font.BOLD, 16));
	       lblPeso.setAlignmentX(1.0f);
	       lblPeso.setBounds(270, 12, 85, 19);
	       panelLblStatusAnt.add(lblPeso);
	       
	       JLabel lblImc = new JLabel("IMC:");
	       lblImc.setHorizontalAlignment(SwingConstants.CENTER);
	       lblImc.setForeground(Color.WHITE);
	       lblImc.setFont(new Font("DejaVu Sans", Font.BOLD, 16));
	       lblImc.setAlignmentX(1.0f);
	       lblImc.setBounds(435, 12, 67, 19);
	       panelLblStatusAnt.add(lblImc);
	       
	       lblGorduraAnt = new JLabel(user.getMeuStatus().getGordura()[0]+"%");
	       lblGorduraAnt.setBounds(10, 42, 127, 19);
	       panelLblStatusAnt.add(lblGorduraAnt);
	       lblGorduraAnt.setHorizontalAlignment(SwingConstants.CENTER);
	       lblGorduraAnt.setForeground(Color.WHITE);
	       lblGorduraAnt.setFont(new Font("DejaVu Sans", Font.BOLD, 16));
	       lblGorduraAnt.setAlignmentX(1.0f);
	       
	       lblPesoAnt = new JLabel(user.getMeuStatus().getPeso()[0]+"KG");
	       lblPesoAnt.setBounds(253, 42, 85, 19);
	       panelLblStatusAnt.add(lblPesoAnt);
	       lblPesoAnt.setHorizontalAlignment(SwingConstants.CENTER);
	       lblPesoAnt.setForeground(Color.WHITE);
	       lblPesoAnt.setFont(new Font("DejaVu Sans", Font.BOLD, 16));
	       lblPesoAnt.setAlignmentX(1.0f);
	       
	       lblImcAnt = new JLabel(nf.format(user.getMeuStatus().gerarImc(0))+"");
	       lblImcAnt.setBounds(420, 42, 95, 19);
	       panelLblStatusAnt.add(lblImcAnt);
	       lblImcAnt.setHorizontalAlignment(SwingConstants.CENTER);
	       lblImcAnt.setForeground(Color.WHITE);
	       lblImcAnt.setFont(new Font("DejaVu Sans", Font.BOLD, 16));
	       lblImcAnt.setAlignmentX(1.0f);
	       
	       panelLblStatusAtual = new JPanel();
	       panelLblStatusAtual.setLayout(null);
	       panelLblStatusAtual.setOpaque(false);
	       panelLblStatusAtual.setBounds(40, 257, 565, 69);
	       panelProgresso.add(panelLblStatusAtual);
	       
	       JLabel lblGordura_1 = new JLabel("Gordura Corporal:");
	       lblGordura_1.setHorizontalAlignment(SwingConstants.LEFT);
	       lblGordura_1.setForeground(Color.WHITE);
	       lblGordura_1.setFont(new Font("DejaVu Sans", Font.BOLD, 16));
	       lblGordura_1.setAlignmentX(1.0f);
	       lblGordura_1.setBounds(0, 12, 159, 19);
	       panelLblStatusAtual.add(lblGordura_1);
	       
	       JLabel lblPeso_1 = new JLabel("Peso:");
	       lblPeso_1.setHorizontalAlignment(SwingConstants.LEFT);
	       lblPeso_1.setForeground(Color.WHITE);
	       lblPeso_1.setFont(new Font("DejaVu Sans", Font.BOLD, 16));
	       lblPeso_1.setAlignmentX(1.0f);
	       lblPeso_1.setBounds(270, 12, 85, 19);
	       panelLblStatusAtual.add(lblPeso_1);
	       
	       JLabel lblImc_1 = new JLabel("IMC:");
	       lblImc_1.setHorizontalAlignment(SwingConstants.CENTER);
	       lblImc_1.setForeground(Color.WHITE);
	       lblImc_1.setFont(new Font("DejaVu Sans", Font.BOLD, 16));
	       lblImc_1.setAlignmentX(1.0f);
	       lblImc_1.setBounds(435, 12, 69, 19);
	       panelLblStatusAtual.add(lblImc_1);
	       
	       lblGorduraAtual = new JLabel(user.getMeuStatus().getGordura()[1]+"%");
	       lblGorduraAtual.setBounds(10, 39, 118, 19);
	       panelLblStatusAtual.add(lblGorduraAtual);
	       lblGorduraAtual.setHorizontalAlignment(SwingConstants.CENTER);
	       lblGorduraAtual.setForeground(Color.WHITE);
	       lblGorduraAtual.setFont(new Font("DejaVu Sans", Font.BOLD, 16));
	       lblGorduraAtual.setAlignmentX(1.0f);
	       
	       lblPesoAtual = new JLabel(user.getMeuStatus().getPeso()[1]+"KG");
	       lblPesoAtual.setBounds(253, 42, 85, 19);
	       panelLblStatusAtual.add(lblPesoAtual);
	       lblPesoAtual.setHorizontalAlignment(SwingConstants.CENTER);
	       lblPesoAtual.setForeground(Color.WHITE);
	       lblPesoAtual.setFont(new Font("DejaVu Sans", Font.BOLD, 16));
	       lblPesoAtual.setAlignmentX(1.0f);
	       
	       lblImcAtual = new JLabel(nf.format(user.getMeuStatus().gerarImc(1))+"");
	       lblImcAtual.setBounds(420, 42, 95, 19);
	       panelLblStatusAtual.add(lblImcAtual);
	       lblImcAtual.setHorizontalAlignment(SwingConstants.CENTER);
	       lblImcAtual.setForeground(Color.WHITE);
	       lblImcAtual.setFont(new Font("DejaVu Sans", Font.BOLD, 16));
	       lblImcAtual.setAlignmentX(1.0f);
	       
	       JLabel lblTitle2 = new JLabel("Seu progresso atual:");
	       lblTitle2.setForeground(Color.WHITE);
	       lblTitle2.setFont(new Font("DejaVu Sans", Font.BOLD, 18));
	       lblTitle2.setBounds(40, 210, 235, 36);
	       panelProgresso.add(lblTitle2);
	       
	       panelLblStatusAnt_1 = new JPanel();
	       panelLblStatusAnt_1.setLayout(null);
	       panelLblStatusAnt_1.setOpaque(false);
	       panelLblStatusAnt_1.setBounds(40, 134, 565, 75);
	       panelProgresso.add(panelLblStatusAnt_1);
	       
	       lblMassaM = new JLabel("Massa Magra:");
	       lblMassaM.setHorizontalAlignment(SwingConstants.CENTER);
	       lblMassaM.setForeground(Color.WHITE);
	       lblMassaM.setFont(new Font("DejaVu Sans", Font.BOLD, 16));
	       lblMassaM.setAlignmentX(1.0f);
	       lblMassaM.setBounds(0, 12, 149, 19);
	       panelLblStatusAnt_1.add(lblMassaM);
	       
	       lblTmb = new JLabel("TMB");
	       lblTmb.setHorizontalAlignment(SwingConstants.LEFT);
	       lblTmb.setForeground(Color.WHITE);
	       lblTmb.setFont(new Font("DejaVu Sans", Font.BOLD, 16));
	       lblTmb.setAlignmentX(1.0f);
	       lblTmb.setBounds(270, 12, 85, 19);
	       panelLblStatusAnt_1.add(lblTmb);
	       
	       lblMassaG = new JLabel("Massa Gorda:");
	       lblMassaG.setHorizontalAlignment(SwingConstants.CENTER);
	       lblMassaG.setForeground(Color.WHITE);
	       lblMassaG.setFont(new Font("DejaVu Sans", Font.BOLD, 16));
	       lblMassaG.setAlignmentX(1.0f);
	       lblMassaG.setBounds(407, 12, 135, 19);
	       panelLblStatusAnt_1.add(lblMassaG);
	       
	       lblMassaMagraAnt = new JLabel(nf.format(user.getMeuStatus().calculoMassaMagra(0))+"%");
	       lblMassaMagraAnt.setHorizontalAlignment(SwingConstants.CENTER);
	       lblMassaMagraAnt.setForeground(Color.WHITE);
	       lblMassaMagraAnt.setFont(new Font("DejaVu Sans", Font.BOLD, 16));
	       lblMassaMagraAnt.setAlignmentX(1.0f);
	       lblMassaMagraAnt.setBounds(10, 42, 127, 19);
	       panelLblStatusAnt_1.add(lblMassaMagraAnt);
	       
	       lblTmbAnt = new JLabel(nf.format(user.getMeuStatus().calculoTMB(user.getMeuStatus().getSexo(),0))+"");
	       lblTmbAnt.setHorizontalAlignment(SwingConstants.CENTER);
	       lblTmbAnt.setForeground(Color.WHITE);
	       lblTmbAnt.setFont(new Font("DejaVu Sans", Font.BOLD, 16));
	       lblTmbAnt.setAlignmentX(1.0f);
	       lblTmbAnt.setBounds(253, 42, 85, 19);
	       panelLblStatusAnt_1.add(lblTmbAnt);
	       
	       lblMassaGordaAnt = new JLabel(nf.format(user.getMeuStatus().calculoMassaGorda(0))+"%");
	       lblMassaGordaAnt.setHorizontalAlignment(SwingConstants.CENTER);
	       lblMassaGordaAnt.setForeground(Color.WHITE);
	       lblMassaGordaAnt.setFont(new Font("DejaVu Sans", Font.BOLD, 16));
	       lblMassaGordaAnt.setAlignmentX(1.0f);
	       lblMassaGordaAnt.setBounds(420, 42, 95, 19);
	       panelLblStatusAnt_1.add(lblMassaGordaAnt);
	       
	       panelLblStatusAtual_2 = new JPanel();
	       panelLblStatusAtual_2.setLayout(null);
	       panelLblStatusAtual_2.setOpaque(false);
	       panelLblStatusAtual_2.setBounds(40, 324, 565, 75);
	       panelProgresso.add(panelLblStatusAtual_2);
	       
	       lblMassaM_1 = new JLabel("Massa Magra:");
	       lblMassaM_1.setHorizontalAlignment(SwingConstants.CENTER);
	       lblMassaM_1.setForeground(Color.WHITE);
	       lblMassaM_1.setFont(new Font("DejaVu Sans", Font.BOLD, 16));
	       lblMassaM_1.setAlignmentX(1.0f);
	       lblMassaM_1.setBounds(0, 12, 149, 19);
	       panelLblStatusAtual_2.add(lblMassaM_1);
	       
	       lblTmb_1 = new JLabel("TMB");
	       lblTmb_1.setHorizontalAlignment(SwingConstants.LEFT);
	       lblTmb_1.setForeground(Color.WHITE);
	       lblTmb_1.setFont(new Font("DejaVu Sans", Font.BOLD, 16));
	       lblTmb_1.setAlignmentX(1.0f);
	       lblTmb_1.setBounds(270, 12, 85, 19);
	       panelLblStatusAtual_2.add(lblTmb_1);
	       
	       lblMassaG_1 = new JLabel("Massa Gorda:");
	       lblMassaG_1.setHorizontalAlignment(SwingConstants.CENTER);
	       lblMassaG_1.setForeground(Color.WHITE);
	       lblMassaG_1.setFont(new Font("DejaVu Sans", Font.BOLD, 16));
	       lblMassaG_1.setAlignmentX(1.0f);
	       lblMassaG_1.setBounds(407, 12, 135, 19);
	       panelLblStatusAtual_2.add(lblMassaG_1);
	       
	       lblMassaMagraAtual = new JLabel(nf.format(user.getMeuStatus().calculoMassaMagra(1))+"%");
	       lblMassaMagraAtual.setHorizontalAlignment(SwingConstants.CENTER);
	       lblMassaMagraAtual.setForeground(Color.WHITE);
	       lblMassaMagraAtual.setFont(new Font("DejaVu Sans", Font.BOLD, 16));
	       lblMassaMagraAtual.setAlignmentX(1.0f);
	       lblMassaMagraAtual.setBounds(10, 42, 127, 19);
	       panelLblStatusAtual_2.add(lblMassaMagraAtual);
	       
	       lblTmbAtual = new JLabel(nf.format(user.getMeuStatus().calculoTMB(user.getMeuStatus().getSexo(),1))+"");
	       lblTmbAtual.setHorizontalAlignment(SwingConstants.CENTER);
	       lblTmbAtual.setForeground(Color.WHITE);
	       lblTmbAtual.setFont(new Font("DejaVu Sans", Font.BOLD, 16));
	       lblTmbAtual.setAlignmentX(1.0f);
	       lblTmbAtual.setBounds(253, 42, 85, 19);
	       panelLblStatusAtual_2.add(lblTmbAtual);
	       
	       lblMassaGordaAtual = new JLabel(nf.format(user.getMeuStatus().calculoMassaGorda(1))+"%");
	       lblMassaGordaAtual.setHorizontalAlignment(SwingConstants.CENTER);
	       lblMassaGordaAtual.setForeground(Color.WHITE);
	       lblMassaGordaAtual.setFont(new Font("DejaVu Sans", Font.BOLD, 16));
	       lblMassaGordaAtual.setAlignmentX(1.0f);
	       lblMassaGordaAtual.setBounds(420, 42, 95, 19);
	       panelLblStatusAtual_2.add(lblMassaGordaAtual);
	       acoesProgresso();
		
	}
	
	private void inicializarPlano() {
		
		lblPlanoAtual = new JLabel();
		lblPlanoAtual.setForeground(Color.WHITE);
		lblPlanoAtual.setHorizontalAlignment(SwingConstants.LEFT);
		lblPlanoAtual.setFont(new Font("DejaVu Sans", Font.BOLD, 16));
		
		
		if(user.getMeuPlano().getMeuPlano()==0)
			lblPlanoAtual.setText("PLANO ATUAL: FRANGO");
		else if(user.getMeuPlano().getMeuPlano()==1)
			lblPlanoAtual.setText("PLANO ATUAL: MAROMBA");
		else if(user.getMeuPlano().getMeuPlano()==2)
			lblPlanoAtual.setText("PLANO ATUAL: CAVALO");
		
		lblPlanoAtual.setBounds(10,54,246,40);
		panelPlano.add(lblPlanoAtual);
		
		lblPacoteAtual = new JLabel();

		if(user.getMeuPlano().getMeuPacote()==0)
			lblPacoteAtual.setText("PACOTE ATUAL: NENHUM");
		if(user.getMeuPlano().getMeuPacote()==1)
			lblPacoteAtual.setText("PACOTE ATUAL: TREM-BALA");
		else if(user.getMeuPlano().getMeuPacote()==2)
			lblPacoteAtual.setText("PACOTE ATUAL: FREAKY");
		else if(user.getMeuPlano().getMeuPacote()==3)
			lblPacoteAtual.setText("PACOTE ATUAL: SUICIDA");
		
		
		lblPacoteAtual.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPacoteAtual.setForeground(Color.WHITE);
		lblPacoteAtual.setFont(new Font("DejaVu Sans", Font.BOLD, 16));
		lblPacoteAtual.setBounds(381, 54, 259, 40);
		panelPlano.add(lblPacoteAtual);
		
		btnPacote = new JLabel();
		btnPacote.setBackground(new Color(55, 213, 106));
		btnPacote.setText("QUERO MUDAR MEU PACOTE!");
		btnPacote.setHorizontalAlignment(SwingConstants.CENTER);
		btnPacote.setForeground(Color.WHITE);
		btnPacote.setFont(new Font("DejaVu Sans", Font.BOLD, 16));
		btnPacote.setBounds(170, 297, 322, 40);
		btnPacote.setOpaque(true);
		panelPlano.add(btnPacote);
		
		btnPlano = new JLabel();
		btnPlano.setBackground(new Color(55, 213, 106));
		btnPlano.setOpaque(true);
		btnPlano.setText("QUERO MUDAR MEU PLANO!");
		btnPlano.setHorizontalAlignment(SwingConstants.CENTER);
		btnPlano.setForeground(Color.WHITE);
		btnPlano.setFont(new Font("DejaVu Sans", Font.BOLD, 16));
		btnPlano.setBounds(170, 209, 322, 40);
		panelPlano.add(btnPlano);
		acoesPlano();
	}
	
	private void inicializarDespesas() {
		
		lblDespesaPlano = new JLabel();
		lblDespesaPlano.setHorizontalAlignment(SwingConstants.LEFT);
		
		double x = user.getMeuPlano().getTipoPlano()[user.getMeuPlano().getMeuPlano()];
		double y = user.getMeuPlano().getTipoPacote()[user.getMeuPlano().getMeuPacote()];

		NumberFormat nf = NumberFormat.getCurrencyInstance();
		nf.setMaximumFractionDigits(2);
		nf.setMinimumFractionDigits(2);
		
		lblDespesaPlano.setText("CUSTO DO PLANO: "+nf.format(x));
		
		lblDespesaPlano.setForeground(Color.WHITE);
		lblDespesaPlano.setFont(new Font("DejaVu Sans", Font.BOLD, 16));
		lblDespesaPlano.setBounds(10, 45, 255, 19);
		panelDespesas.add(lblDespesaPlano);
		
		lblDespesaPacote = new JLabel();
		lblDespesaPacote.setText("CUSTO DO PACOTE: "+nf.format(y));
		lblDespesaPacote.setHorizontalAlignment(SwingConstants.LEFT);
		lblDespesaPacote.setForeground(Color.WHITE);
		lblDespesaPacote.setFont(new Font("DejaVu Sans", Font.BOLD, 16));
		lblDespesaPacote.setBounds(10, 95, 277, 19);
		panelDespesas.add(lblDespesaPacote);
		
		lblDespesaTotal = new JLabel();
		lblDespesaTotal.setText("CUSTO TOTAL: "+nf.format((x+y)));
		lblDespesaTotal.setHorizontalAlignment(SwingConstants.LEFT);
		lblDespesaTotal.setForeground(Color.WHITE);
		lblDespesaTotal.setFont(new Font("DejaVu Sans", Font.BOLD, 16));
		lblDespesaTotal.setBounds(10, 145, 255, 19);
		panelDespesas.add(lblDespesaTotal);
		
		btnPagarMensalidade = new JLabel();
		btnPagarMensalidade.setText("PAGAR MENSALIDADE");
		btnPagarMensalidade.setHorizontalAlignment(SwingConstants.CENTER);
		btnPagarMensalidade.setBackground(new Color(55, 213, 106));
		btnPagarMensalidade.setOpaque(true);
		btnPagarMensalidade.setForeground(Color.WHITE);
		btnPagarMensalidade.setFont(new Font("DejaVu Sans", Font.BOLD, 16));
		btnPagarMensalidade.setBounds(10, 209, 255, 39);
		panelDespesas.add(btnPagarMensalidade);
		
		lblSeuSaldo = new JLabel();
		lblSeuSaldo.setText("SEU SALDO: "+nf.format(user.getMeuBanco().getSaldo()));
		lblSeuSaldo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSeuSaldo.setForeground(Color.WHITE);
		lblSeuSaldo.setFont(new Font("DejaVu Sans", Font.BOLD, 16));
		lblSeuSaldo.setBounds(385, 99, 255, 19);
		panelDespesas.add(lblSeuSaldo);
		
		btnAtualizarSaldo = new JLabel();
		btnAtualizarSaldo.setText("ATUALIZAR SALDO");
		btnAtualizarSaldo.setOpaque(true);
		btnAtualizarSaldo.setHorizontalAlignment(SwingConstants.CENTER);
		btnAtualizarSaldo.setForeground(Color.WHITE);
		btnAtualizarSaldo.setFont(new Font("DejaVu Sans", Font.BOLD, 16));
		btnAtualizarSaldo.setBackground(new Color(55, 213, 106));
		btnAtualizarSaldo.setBounds(385, 209, 255, 39);
		panelDespesas.add(btnAtualizarSaldo);

		acoesDespesas();
	}
	
	private void inicializarSobre() {
		panelSobre.setLayout(null);
		JLabel lblTitle = new JLabel();
		lblTitle.setText("SOBRE");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setForeground(Color.WHITE);
		lblTitle.setFont(new Font("DejaVu Sans", Font.BOLD, 26));
		lblTitle.setBounds(239, 31, 178, 32);
		
		panelSobre.add(lblTitle);
		
		JTextArea txtSobre = new JTextArea();
		txtSobre.setText("A Cavalo de Pau Academia não é apenas um lugar para levantar peso,\r\nmas um lugar que vai abraçar o usuário com uma interface límpida\r\ne de facil leitura para organizar seus dados bancarios, seu plano de \r\nacademia e pacotes.");
		txtSobre.setBounds(10, 79, 630, 266);
		txtSobre.setForeground(Color.WHITE);
		txtSobre.setOpaque(false);
		txtSobre.setBackground(new Color(0,0,0,0));
		txtSobre.setFont(new Font("DejaVu Sans", Font.BOLD, 16));
		txtSobre.setEditable(false);
		panelSobre.add(txtSobre);
		
		lblTitle2 = new JLabel();
		lblTitle2.setText("<html>\r\n@COPYRIGHT\r\n<br/>\r\nDALTON GOMES LOBATO\r\n<br/>\r\nVINICIUS INÁCIO\r\n\r\n</html>");
		lblTitle2.setHorizontalAlignment(SwingConstants.LEFT);
		lblTitle2.setForeground(Color.LIGHT_GRAY);
		lblTitle2.setFont(new Font("DejaVu Sans", Font.ITALIC, 10));
		lblTitle2.setBounds(10, 353, 156, 61);
		panelSobre.add(lblTitle2);
		
	}
	
	private void inicializarLayers() {
		
		panelProgresso = new JPanel();
	    panelProgresso.setOpaque(false);
	    panelProgresso.setBounds(312, 182, 650, 447);
	    panelProgresso.setLayout(null);
	    panelProgresso.setVisible(false);
	    contentPane.add(panelProgresso);
	    
	    panelPlano = new JPanel();
        panelPlano.setBackground(new Color(0,0,0,0));
        panelPlano.setBounds(312, 182, 650, 425);
        panelPlano.setLayout(null);
        panelPlano.setOpaque(false);
//        contentPane.add(panelPlano);
		
		
        panelDespesas = new JPanel();
        panelDespesas.setBackground(new Color(0,0,0,0));
        panelDespesas.setLayout(null);
		panelDespesas.setBounds(312, 182, 650, 425);
        panelDespesas.setVisible(false);
  //      contentPane.add(panelDespesas);		
        
        panelSobre = new JPanel();
        panelSobre.setBackground(new Color(0,0,0,0));
        panelSobre.setOpaque(false);
        panelSobre.setBounds(312, 182, 650, 425);
        panelSobre.setVisible(false);
    //    contentPane.add(panelSobre);
		
		inicializarProgresso();
		inicializarPlano();
		inicializarDespesas();
		inicializarSobre();
	}
	
	private void init() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 720);
		setLocationRelativeTo(null);
		setTitle("Sua conta");
		getContentPane().setLayout(null);
		contentPane = new JPanel();
		contentPane.setLayout(null);
		setContentPane(contentPane);
		setResizable(false);
		
		inicializarMenu();
		inicializarLayers();
		
		ImageIcon logoImage = new ImageIcon(CadastroTela.class.getResource("/Imagens/logo.png"));
        Image img = logoImage.getImage();
        Image imgRedimensionada = img.getScaledInstance(400,160, Image.SCALE_SMOOTH);
        ImageIcon logoRedimensionada = new ImageIcon(imgRedimensionada);
        JLabel lblLogo = new JLabel(logoRedimensionada);
        lblLogo.setBounds(465,11,400,160);
        getContentPane().add(lblLogo);
        
        
        ImageIcon bgImage = new ImageIcon(CadastroTela.class.getResource("/Imagens/troyes.png"));        
        JLabel labelBackground = new JLabel(bgImage);
        labelBackground.setLocation(0, 0);
        labelBackground.setSize(1000, 720);
        getContentPane().add(labelBackground);
        
	
	}
}
