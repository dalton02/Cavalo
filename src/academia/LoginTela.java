package academia;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
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
        lblSenha.setFont(new Font("Noto Mono", Font.BOLD, 18));
        lblSenha.setBounds(101, 119, 93, 27);
        layer1.add(lblSenha);

        lblUsuario = new JLabel("Usuário:");
        lblUsuario.setHorizontalAlignment(SwingConstants.RIGHT);
        lblUsuario.setForeground(Color.WHITE);
        lblUsuario.setFont(new Font("Noto Mono", Font.BOLD, 18));
        lblUsuario.setBounds(77, 69, 117, 27);
        layer1.add(lblUsuario);

        txtInsiraSuaSenha = new JPasswordField();
        txtInsiraSuaSenha.setToolTipText("Insira sua senha");
        txtInsiraSuaSenha.setBackground(new Color(200, 255, 83,0));
        txtInsiraSuaSenha.setBounds(209, yCentro, 321, 24);
        txtInsiraSuaSenha.setForeground(Color.BLACK);
        txtInsiraSuaSenha.setOpaque(false);
        txtInsiraSuaSenha.setBorder(null);
       
        txtInsiraSuaSenha.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 16));
        layer1.add(txtInsiraSuaSenha);
        
        ImageIcon fieldImage = new ImageIcon(LoginTela.class.getResource("/Imagens/field.png"));
        Image img = fieldImage.getImage();
        Image imgRedimensionada = img.getScaledInstance(321,24, Image.SCALE_SMOOTH);
        ImageIcon logoRedimensionada = new ImageIcon(imgRedimensionada);
        
        
        JTextField usernameField = new JTextField();
        usernameField.setBounds(209, yCentro-50, 321, 24);
        usernameField.setFont(new Font("Leelawadee UI", Font.BOLD | Font.ITALIC, 16));
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
	    		GerenciarAcademia c1 = new GerenciarAcademia();
	    		c1.setVisible(true);
	    		frame.dispose();
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