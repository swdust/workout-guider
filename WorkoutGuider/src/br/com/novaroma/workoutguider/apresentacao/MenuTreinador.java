package br.com.novaroma.workoutguider.apresentacao;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.border.EmptyBorder;

import br.com.novaroma.workoutguider.dados.ArquivoGeral;
import br.com.novaroma.workoutguider.entidades.Treinador;
import br.com.novaroma.workoutguider.utils.UsuarioUtil;

public class MenuTreinador extends JFrame {

	private JPanel contentPane;
	JLayeredPane layeredPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuTreinador frame = new MenuTreinador();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void switchPanels(JPanel panel) {
		layeredPane.removeAll();
		layeredPane.add(panel);
		layeredPane.repaint();
		layeredPane.revalidate();
	}

	public MenuTreinador() throws ClassNotFoundException, IOException, ParseException {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1280, 720);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 1264, 660);
		contentPane.add(layeredPane);

		AdicionarExercicio adicionarEx = new AdicionarExercicio();
		adicionarEx.setBounds(0, 0, 1264, 660);
		layeredPane.add(adicionarEx);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnTreinador = new JMenu("Treinador");
		menuBar.add(mnTreinador);

		JMenuItem mntmVisualizarCadastro = new JMenuItem("Visualizar cadastro");
		mntmVisualizarCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaDadosTreinador dadosT;
				try {
					dadosT = new TelaDadosTreinador();
					dadosT.setBounds(0, 0, 1264, 660);
					layeredPane.add(dadosT);
					switchPanels(dadosT);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		mnTreinador.add(mntmVisualizarCadastro);

		JMenuItem mntmExcluirConta = new JMenuItem("Excluir conta");
		mntmExcluirConta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir?", "Confirmação",
						JOptionPane.YES_NO_OPTION);

				if (resposta == JOptionPane.YES_OPTION) {
					ArquivoGeral arq = new ArquivoGeral(TelaLogin.t1);
					try {
						JOptionPane.showMessageDialog(null,
								arq.removeObjeto(UsuarioUtil.retornaIndexTreinador(TelaLogin.t1.getLogin())));
						Main.getFrame().setVisible(true);
						dispose();
					} catch (ClassNotFoundException e1) {
						e1.printStackTrace();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				} else if (resposta == JOptionPane.NO_OPTION) {

				}

			}
		});
		mnTreinador.add(mntmExcluirConta);

		JSeparator separator = new JSeparator();
		mnTreinador.add(separator);

		JMenuItem mntmVoltar = new JMenuItem("Voltar");
		mntmVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Main.getFrame().setVisible(true);
				dispose();
			}
		});
		mnTreinador.add(mntmVoltar);

		JMenu mnCliente = new JMenu("Cliente");
		menuBar.add(mnCliente);

		JMenuItem mntmVisualizar = new JMenuItem("Listar");
		mntmVisualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ListarClientes listarCl;
				try {
					listarCl = new ListarClientes();
					listarCl.setBounds(0, 0, 1264, 660);
					layeredPane.add(listarCl);
					switchPanels(listarCl);
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		mnCliente.add(mntmVisualizar);

		JMenuItem mntmRemover = new JMenuItem("Remover");
		mnCliente.add(mntmRemover);

		JMenu mnExercicios = new JMenu("Exercicios");
		menuBar.add(mnExercicios);

		JMenuItem mntmAdicionar = new JMenuItem("Adicionar");
		mntmAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				switchPanels(adicionarEx);
			}
		});
		mnExercicios.add(mntmAdicionar);

		JMenuItem mntmListar = new JMenuItem("Listar");
		mntmListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ListarExercicios listarEx;
				try {
					listarEx = new ListarExercicios();
					listarEx.setBounds(0, 0, 1264, 660);
					layeredPane.add(listarEx);
					switchPanels(listarEx);
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}

			}
		});
		mnExercicios.add(mntmListar);

		JMenuItem mntmAlterar = new JMenuItem("Alterar");
		mnExercicios.add(mntmAlterar);

		JMenuItem mntmExcluir = new JMenuItem("Excluir");
		mntmExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ExcluirExercicio excluirEx;
				try {
					excluirEx = new ExcluirExercicio();
					excluirEx.setBounds(0, 0, 1264, 660);
					layeredPane.add(excluirEx);
					switchPanels(excluirEx);
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		mnExercicios.add(mntmExcluir);

	}
}
