package academia;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;

public class Principal extends JFrame {

	private JPanel contentPane;
	private JLabel lblBackground;
	private JLabel lblLogo;
	private JButton btnEntrar;
	private JButton btnCadastrar;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
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
				LoginTela c1 = new LoginTela();
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
			
				CadastroTela c1 = new CadastroTela();
				c1.frame.setVisible(true);
				dispose();
			}
		});
	
	
	}
	
	public Principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ImageIcon logoImage = new ImageIcon(getClass().getResource("/Imagens/logo.png"));
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
		
		ImageIcon backImage = new ImageIcon(getClass().getResource("/Imagens/BackGround.png"));
		lblBackground = new JLabel(backImage);
		lblBackground.setBounds(0,0,900,600);
		contentPane.add(lblBackground);	
		lblBackground.setFocusable(true);
		
		acoesBotao();
	}
}
