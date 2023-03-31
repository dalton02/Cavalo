package academia;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import java.awt.CardLayout;
import java.awt.Color;

import net.miginfocom.swing.MigLayout;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Component;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

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
	private JPanel panelStatusAnt;
	private JLabel lblGorduraAnt;
	private JLabel lblPesoAnt;
	private JLabel lblImcAnt;
	private JPanel panelLblStatusAtual;
	private JPanel panelStatusAtual;
	private JLabel lblGorduraAtual;
	private JLabel lblPesoAtual;
	private JLabel lblImcAtual;
	private JLabel lblTitle3;
	private JLabel lblTitle4;
	private JLabel btnAtualizarProgresso;
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
	public GerenciarAcademia() {
		init();
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
	
		btnAtualizarProgresso.addMouseListener(new MouseAdapter() {
	       	public void mouseClicked(MouseEvent e) {
	    
	       	}
	       	public void mouseEntered(MouseEvent e) {
				btnAtualizarProgresso.setBackground(new Color(89, 213, 106));

	       	}
	       	public void mouseExited(MouseEvent e) {
				btnAtualizarProgresso.setBackground(new Color(55, 213, 106));
	       	}
	       });
		
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
		});
		btnPacote.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {

				btnPacote.setBackground(new Color(89, 213, 106));
			}
			public void mouseExited(MouseEvent e) {

				btnPacote.setBackground(new Color(55, 213, 106));
				
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
		});
		btnPagarMensalidade.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnPagarMensalidade.setBackground(new Color(89, 213, 106));
			}
			public void mouseExited(MouseEvent e) {
				btnPagarMensalidade.setBackground(new Color(55, 213, 106));
				
			}
			
		});	
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
		
	       JPanel panelLblStatusAnt = new JPanel();
	       panelLblStatusAnt.setBounds(40, 58, 565, 36);
	       panelLblStatusAnt.setOpaque(false);
	       panelProgresso.add(panelLblStatusAnt);
	       panelLblStatusAnt.setLayout(null);
	       
	       JLabel lblTitle1 = new JLabel("Quando você começou:");
	       lblTitle1.setForeground(Color.WHITE);
	       lblTitle1.setFont(new Font("DejaVu Sans", Font.BOLD, 16));
	       lblTitle1.setBounds(40, 11, 208, 36);
	       panelProgresso.add(lblTitle1);
	       
	       
	       JLabel lblGordura = new JLabel("Gordura Corporal:");
	       lblGordura.setAlignmentX(Component.RIGHT_ALIGNMENT);
	       lblGordura.setHorizontalAlignment(SwingConstants.LEFT);
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
	       lblImc.setHorizontalAlignment(SwingConstants.LEFT);
	       lblImc.setForeground(Color.WHITE);
	       lblImc.setFont(new Font("DejaVu Sans", Font.BOLD, 16));
	       lblImc.setAlignmentX(1.0f);
	       lblImc.setBounds(450, 12, 95, 19);
	       panelLblStatusAnt.add(lblImc);
	       
	       panelStatusAnt = new JPanel();
	       panelStatusAnt.setLayout(null);
	       panelStatusAnt.setOpaque(false);
	       panelStatusAnt.setBounds(40, 91, 565, 36);
	       panelProgresso.add(panelStatusAnt);
	       
	       lblGorduraAnt = new JLabel("12.67%");
	       lblGorduraAnt.setHorizontalAlignment(SwingConstants.CENTER);
	       lblGorduraAnt.setForeground(Color.WHITE);
	       lblGorduraAnt.setFont(new Font("DejaVu Sans", Font.BOLD, 16));
	       lblGorduraAnt.setAlignmentX(1.0f);
	       lblGorduraAnt.setBounds(0, 12, 159, 19);
	       panelStatusAnt.add(lblGorduraAnt);
	       
	       lblPesoAnt = new JLabel("74.5KG");
	       lblPesoAnt.setHorizontalAlignment(SwingConstants.CENTER);
	       lblPesoAnt.setForeground(Color.WHITE);
	       lblPesoAnt.setFont(new Font("DejaVu Sans", Font.BOLD, 16));
	       lblPesoAnt.setAlignmentX(1.0f);
	       lblPesoAnt.setBounds(255, 12, 85, 19);
	       panelStatusAnt.add(lblPesoAnt);
	       
	       lblImcAnt = new JLabel("14.56");
	       lblImcAnt.setHorizontalAlignment(SwingConstants.CENTER);
	       lblImcAnt.setForeground(Color.WHITE);
	       lblImcAnt.setFont(new Font("DejaVu Sans", Font.BOLD, 16));
	       lblImcAnt.setAlignmentX(1.0f);
	       lblImcAnt.setBounds(425, 12, 95, 19);
	       panelStatusAnt.add(lblImcAnt);
	       
	       panelLblStatusAtual = new JPanel();
	       panelLblStatusAtual.setLayout(null);
	       panelLblStatusAtual.setOpaque(false);
	       panelLblStatusAtual.setBounds(40, 210, 565, 36);
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
	       lblImc_1.setHorizontalAlignment(SwingConstants.LEFT);
	       lblImc_1.setForeground(Color.WHITE);
	       lblImc_1.setFont(new Font("DejaVu Sans", Font.BOLD, 16));
	       lblImc_1.setAlignmentX(1.0f);
	       lblImc_1.setBounds(450, 12, 95, 19);
	       panelLblStatusAtual.add(lblImc_1);
	       
	       panelStatusAtual = new JPanel();
	       panelStatusAtual.setLayout(null);
	       panelStatusAtual.setOpaque(false);
	       panelStatusAtual.setBounds(40, 243, 565, 36);
	       panelProgresso.add(panelStatusAtual);
	       
	       lblGorduraAtual = new JLabel("10.27%");
	       lblGorduraAtual.setHorizontalAlignment(SwingConstants.CENTER);
	       lblGorduraAtual.setForeground(Color.WHITE);
	       lblGorduraAtual.setFont(new Font("DejaVu Sans", Font.BOLD, 16));
	       lblGorduraAtual.setAlignmentX(1.0f);
	       lblGorduraAtual.setBounds(0, 12, 159, 19);
	       panelStatusAtual.add(lblGorduraAtual);
	       
	       lblPesoAtual = new JLabel("58.5KG");
	       lblPesoAtual.setHorizontalAlignment(SwingConstants.CENTER);
	       lblPesoAtual.setForeground(Color.WHITE);
	       lblPesoAtual.setFont(new Font("DejaVu Sans", Font.BOLD, 16));
	       lblPesoAtual.setAlignmentX(1.0f);
	       lblPesoAtual.setBounds(255, 12, 85, 19);
	       panelStatusAtual.add(lblPesoAtual);
	       
	       lblImcAtual = new JLabel("16.56");
	       lblImcAtual.setHorizontalAlignment(SwingConstants.CENTER);
	       lblImcAtual.setForeground(Color.WHITE);
	       lblImcAtual.setFont(new Font("DejaVu Sans", Font.BOLD, 16));
	       lblImcAtual.setAlignmentX(1.0f);
	       lblImcAtual.setBounds(425, 12, 95, 19);
	       panelStatusAtual.add(lblImcAtual);
	       
	       JLabel lblTitle2 = new JLabel("Seu progresso atual:");
	       lblTitle2.setForeground(Color.WHITE);
	       lblTitle2.setFont(new Font("DejaVu Sans", Font.BOLD, 16));
	       lblTitle2.setBounds(40, 163, 208, 36);
	       panelProgresso.add(lblTitle2);
	       
	       lblTitle3 = new JLabel("<HTML>SUA GORDURA CORPORAL <br/>IDEAL: 5.67%</HTML>");
	       lblTitle3.setForeground(Color.WHITE);
	       lblTitle3.setFont(new Font("DejaVu Sans", Font.BOLD, 16));
	       lblTitle3.setBounds(40, 375, 264, 36);
	       panelProgresso.add(lblTitle3);
	       
	       lblTitle4 = new JLabel("<HTML>SEU PESO IDEAL: <br/>56KG</HTML>");
	       lblTitle4.setForeground(Color.WHITE);
	       lblTitle4.setFont(new Font("DejaVu Sans", Font.BOLD, 16));
	       lblTitle4.setBounds(419, 375, 186, 36);
	       panelProgresso.add(lblTitle4);
	       
	       btnAtualizarProgresso = new JLabel("Atualizar dados");
	       btnAtualizarProgresso.setHorizontalAlignment(SwingConstants.CENTER);
	       btnAtualizarProgresso.setForeground(Color.WHITE);
	       btnAtualizarProgresso.setFont(new Font("Comic Sans MS", Font.BOLD, 21));
	       btnAtualizarProgresso.setBounds(267, 310, 186, 41);
		   btnAtualizarProgresso.setBackground(new Color(55, 213, 106));
		   btnAtualizarProgresso.setOpaque(true);
	        
	       btnAtualizarProgresso.setBorder(null);
	       btnAtualizarProgresso.setFocusable(false);
	       panelProgresso.add(btnAtualizarProgresso);
	       
		
	}
	
	private void inicializarPlano() {
		
		lblPlanoAtual = new JLabel();
		lblPlanoAtual.setForeground(Color.WHITE);
		lblPlanoAtual.setHorizontalAlignment(SwingConstants.LEFT);
		lblPlanoAtual.setFont(new Font("DejaVu Sans", Font.BOLD, 16));
		lblPlanoAtual.setText("PLANO ATUAL: FRANGO");
		lblPlanoAtual.setBounds(10,54,246,40);
		panelPlano.add(lblPlanoAtual);
		
		lblPacoteAtual = new JLabel();
		lblPacoteAtual.setText("PACOTE ATUAL: TREM-BALA");
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
		lblDespesaPlano.setText("CUSTO DO PLANO: R$39.99");
		lblDespesaPlano.setForeground(Color.WHITE);
		lblDespesaPlano.setFont(new Font("DejaVu Sans", Font.BOLD, 16));
		lblDespesaPlano.setBounds(10, 45, 255, 19);
		panelDespesas.add(lblDespesaPlano);
		
		lblDespesaPacote = new JLabel();
		lblDespesaPacote.setText("CUSTO DO PACOTE: R$56.99");
		lblDespesaPacote.setHorizontalAlignment(SwingConstants.LEFT);
		lblDespesaPacote.setForeground(Color.WHITE);
		lblDespesaPacote.setFont(new Font("DejaVu Sans", Font.BOLD, 16));
		lblDespesaPacote.setBounds(10, 95, 255, 19);
		panelDespesas.add(lblDespesaPacote);
		
		lblDespesaTotal = new JLabel();
		lblDespesaTotal.setText("CUSTO TOTAL: R$97.01");
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
		lblSeuSaldo.setText("SEU SALDO: R$345.99");
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
	    panelProgresso.setBounds(312, 182, 650, 425);
	    panelProgresso.setLayout(null);
	    panelProgresso.setVisible(false);
	    contentPane.add(panelProgresso);
	    
	    panelPlano = new JPanel();
        panelPlano.setBackground(new Color(0,0,0,0));
        panelPlano.setBounds(312, 182, 650, 425);
        panelPlano.setLayout(null);
        panelPlano.setOpaque(false);
        contentPane.add(panelPlano);
		
		
        panelDespesas = new JPanel();
        panelDespesas.setBackground(new Color(0,0,0,0));
        panelDespesas.setLayout(null);
		panelDespesas.setBounds(312, 182, 650, 425);
        panelDespesas.setVisible(false);
        contentPane.add(panelDespesas);		
        
        panelSobre = new JPanel();
        panelSobre.setBackground(new Color(0,0,0,0));
        panelSobre.setOpaque(false);
        panelSobre.setBounds(312, 182, 650, 425);
        panelSobre.setVisible(false);
        contentPane.add(panelSobre);
		
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
