package academia;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import classes.Usuario;

import classes.Medico;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdministradorTela {

	public JFrame frame;
	private JTextField txtUsuario;
	private JTextArea txtrUsuarioPesoAltura;
	private JButton btnProcurar;
	private JButton btnMudarAltura;
	private JButton btnMudarIdade;
	private JButton btnMudarPeso;
	private JButton btnMudarPercentual;
	private Medico medico;
	
	public AdministradorTela(Medico medico) {
		this.medico = medico;
		initialize();
	}


	private void modificarLinha(int linhaModificada,String textoNovo,File userFile) {
		
		try {
			FileReader userReader = new FileReader(userFile);
			BufferedReader userBuffer = new BufferedReader(userReader);
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
	
	
	
	private ArrayList<String> lerArquivo(String usuario) {
		
		ArrayList<String> linhas = new ArrayList<>();
		File arquivo = new File(System.getProperty("user.dir")+"/src/clientes/"+usuario+".txt");

		if(!arquivo.exists()) {
        	
        	JOptionPane.showMessageDialog(null,"Esse usuario não existe");
        	
        }
        else {
		
		try {
			FileReader userReader = new FileReader(arquivo);
			BufferedReader userBuffer = new BufferedReader(userReader);
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
       
        }
        return linhas;
	}
	
	private boolean gerarBusca(ArrayList<String> dados) {
		if(!dados.isEmpty()) {
		txtrUsuarioPesoAltura.setText("Usuario:   "+dados.get(0)
				+ "\r\nPeso:   " +dados.get(11)
				+ "KG\r\nAltura:  "+dados.get(6)
				+ " CENTIMETROS\r\nIdade:   "+dados.get(7)
				+ " ANOS\r\nPercentual:   "+dados.get(12)+"%");
				return true;
		}
		else
			return false;
	
	}
	
	
	private void acoes() {
		

		btnProcurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gerarBusca(lerArquivo(txtUsuario.getText()));
			}
		});
		
		btnMudarPeso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			if(gerarBusca(lerArquivo(txtUsuario.getText())) && medico.verificarPlano(Integer.valueOf((lerArquivo(txtUsuario.getText()).get(2))))){	
				String x = JOptionPane.showInputDialog(null,"Insira novo peso");
				modificarLinha(11, x, new File(System.getProperty("user.dir")+"/src/clientes/"+txtUsuario.getText()+".txt"));
				gerarBusca(lerArquivo(txtUsuario.getText()));
				atualizarData();
			}
			else
				JOptionPane.showMessageDialog(null, "Usuario não existe ou plano não cobre");
			}
		});
		
		btnMudarIdade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(gerarBusca(lerArquivo(txtUsuario.getText()))&& medico.verificarPlano(Integer.valueOf((lerArquivo(txtUsuario.getText()).get(2))))){	
					String x = JOptionPane.showInputDialog(null,"Insira nova idade");
					modificarLinha(7, x, new File(System.getProperty("user.dir")+"/src/clientes/"+txtUsuario.getText()+".txt"));
					gerarBusca(lerArquivo(txtUsuario.getText()));
					atualizarData();
				}
				else
					JOptionPane.showMessageDialog(null, "Usuario não existe ou plano não cobre");
			}
		});
		
		btnMudarAltura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(gerarBusca(lerArquivo(txtUsuario.getText()))&& medico.verificarPlano(Integer.valueOf((lerArquivo(txtUsuario.getText()).get(2))))){	
					String x = JOptionPane.showInputDialog(null,"Insira nova altura");
					modificarLinha(6, x, new File(System.getProperty("user.dir")+"/src/clientes/"+txtUsuario.getText()+".txt"));
					gerarBusca(lerArquivo(txtUsuario.getText()));
					atualizarData();
				}
				else
					JOptionPane.showMessageDialog(null, "Usuario não existe ou plano não cobre");
				
			
			}
		});
		
		btnMudarPercentual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(gerarBusca(lerArquivo(txtUsuario.getText()))&& medico.verificarPlano(Integer.valueOf((lerArquivo(txtUsuario.getText()).get(2))))){	
					String x = JOptionPane.showInputDialog(null,"Insira novo percentual");
					modificarLinha(12, x, new File(System.getProperty("user.dir")+"/src/clientes/"+txtUsuario.getText()+".txt"));
					gerarBusca(lerArquivo(txtUsuario.getText()));
					atualizarData();
				}
				else
					JOptionPane.showMessageDialog(null, "Usuario não existe ou plano não cobre");
				
			
			}
		});
		
		
	}
	
	private void atualizarData() {
        LocalDate dataAtual = LocalDate.now();

        // Formatar a data atual
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		gerarBusca(lerArquivo(txtUsuario.getText()));
		modificarLinha(14, formatter.format(dataAtual) , new File(System.getProperty("user.dir")+"/src/clientes/"+txtUsuario.getText()+".txt"));
		
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 300);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		
		JLabel nomeMedico = new JLabel();
		nomeMedico.setText("Médico:"+medico.getNome());
		
		JPanel panelUsuarios = new JPanel();
		panelUsuarios.setBounds(10, 11, 764, 92);
		frame.getContentPane().add(panelUsuarios);
		panelUsuarios.setLayout(null);
		
		txtrUsuarioPesoAltura = new JTextArea();
		txtrUsuarioPesoAltura.setEditable(false);
		txtrUsuarioPesoAltura.setText("Usuario:   "
		+ "\r\nPeso:   "
		+ "\r\nAltura:  "
		+ "\r\nIdade:   "
		+ "\r\nPercentual:   ");
		txtrUsuarioPesoAltura.setBounds(0, 0, 764, 92);
		panelUsuarios.add(txtrUsuarioPesoAltura);
		
		JPanel panelAcoes = new JPanel();
		panelAcoes.setBounds(10, 114, 764, 136);
		frame.getContentPane().add(panelAcoes);
		panelAcoes.setLayout(null);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(250, 10, 300, 20);
		panelAcoes.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JLabel lblUsuario = new JLabel("Procure o usuário");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsuario.setBounds(305, 41, 200, 40);
		panelAcoes.add(lblUsuario);
		
		btnProcurar = new JButton("PROCURAR");
		btnProcurar.setBounds(560, 11, 121, 23);
		panelAcoes.add(btnProcurar);
		
		btnMudarPeso = new JButton("MUDAR PESO");
		
		btnMudarPeso.setBounds(10, 9, 142, 23);
		panelAcoes.add(btnMudarPeso);
		
		btnMudarAltura = new JButton("MUDAR ALTURA");
		btnMudarAltura.setBounds(10, 53, 142, 23);
		panelAcoes.add(btnMudarAltura);
		
		btnMudarPercentual = new JButton("MUDAR PERCENTUAL");
		btnMudarPercentual.setBounds(10, 102, 142, 23);
		panelAcoes.add(btnMudarPercentual);
		
		btnMudarIdade = new JButton("MUDAR IDADE");
		btnMudarIdade.setBounds(158, 102, 142, 23);
		panelAcoes.add(btnMudarIdade);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		acoes();
	}
}