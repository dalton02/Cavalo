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
import java.io.IOException;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class LoginTela {

    public JFrame frame;
    private JTextField usernameField;
    private JPasswordField txtInsiraSuaSenha;
    private JLabel lblFacaSeuCadastro;
    private JLabel lblUsuario;
    private JLabel lblSenha;
    private JLabel btnProximo;
    private JLabel labelBackground;
    private JLabel lblRetorna;
    private JPanel layer1;
    private Font f1,f2,f3;
    
    private void inicializarFontes() {
    	
    	File fontFile = new File(System.getProperty("user.dir")+"/src/Fontes/arvo.ttf");
		File fontFile2 = new File(System.getProperty("user.dir")+"/src/Fontes/arvoI.ttf");
		
		try {
			f1 = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream(fontFile)).deriveFont(Font.PLAIN, 18);
			f2 = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream(fontFile2)).deriveFont(Font.PLAIN, 18);
			f3 = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream(fontFile)).deriveFont(Font.PLAIN, 14);
			
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
    
    
    public LoginTela() {
    	initialize();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
    
    private void inicializarLayers() {
    	layer1 = new JPanel();
        layer1.setBackground(new Color(0, 0, 0, 0));
        layer1.setBounds(103, 229, 562, 239);
        layer1.setLayout(null);
        layer1.setOpaque(false);
        layer1.setLocation(900/2-562/2, 229);
        frame.getContentPane().add(layer1);

    }
    
    private void inicializarLayer1() {
    	
    	int yCentro = layer1.getBounds().height/2;
    	lblSenha = new JLabel("Senha:");
    	lblSenha.setHorizontalAlignment(SwingConstants.RIGHT);
        lblSenha.setForeground(Color.WHITE);
        lblSenha.setFont(f1);
        lblSenha.setBounds(101, 119, 93, 27);
        layer1.add(lblSenha);

        lblUsuario = new JLabel("Usuário:");
        lblUsuario.setHorizontalAlignment(SwingConstants.RIGHT);
        lblUsuario.setForeground(Color.WHITE);
        lblUsuario.setFont(f1);
        lblUsuario.setBounds(77, 69, 117, 27);
        layer1.add(lblUsuario);

        txtInsiraSuaSenha = new JPasswordField();
        txtInsiraSuaSenha.setEchoChar('*');
        txtInsiraSuaSenha.setToolTipText("Insira sua senha");
        txtInsiraSuaSenha.setBackground(new Color(200, 255, 83,0));
        txtInsiraSuaSenha.setBounds(209, yCentro, 321, 24);
        txtInsiraSuaSenha.setForeground(Color.BLACK);
        txtInsiraSuaSenha.setOpaque(false);
        txtInsiraSuaSenha.setBorder(null);
        txtInsiraSuaSenha.setFont(f2);
        layer1.add(txtInsiraSuaSenha);
        
        ImageIcon fieldImage = new ImageIcon(LoginTela.class.getResource("/Imagens/field.png"));
        Image img = fieldImage.getImage();
        Image imgRedimensionada = img.getScaledInstance(321,24, Image.SCALE_SMOOTH);
        ImageIcon logoRedimensionada = new ImageIcon(imgRedimensionada);
        
        
        usernameField = new JTextField();
        usernameField.setText("Muzzy");
        usernameField.setBounds(209, yCentro-50, 321, 24);
        usernameField.setFont(f2);
        usernameField.setBackground(new Color(200, 255, 83,0));
        usernameField.setOpaque(false);
        usernameField.setForeground(Color.BLACK);
        usernameField.setBorder(null);
        usernameField.setToolTipText("Insira seu usuário");
        layer1.add(usernameField);
        
        JLabel textBack = new JLabel(logoRedimensionada);
        textBack.setBounds(200,yCentro,321,24);
        textBack.setFocusable(false);
        layer1.add(textBack);
        
        JLabel textBack2 = new JLabel(logoRedimensionada);
        textBack2.setBounds(200,yCentro-50,321,24);
        textBack2.setFocusable(false);
        layer1.add(textBack2);
        
	
    }
    
    private void logar() {
    	
    	btnProximo.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseEntered(MouseEvent e) {
    			btnProximo.setForeground(Color.DARK_GRAY);
        	}
	    	public void mouseExited(MouseEvent e) {
		    		btnProximo.setForeground(Color.WHITE);		        		
        	}
	    	public void mouseClicked(MouseEvent e) {
	    		
	    		File arquivo = new File(System.getProperty("user.dir")+"/src/Textos/"+usernameField.getText()+".txt");
	             
	    		if(arquivo.exists()) {
	    			boolean liberado=false;
	    			FileReader fileReader;
					try {
					fileReader = new FileReader(arquivo);
					BufferedReader bufferedReader = new BufferedReader(fileReader);
		            String linha;
		            int i=0;
		            while ((linha = bufferedReader.readLine()) != null) {
		               if(i==1 && linha.equals(txtInsiraSuaSenha.getText())) {
		           	   liberado=true;
		               }
		               i++;
		             }
		             fileReader.close();
		             bufferedReader.close();
					}
					catch (FileNotFoundException e1) {
						e1.printStackTrace();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					if(liberado) {
			    		GerenciarAcademia c1 = new GerenciarAcademia(arquivo);
			    		c1.setVisible(true);
			    		frame.dispose();		
					}		
					else
						JOptionPane.showMessageDialog(null,"Senha errada");
	    		}
	    		else 
	    			JOptionPane.showMessageDialog(null, "Usuario não existe");
	    	}
        });
        
    	
        lblRetorna.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		Principal c1 = new Principal();
        		c1.setVisible(true);
        		frame.dispose();
            	
        	}
        });
    	
    }
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 900, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.getContentPane().setLayout(null);
        frame.setTitle("Cadastro");
        
        lblRetorna = new JLabel("<");
        lblRetorna.setFont(new Font("Comic Sans MS", Font.PLAIN, 45));
        lblRetorna.setForeground(new Color(255, 255, 255));
        lblRetorna.setBounds(36, 21, 41, 37);
        frame.getContentPane().add(lblRetorna);
        ImageIcon logoImage = new ImageIcon(LoginTela.class.getResource("/Imagens/logo.png"));
        Image img = logoImage.getImage();
        Image imgRedimensionada = img.getScaledInstance(440,160, Image.SCALE_SMOOTH);
        ImageIcon logoRedimensionada = new ImageIcon(imgRedimensionada);
        lblFacaSeuCadastro = new JLabel(logoRedimensionada);
        lblFacaSeuCadastro.setBounds(258, 65, 440, 160);
        frame.getContentPane().add(lblFacaSeuCadastro);
        JLabel lblFicha = new JLabel("Faça seu login");
        lblFicha.setForeground(new Color(200, 255, 83));
        lblFicha.setFont(new Font("Source Serif Pro", Font.ITALIC, 18));
        lblFicha.setBounds(397, 185, 131, 22);
        frame.getContentPane().add(lblFicha);

    	btnProximo = new JLabel("LOGAR");
        btnProximo.setForeground(Color.WHITE);
        btnProximo.setFont(new Font("Comic Sans MS", Font.BOLD, 26));
        btnProximo.setBackground(new Color(0, 0, 0, 0));
        btnProximo.setBounds(frame.getBounds().width/2 - 103/2, 479, 103, 37);
        frame.getContentPane().add(btnProximo);

        inicializarFontes();
        inicializarLayers();
        inicializarLayer1();
       
        ImageIcon bgImage = new ImageIcon(LoginTela.class.getResource("/Imagens/BackGround.png"));
        labelBackground = new JLabel(bgImage);
        labelBackground.setLocation(0, 0);
        labelBackground.setSize(900, 600);
        frame.getContentPane().add(labelBackground);

        logar();
        
    }
}