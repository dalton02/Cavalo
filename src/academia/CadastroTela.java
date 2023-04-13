package academia;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class CadastroTela {

    public JFrame frame;
    private JTextField usernameField;
    private JPasswordField txtInsiraSuaSenha;
    private JPasswordField txtRepitaSuaSenha;
    private JLabel lblFacaSeuCadastro;
    private JLabel btnProximo;
    private JLabel labelBackground;
    private JLabel lblRetorna;
    private JLabel lblFrango;
    private JPanel layer1;
    private JPanel layer2;
    private JPanel layer3;
    private JPanel layer4;
    private JRadioButton radioFrango;
    private JRadioButton radioMaromba;
    private JRadioButton radioGiga;
    private JTextField txtBanco;
    private JTextField txtAltura;
    private JTextField txtSaldo;
    private JTextField txtIdade;
    private JTextField txtPeso;
    private  JRadioButton radioM;
    private  JRadioButton radioF;
    private int tipoPlano;
    private char sexo;
    private JTextField txtPercentual;
    
	private Font f1,f2,f3,f4;
    
    public CadastroTela() {
    	initialize();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
    private void inicializarFontes() {
    	
    	File fontFile = new File(System.getProperty("user.dir")+"/src/Fontes/arvo.ttf");
		File fontFile2 = new File(System.getProperty("user.dir")+"/src/Fontes/arvoI.ttf");
		File fontFile3 = new File(System.getProperty("user.dir")+"/src/Fontes/gagalin.ttf");
		
		try {
			f1 = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream(fontFile)).deriveFont(Font.PLAIN, 18);
			f2 = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream(fontFile2)).deriveFont(Font.PLAIN, 18);
			f3 = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream(fontFile3)).deriveFont(Font.PLAIN, 28);
			f4 = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream(fontFile2)).deriveFont(Font.PLAIN, 15);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FontFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		

    }
    
    private void salvarUsuario(){
    	

        LocalDate dataAtual = LocalDate.now();

        // Formatar a data atual
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        File arquivo = new File(System.getProperty("user.dir")+"/src/clientes/"+usernameField.getText()+".txt");

		try{
	    
			try (FileWriter escritor = new FileWriter(arquivo,true)) {
	            escritor.write(usernameField.getText()+"\n");
	            escritor.write(txtInsiraSuaSenha.getText()+"\n");
	            escritor.write(tipoPlano+"\n");
	            escritor.write(0+"\n"); //Seu pacote
	            escritor.write(txtBanco.getText()+"\n");
	            escritor.write(txtSaldo.getText()+"\n");
	            escritor.write(txtAltura.getText()+"\n");
	            escritor.write(txtIdade.getText()+"\n");
	            escritor.write(sexo+"\n");
	            escritor.write(txtPeso.getText()+"\n");
	            escritor.write(txtPercentual.getText()+"\n");
	            escritor.write(txtPeso.getText()+"\n");
	            escritor.write(txtPercentual.getText()+"\n");
	            escritor.write(dataAtual.format(formatter)+"\n");
	            escritor.write(dataAtual.format(formatter)+"\n");
	            escritor.write(dataAtual.format(formatter));
	            escritor.close();
	        }	
	
		}
		
		catch(IOException e) {
			
		}
        
    }
    
    private void acoes() {
	    btnProximo.addMouseListener(new MouseAdapter() {
	    	@Override
	    	public void mouseClicked(MouseEvent e) {
	    		String[] options = {"Sim","Ainda não"};
	    		int x = JOptionPane.showOptionDialog(null, " \"Tem certeza?","Confirmação", JOptionPane.DEFAULT_OPTION, 0, null, options, options[0]);
	    		if(x==0) {
	    			
		    		if(layer1.isVisible()) {
		    			
		    			if(txtInsiraSuaSenha.getText().isEmpty() || usernameField.getText().isEmpty() || txtRepitaSuaSenha.getText().isEmpty())
		    			JOptionPane.showMessageDialog(null, "Preencha tudo!!");
		    			
		    			else if(txtInsiraSuaSenha.getText().equals(txtRepitaSuaSenha.getText()) ) {
		    			File arquivoExiste = new File(System.getProperty("user.dir")+"/src/clientes/"+usernameField.getText()+".txt");
		    			   if(!arquivoExiste.exists()) {
		    				layer1.setVisible(false);
			    			layer2.setVisible(true);	
		    			   }
		    			   else
		    				JOptionPane.showMessageDialog(null, "Usuario ja existe!!");   
		    			
		    			}
		    			else
		    				JOptionPane.showMessageDialog(null, "Senhas não são identicas");
		    		}
		    		
		    		else if(layer2.isVisible()) {
		    			

		    			try {
		    			double testar = Double.parseDouble(txtSaldo.getText());	
		    			if(txtBanco.getText().isEmpty() || txtSaldo.getText().isEmpty() )
			    			JOptionPane.showMessageDialog(null, "Preencha tudo!!");
		    			else {
		    			layer2.setVisible(false);
		    			layer3.setVisible(true);
		    			}
		    			}
		    			catch(NumberFormatException a) {
		    				JOptionPane.showMessageDialog(null, a);
		    			}
		    		
		    		}
		    		else if(layer3.isVisible()) {
		    			
		    			layer3.setVisible(false);
		    			layer4.setVisible(true);
		    			
		    		}
		    		else {
		    			
		    			try {
		    			
		    			double testar = Double.parseDouble(txtPercentual.getText());
		    			double testar2 = Double.parseDouble(txtPeso.getText());
		    			int testar3 = Integer.parseInt(txtAltura.getText());
		    			int testar4 = Integer.parseInt(txtIdade.getText());
		    			
		    			if(txtIdade.getText().isEmpty() || txtAltura.getText().isEmpty() || txtPeso.getText().isEmpty())
			    			JOptionPane.showMessageDialog(null, "Preencha tudo!!");
		    			else {
		    			if(radioFrango.isSelected())
		    				tipoPlano=0;
		    			else if(radioMaromba.isSelected())
		    				tipoPlano=1;
		    			else if(radioGiga.isSelected())
		    				tipoPlano=2;
		    			

		    			if(radioM.isSelected())
		    				sexo = 'M';
		    			else if(radioF.isSelected())
		    				sexo = 'F';
		    			
		    			salvarUsuario();
		    			Principal c1 = new Principal();
		    			c1.setVisible(true);
		    			frame.dispose();
		    			}
		    			}
		    			catch(NumberFormatException a) {
		    				JOptionPane.showMessageDialog(null, "Insira numeros reais nos devidos campos");
		    			}
		    		}
		    		
	    		}
	    			
	    	}
	    	public void mouseExited(MouseEvent e) {
	    		btnProximo.setForeground(Color.WHITE);	
	    	}
	    	public void mouseEntered(MouseEvent e) {
	    		btnProximo.setForeground(Color.DARK_GRAY);	
	    	}});
	    
        lblRetorna.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		Principal c1 = new Principal();
        		c1.setVisible(true);
        		frame.dispose();
            	
        	}
        });
        
        radioFrango.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        			radioMaromba.setSelected(false);
        			radioGiga.setSelected(false);
        			radioFrango.setSelected(true);
        	}
        });
        radioMaromba.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
    			radioMaromba.setSelected(true);
    			radioGiga.setSelected(false);
    			radioFrango.setSelected(false);
    	}
    });
        radioGiga.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        			radioMaromba.setSelected(false);
        			radioGiga.setSelected(true);
        			radioFrango.setSelected(false);
        	}
        });
    
        radioM.addActionListener(new ActionListener() {
         	public void actionPerformed(ActionEvent e) {

    			radioM.setSelected(true);
    			radioF.setSelected(false);
         	}
         });
        radioF.addActionListener(new ActionListener() {
         	public void actionPerformed(ActionEvent e) {

    			radioF.setSelected(true);
    			radioM.setSelected(false);
         	}
         });    
    }
    
    
    
    private void inicializarLayers() {
    	
    	layer1 = new JPanel();
        layer1.setBackground(new Color(0, 0, 0, 0));
        layer1.setBounds(103, 229, 562, 239);
        layer1.setLayout(null);
        layer1.setOpaque(false);
        layer1.setLocation(900/2-562/2, 229);
        frame.getContentPane().add(layer1);
       
        layer2 = new JPanel();
        layer2.setLayout(null);
        layer2.setBackground(new Color(0, 0, 0, 0));
        layer2.setBounds(162, 230, 562, 239);
        layer2.setOpaque(false);
        layer2.setVisible(false);
        frame.getContentPane().add(layer2);
         
        layer3 = new JPanel();
        layer3.setBounds(63, 222, 772, 247);
        layer3.setBackground(new Color(0, 0, 0, 0));
        layer3.setLayout(null);
        layer3.setOpaque(false);
        layer3.setVisible(false);
        frame.getContentPane().add(layer3);

        layer4 = new JPanel();
        layer4.setBounds(63, 222, 772, 247);
        layer4.setBackground(new Color(0, 0, 0, 0));
        layer4.setLayout(null);
        layer4.setOpaque(false);
        layer4.setVisible(false);
        frame.getContentPane().add(layer4);
        

        inicializarLayer1();
        inicializarLayer2();
        inicializarLayer3();
        inicializarLayer4();
       

    }
    
    private void inicializarLayer4() {
    	 JLabel lblAltura = new JLabel("Altura:");
    	 lblAltura.setHorizontalAlignment(SwingConstants.RIGHT);
         lblAltura.setForeground(Color.WHITE);
         lblAltura.setFont(f1);
         lblAltura.setBounds(30, 72, 113, 27);
         layer4.add(lblAltura);
         
         JLabel lblSexo = new JLabel("Sexo:");
         lblSexo.setHorizontalAlignment(SwingConstants.RIGHT);
         lblSexo.setForeground(Color.WHITE);
         lblSexo.setFont(f1);
         lblSexo.setBounds(30, 127, 113, 27);
         layer4.add(lblSexo);
         
         txtAltura = new JTextField();
         txtAltura.setToolTipText("Insira sua altura");
         txtAltura.setForeground(Color.BLACK);
         txtAltura.setFont(f2);
         txtAltura.setBackground(new Color(200, 255, 83,0));
         txtAltura.setBounds(160, 72, 137, 24);
         txtAltura.setOpaque(false);
         txtAltura.setBorder(null);
         layer4.add(txtAltura);
         
         //Field Images
         ImageIcon fieldImage = new ImageIcon(CadastroTela.class.getResource("/imagens/field.png"));
         Image img = fieldImage.getImage();
         Image imgRedimensionada = img.getScaledInstance(txtAltura.getBounds().width,24, Image.SCALE_SMOOTH);
         ImageIcon logoRedimensionada = new ImageIcon(imgRedimensionada);
         
         JLabel textBack = new JLabel(logoRedimensionada);
         textBack.setBounds(155, 72, txtAltura.getBounds().width, 24);
         textBack.setFocusable(false);
         layer4.add(textBack);
         
         radioM = new JRadioButton("Masculino");
         radioM.setHorizontalAlignment(SwingConstants.LEFT);
       
         radioM.setFont(f2);
         radioM.setForeground(Color.WHITE);
         radioM.setBounds(150, 129, 153, 23);
         radioM.setBackground(new Color(0,0,0,0));
         radioM.setOpaque(false);
         radioM.setBorderPainted(false);
         radioM.setFocusable(false);
         radioM.setSelected(true);
         layer4.add(radioM);

         radioF = new JRadioButton("Feminino");
         radioF.setHorizontalAlignment(SwingConstants.LEFT);
         radioF.setFont(f2);
         radioF.setForeground(Color.WHITE);
         radioF.setBounds(150, 161, 153, 23);
         radioF.setBackground(new Color(0,0,0,0));
         radioF.setOpaque(false);
         radioF.setBorderPainted(false);
         radioF.setFocusable(false);
         layer4.add(radioF);
         
         JLabel lblPeso = new JLabel("Peso:");
         lblPeso.setHorizontalAlignment(SwingConstants.RIGHT);
         lblPeso.setForeground(Color.WHITE);
         lblPeso.setFont(new Font("Dialog", Font.BOLD, 18));
         lblPeso.setBounds(452, 120, 81, 27);
         layer4.add(lblPeso);
         
         JLabel lblIdade = new JLabel("Idade:");
         lblIdade.setHorizontalAlignment(SwingConstants.RIGHT);
         lblIdade.setForeground(Color.WHITE);
         lblIdade.setFont(new Font("Dialog", Font.BOLD, 18));
         lblIdade.setBounds(452, 71, 81, 27);
         layer4.add(lblIdade);
         
         txtIdade = new JTextField();
         txtIdade.setToolTipText("Insira sua altura");
         txtIdade.setOpaque(false);
         txtIdade.setForeground(Color.BLACK);
         txtIdade.setFont(f2);
         txtIdade.setBorder(null);
         txtIdade.setBackground(new Color(200, 255, 83, 0));
         txtIdade.setBounds(551, 75, 137, 24);
         layer4.add(txtIdade);
         
         JLabel textBack2 = new JLabel(logoRedimensionada);
         textBack2.setFocusable(false);
         textBack2.setBounds(542, 75, 137, 24);
         layer4.add(textBack2);
         
         txtPeso = new JTextField();
         txtPeso.setToolTipText("Insira sua altura");
         txtPeso.setOpaque(false);
         txtPeso.setForeground(Color.BLACK);
         txtPeso.setFont(f2);
         txtPeso.setBorder(null);
         txtPeso.setBackground(new Color(200, 255, 83, 0));
         txtPeso.setBounds(551, 120, 137, 24);
         layer4.add(txtPeso);
         
         JLabel textBack3 = new JLabel(logoRedimensionada);
         textBack3.setFocusable(false);
         textBack3.setBounds(542, 120, 137, 24);
         layer4.add(textBack3);
         
         JLabel lblPercentualGordura = new JLabel("Percentual Gordura:");
         lblPercentualGordura.setHorizontalAlignment(SwingConstants.RIGHT);
         lblPercentualGordura.setForeground(Color.WHITE);
         lblPercentualGordura.setFont(new Font("Dialog", Font.BOLD, 18));
         lblPercentualGordura.setBounds(336, 170, 197, 27);
         layer4.add(lblPercentualGordura);
         
         txtPercentual = new JTextField();
         txtPercentual.setToolTipText("Insira sua altura");
         txtPercentual.setOpaque(false);
         txtPercentual.setForeground(Color.BLACK);
         txtPercentual.setFont(f2);
         txtPercentual.setBorder(null);
         txtPercentual.setBackground(new Color(200, 255, 83, 0));
         txtPercentual.setBounds(551, 170, 137, 24);
         layer4.add(txtPercentual);
         
         JLabel textBack4 = new JLabel(logoRedimensionada);
         textBack4.setFocusable(false);
         textBack4.setBounds(542, 170, 137, 24);
         layer4.add(textBack4);
         
         
    }
    
    private void inicializarLayer3() {
    	
    	radioFrango = new JRadioButton("Plano Frango");
        radioFrango.setFont(f1);
        radioFrango.setForeground(Color.WHITE);
        radioFrango.setBounds(41, 46, 168, 23);
        radioFrango.setSelected(true);
        radioFrango.setBackground(new Color(0,0,0,0));
        radioFrango.setOpaque(false);
        radioFrango.setBorderPainted(false);
        radioFrango.setFocusable(false);
        layer3.add(radioFrango);
        
        radioMaromba = new JRadioButton("Plano Maromba");
        radioMaromba.setForeground(Color.WHITE);
        radioMaromba.setFont(f1);
        radioMaromba.setBackground(new Color(0, 0, 0, 0));
        radioMaromba.setBounds(299, 46, 187, 23);
        radioMaromba.setOpaque(false);
        radioMaromba.setBorderPainted(false);
        radioMaromba.setBorder(null);
        radioMaromba.setFocusable(false);
        layer3.add(radioMaromba);
        
        radioGiga = new JRadioButton("Plano Cavalo");
        radioGiga.setForeground(Color.WHITE);
        radioGiga.setFont(f1);
        radioGiga.setBackground(new Color(0, 0, 0, 0));
        radioGiga.setBounds(549, 46, 187, 23);
        radioGiga.setOpaque(false);
        radioGiga.setBorderPainted(false);
        radioGiga.setFocusable(false);
        layer3.add(radioGiga);
        
        lblFrango = new JLabel("<html>Mensalidade: R$49,99 <br/>\r\nBeneficios:<br/>\r\n- Uso dos equipamentos da academia</html>");
        lblFrango.setFont(f4);
        lblFrango.setForeground(Color.WHITE);
        lblFrango.setBounds(41, 78, 168, 113);
        
        layer3.add(lblFrango);
        
        JLabel lblmensalidadeRBeneficios = new JLabel("<html>Mensalidade: R$79,99 <br/>\r\nBeneficios: <br/>\r\n- Personal Trainner qualificado\r\n<br/>- Brindes todo mês</html>");
        lblmensalidadeRBeneficios.setForeground(Color.WHITE);
        lblmensalidadeRBeneficios.setFont(f4);
        lblmensalidadeRBeneficios.setBounds(299, 87, 168, 113);
        layer3.add(lblmensalidadeRBeneficios);
        
        JLabel lblmensalidadeRBeneficios_1 = new JLabel("<html>Mensalidade: R$99,99 <br/>\r\nBeneficios: <br/>\r\n- Beneficios plano maromba <br/>\r\n- Acesso a equipe medica e descontos no bar</html>");
        lblmensalidadeRBeneficios_1.setForeground(Color.WHITE);
        lblmensalidadeRBeneficios_1.setFont(f4);
        lblmensalidadeRBeneficios_1.setBounds(549, 87, 168, 149);
        layer3.add(lblmensalidadeRBeneficios_1);
        

    	
    }
     
    private void inicializarLayer1() {
    	
    	JLabel lblSenha = new JLabel("Senha:");
    	lblSenha.setHorizontalAlignment(SwingConstants.RIGHT);
        lblSenha.setForeground(Color.WHITE);
        lblSenha.setFont(f1);
        lblSenha.setBounds(102, 97, 92, 27);
        layer1.add(lblSenha);

        JLabel lblRepitaASenha = new JLabel("Repita a senha:");
        lblRepitaASenha.setHorizontalAlignment(SwingConstants.RIGHT);
        lblRepitaASenha.setForeground(Color.WHITE);
        lblRepitaASenha.setFont(f1);
        lblRepitaASenha.setBounds(22, 140, 172, 24);
        layer1.add(lblRepitaASenha);

        JLabel lblUsuario = new JLabel("Usuário:");
        lblUsuario.setHorizontalAlignment(SwingConstants.RIGHT);
        lblUsuario.setForeground(Color.WHITE);
        lblUsuario.setFont(f1);
        lblUsuario.setBounds(78, 56, 116, 27);
        layer1.add(lblUsuario);

        txtRepitaSuaSenha = new JPasswordField();
        txtRepitaSuaSenha.setEchoChar('*');
        txtRepitaSuaSenha.setToolTipText("Repita sua senha");
        txtRepitaSuaSenha.setBackground(new Color(200, 255, 83,0));
        txtRepitaSuaSenha.setForeground(Color.BLACK);
        txtRepitaSuaSenha.setFont(f2);
        txtRepitaSuaSenha.setBounds(209, 141, 321, 24);
        txtRepitaSuaSenha.setOpaque(false);
        txtRepitaSuaSenha.setForeground(Color.BLACK);
        txtRepitaSuaSenha.setBorder(null);
    
        layer1.add(txtRepitaSuaSenha);

        txtInsiraSuaSenha = new JPasswordField();
        txtInsiraSuaSenha.setEchoChar('*');
        txtInsiraSuaSenha.setToolTipText("Insira sua senha");
        txtInsiraSuaSenha.setBackground(new Color(200, 255, 83,0));
        txtInsiraSuaSenha.setBounds(209, 99, 321, 24);
        txtInsiraSuaSenha.setForeground(Color.BLACK);
        txtInsiraSuaSenha.setOpaque(false);
        txtInsiraSuaSenha.setBorder(null);
        txtInsiraSuaSenha.setFont(f2);
        layer1.add(txtInsiraSuaSenha);
        
        ImageIcon fieldImage = new ImageIcon(CadastroTela.class.getResource("/imagens/field.png"));
        Image img = fieldImage.getImage();
        Image imgRedimensionada = img.getScaledInstance(321,24, Image.SCALE_SMOOTH);
        ImageIcon logoRedimensionada = new ImageIcon(imgRedimensionada);
        
        
        usernameField = new JTextField();
        usernameField.setBounds(209, 58, 321, 24);
        usernameField.setFont(f2);
        usernameField.setBackground(new Color(200, 255, 83,0));
        usernameField.setOpaque(false);
        usernameField.setForeground(Color.BLACK);
        usernameField.setBorder(null);
        usernameField.setToolTipText("Insira seu usuário");
        layer1.add(usernameField);
        
        JLabel textBack = new JLabel(logoRedimensionada);
        textBack.setBounds(200,58,321,24);
        textBack.setFocusable(false);
        layer1.add(textBack);
        
        JLabel textBack2 = new JLabel(logoRedimensionada);
        textBack2.setBounds(200,99,321,24);
        textBack2.setFocusable(false);
        layer1.add(textBack2);
        JLabel textBack3 = new JLabel(logoRedimensionada);
        textBack3.setBounds(200,141,321,24);
        textBack3.setFocusable(false);
        layer1.add(textBack3);
        
    }
    
    private void inicializarLayer2() {
    	 JLabel lblBanco = new JLabel("Banco:");
         lblBanco.setForeground(Color.WHITE);
         lblBanco.setFont(f1);
         lblBanco.setBounds(96, 72, 69, 27);
         layer2.add(lblBanco);
         
         JLabel lblSaldo = new JLabel("Saldo:");
         lblSaldo.setForeground(Color.WHITE);
         lblSaldo.setFont(f1);
         lblSaldo.setBounds(96, 127, 69, 27);
         layer2.add(lblSaldo);
         
         txtBanco = new JTextField();
         txtBanco.setToolTipText("Insira seu usuário");
         txtBanco.setText("NU Bank Seguros");
         txtBanco.setForeground(Color.BLACK);
         txtBanco.setFont(f2);
         txtBanco.setBackground(new Color(200, 255, 83,0));
         txtBanco.setBounds(175, 72, 321, 24);
         txtBanco.setOpaque(false);
         txtBanco.setBorder(null);
         layer2.add(txtBanco);
         
         txtSaldo = new JTextField();
         txtSaldo.setToolTipText("Insira seu usuário");
         txtSaldo.setText("299.99");
         txtSaldo.setForeground(Color.BLACK);
         txtSaldo.setFont(f2);
         txtSaldo.setBackground(new Color(200, 255, 83,0));
         txtSaldo.setBounds(175, 127, 321, 24);
         txtSaldo.setBorder(null);
         txtSaldo.setOpaque(false);
         layer2.add(txtSaldo);
         
         JLabel lblInsiraSuasInformaes = new JLabel("Insira suas informações bancarias");
         lblInsiraSuasInformaes.setForeground(Color.WHITE);
         lblInsiraSuasInformaes.setFont(new Font("Noto Mono", Font.BOLD | Font.ITALIC, 15));
         lblInsiraSuasInformaes.setBounds(160, 26, 379, 35);
         layer2.add(lblInsiraSuasInformaes);
         
         ImageIcon fieldImage = new ImageIcon(CadastroTela.class.getResource("/imagens/field.png"));
         Image img = fieldImage.getImage();
         Image imgRedimensionada = img.getScaledInstance(321,24, Image.SCALE_SMOOTH);
         ImageIcon logoRedimensionada = new ImageIcon(imgRedimensionada);
         
         JLabel textField = new JLabel(logoRedimensionada);
         textField.setBounds(166,72,321,24);
         textField.setFocusable(false);
         layer2.add(textField);

         JLabel textField2 = new JLabel(logoRedimensionada);
         textField2.setBounds(166,127,321,24);
         textField2.setFocusable(false);
         layer2.add(textField2);
         
    }
   
    private void initialize() {
        frame = new JFrame();
        frame.setResizable(false);
        frame.setBounds(100, 100, 900, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.setTitle("Cadastro");
        
        lblRetorna = new JLabel("<");
        lblRetorna.setFont(new Font("Comic Sans MS", Font.PLAIN, 45));
        lblRetorna.setForeground(new Color(255, 255, 255));
        lblRetorna.setBounds(36, 21, 41, 37);
        frame.getContentPane().add(lblRetorna);
        ImageIcon logoImage = new ImageIcon(CadastroTela.class.getResource("/imagens/logo.png"));
        Image img = logoImage.getImage();
        Image imgRedimensionada = img.getScaledInstance(440,160, Image.SCALE_SMOOTH);
        ImageIcon logoRedimensionada = new ImageIcon(imgRedimensionada);
        lblFacaSeuCadastro = new JLabel(logoRedimensionada);
        lblFacaSeuCadastro.setBounds(258, 65, 440, 160);
        frame.getContentPane().add(lblFacaSeuCadastro);
        JLabel lblFicha = new JLabel("Ficha de Inscrição");
        lblFicha.setForeground(new Color(200, 255, 83));
        lblFicha.setFont(new Font("Source Serif Pro", Font.ITALIC, 18));
        lblFicha.setBounds(397, 185, 160, 22);
        frame.getContentPane().add(lblFicha);


        inicializarFontes();
        inicializarLayers();
        
        btnProximo = new JLabel("PROXIMO");
        btnProximo.setForeground(Color.WHITE);
        btnProximo.setFont(f3);
        btnProximo.setBackground(new Color(0, 0, 0, 0));
        btnProximo.setBounds(390, 479, 170, 37);
        frame.getContentPane().add(btnProximo);

        
        ImageIcon bgImage = new ImageIcon(CadastroTela.class.getResource("/imagens/BackGround.png"));
        labelBackground = new JLabel(bgImage);
        labelBackground.setLocation(0, 0);
        labelBackground.setSize(900, 600);
        frame.getContentPane().add(labelBackground);
        
		Image cursorImage = Toolkit.getDefaultToolkit().getImage(System.getProperty("user.dir")+"/src/imagens/cursor.png");
        Cursor customCursor = Toolkit.getDefaultToolkit().createCustomCursor(cursorImage, new Point(0, 0), "cursor");

		Image cursorImage2 = Toolkit.getDefaultToolkit().getImage(System.getProperty("user.dir")+"/src/imagens/cursor2.png");
        Cursor customCursor2 = Toolkit.getDefaultToolkit().createCustomCursor(cursorImage2, new Point(0, 0), "cursor");
        frame.setCursor(customCursor);
        btnProximo.setCursor(customCursor2);
        usernameField.setCursor(customCursor2);
        txtInsiraSuaSenha.setCursor(customCursor2);
        txtRepitaSuaSenha.setCursor(customCursor2);
        txtBanco.setCursor(customCursor2);
        txtSaldo.setCursor(customCursor2);
        txtIdade.setCursor(customCursor2);
        txtPercentual.setCursor(customCursor2);
        txtPeso.setCursor(customCursor2);
        txtAltura.setCursor(customCursor2);
        radioFrango.setCursor(customCursor2);
        radioGiga.setCursor(customCursor2);
        radioMaromba.setCursor(customCursor2);
        radioM.setCursor(customCursor2);
        radioF.setCursor(customCursor2);
        
        
        acoes();
        //Centralizando


        
    }
}