package academia;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import classes.Medico;
import classes.Usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import javax.swing.Icon;

public class PrincipalMed extends JFrame {

	private JPanel contentPane;
	private JLabel lblBackground;
	private JLabel lblLogo;
	private JButton btnEntrar;
	private JButton btnCadastrar;
	private JLabel btnAdmin;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrincipalMed frame = new PrincipalMed();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private void acoesBotao() {
		btnEntrar.addMouseListener(new MouseAdapter() {
			
			public void mouseEntered(MouseEvent e) {
				btnEntrar.setBackground(new Color(224, 255, 83));	
			}
			public void mouseExited(MouseEvent e) {
				btnEntrar.setBackground(new Color(200, 255, 83));
			}
			
			public void mouseClicked(MouseEvent e) {
				MedicoLoginTela c1 = new MedicoLoginTela();
				c1.frame.setVisible(true);
				dispose();
				
			}
		});
		
		btnCadastrar.addMouseListener(new MouseAdapter() {
			
			public void mouseEntered(MouseEvent e) {
				btnCadastrar.setBackground(new Color(224, 255, 83));	
			}
			public void mouseExited(MouseEvent e) {
				btnCadastrar.setBackground(new Color(200, 255, 83));
			}
			
			public void mouseClicked(MouseEvent e) {
			
				MedicoCadastroTela c1 = new MedicoCadastroTela();
				c1.frame.setVisible(true);
				dispose();
			}
		});
		
		btnAdmin.addMouseListener(new MouseAdapter() {
			
			public void mouseEntered(MouseEvent e) {
				ImageIcon adminImage = new ImageIcon(getClass().getResource("/imagens/admin2.png"));
				Image imgRedimensionada = adminImage.getImage().getScaledInstance(100,90, Image.SCALE_SMOOTH);
				adminImage = new ImageIcon(imgRedimensionada);
				btnAdmin.setIcon(adminImage);
				
			}
			public void mouseExited(MouseEvent e) {
				ImageIcon adminImage = new ImageIcon(getClass().getResource("/imagens/admin.png"));
				Image imgRedimensionada = adminImage.getImage().getScaledInstance(100,90, Image.SCALE_SMOOTH);
				adminImage = new ImageIcon(imgRedimensionada);
				btnAdmin.setIcon(adminImage);
				
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int x = JOptionPane.showConfirmDialog(null, "Deseja voltar ao menu usuário?");
				
				
				if(x==0) {
					Principal c1 = new Principal();
					c1.setVisible(true);
					dispose();
				}
				
			}
		});
	
	
	}
	
	public PrincipalMed() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setTitle("Menu Principal");
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ImageIcon logoImage = new ImageIcon(getClass().getResource("/imagens/logoMed.png"));
		lblLogo = new JLabel(logoImage);
		lblLogo.setBounds(243,51,600,300);
		lblLogo.setLocation((900/2)-(600/2),10);
		contentPane.add(lblLogo);
		
		btnEntrar = new JButton("Entrar");
		btnEntrar.setFont(new Font("Noto Mono", Font.BOLD, 18));
		btnEntrar.setBounds(367, 300, 146, 51);
		btnEntrar.setBorder(null);
		btnEntrar.setLocation(900/2-(167/2), 300);
		btnEntrar.setBackground(new Color(200, 255, 83));
		btnEntrar.setFocusable(false);
		contentPane.add(btnEntrar);

		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setFont(new Font("Noto Mono", Font.BOLD, 18));
		btnCadastrar.setFocusable(false);
		btnCadastrar.setBorder(null);
		btnCadastrar.setBackground(new Color(200, 255, 83));
		btnCadastrar.setBounds(367,300,146,51);
		btnCadastrar.setLocation(900/2-(167/2), 400);
		contentPane.add(btnCadastrar);
		
		ImageIcon adminImage = new ImageIcon(getClass().getResource("/imagens/admin.png"));
		Image imgRedimensionada = adminImage.getImage().getScaledInstance(100,90, Image.SCALE_SMOOTH);
		adminImage = new ImageIcon(imgRedimensionada);
		btnAdmin = new JLabel(adminImage);
		btnAdmin.setBounds(725, 435, 100, 90);
		contentPane.add(btnAdmin);
		
		Image cursorImage = Toolkit.getDefaultToolkit().getImage(System.getProperty("user.dir")+"/src/imagens/cursor.png");
        Cursor customCursor = Toolkit.getDefaultToolkit().createCustomCursor(cursorImage, new Point(0, 0), "cursor");

		Image cursorImage2 = Toolkit.getDefaultToolkit().getImage(System.getProperty("user.dir")+"/src/imagens/cursor2.png");
        Cursor customCursor2 = Toolkit.getDefaultToolkit().createCustomCursor(cursorImage2, new Point(0, 0), "cursor");
        setCursor(customCursor);
        btnEntrar.setCursor(customCursor2);
        btnCadastrar.setCursor(customCursor2);
        btnAdmin.setCursor(customCursor2);

		ImageIcon backImage = new ImageIcon(getClass().getResource("/imagens/BackGround.png"));
		lblBackground = new JLabel(backImage);
		lblBackground.setBounds(0,0,900,600);
		contentPane.add(lblBackground);
		acoesBotao();
	}
}
