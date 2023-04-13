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

public class MedicoCadastroTela {

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
    
	private Font f1,f2,f3,f4;
    
    public MedicoCadastroTela() {
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
        File arquivo = new File(System.getProperty("user.dir")+"/src/medicos/"+usernameField.getText()+".txt");

		try{
	    
			try (FileWriter escritor = new FileWriter(arquivo,true)) {
	            escritor.write(usernameField.getText()+"\n");
	            escritor.write(txtInsiraSuaSenha.getText()+"\n");
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
	    			
		   			if(txtInsiraSuaSenha.getText().isEmpty() || usernameField.getText().isEmpty() || txtRepitaSuaSenha.getText().isEmpty())
		   			JOptionPane.showMessageDialog(null, "Preencha tudo!!");
		    			
		   			else if(txtInsiraSuaSenha.getText().equals(txtRepitaSuaSenha.getText()) ) {
		   			File arquivoExiste = new File(System.getProperty("user.dir")+"/src/medicos/"+usernameField.getText()+".txt");
		    			   if(!arquivoExiste.exists()) {
		    					salvarUsuario();
				    			Principal c1 = new Principal();
				    			c1.setVisible(true);
				    			frame.dispose();
				    		   
		    			   }
		    			   else
		    				JOptionPane.showMessageDialog(null, "Usuario ja existe!!");   
		    			
		    			}
		    			else
		    				JOptionPane.showMessageDialog(null, "Senhas não são identicas");
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
            }
    
    
    
    private void inicializarLayers() {
    	
    	layer1 = new JPanel();
        layer1.setBackground(new Color(0, 0, 0, 0));
        layer1.setBounds(103, 229, 562, 239);
        layer1.setLayout(null);
        layer1.setOpaque(false);
        layer1.setLocation(900/2-562/2, 229);
        frame.getContentPane().add(layer1);
               

        inicializarLayer1();
       

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
        
        ImageIcon fieldImage = new ImageIcon(MedicoCadastroTela.class.getResource("/Imagens/field.png"));
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
    
       
    private void initialize() {
        frame = new JFrame();
        frame.setResizable(false);
        frame.setBounds(100, 100, 900, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.setTitle("Cadastro Médico");
        
        lblRetorna = new JLabel("<");
        lblRetorna.setFont(new Font("Comic Sans MS", Font.PLAIN, 45));
        lblRetorna.setForeground(new Color(255, 255, 255));
        lblRetorna.setBounds(36, 21, 41, 37);
        frame.getContentPane().add(lblRetorna);
        ImageIcon logoImage = new ImageIcon(MedicoCadastroTela.class.getResource("/Imagens/logo.png"));
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
        
        btnProximo = new JLabel("CADASTRAR");
        btnProximo.setForeground(Color.WHITE);
        btnProximo.setFont(f3);
        btnProximo.setBackground(new Color(0, 0, 0, 0));
        btnProximo.setBounds(390, 479, 170, 37);
        frame.getContentPane().add(btnProximo);

        
        ImageIcon bgImage = new ImageIcon(MedicoCadastroTela.class.getResource("/imagens/BackGround.png"));
        labelBackground = new JLabel(bgImage);
        labelBackground.setLocation(0, 0);
        labelBackground.setSize(900, 600);
        frame.getContentPane().add(labelBackground);
        
		Image cursorImage = Toolkit.getDefaultToolkit().getImage(System.getProperty("user.dir")+"/src/Imagens/cursor.png");
        Cursor customCursor = Toolkit.getDefaultToolkit().createCustomCursor(cursorImage, new Point(0, 0), "cursor");

		Image cursorImage2 = Toolkit.getDefaultToolkit().getImage(System.getProperty("user.dir")+"/src/Imagens/cursor2.png");
        Cursor customCursor2 = Toolkit.getDefaultToolkit().createCustomCursor(cursorImage2, new Point(0, 0), "cursor");
        frame.setCursor(customCursor);
        btnProximo.setCursor(customCursor2);
        usernameField.setCursor(customCursor2);
        txtInsiraSuaSenha.setCursor(customCursor2);
        txtRepitaSuaSenha.setCursor(customCursor2);
        
        acoes();
        //Centralizando


        
    }
}