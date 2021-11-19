package br.senai.sp.jandira.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import br.senai.sp.jandira.model.Console;
import br.senai.sp.jandira.model.Developer;
import br.senai.sp.jandira.model.Game;
import br.senai.sp.jandira.repository.DeveloperRepository;
import br.senai.sp.jandira.repository.GameReposiroty;

public class FrameGamerManager extends JFrame {

	private JPanel contentPane;
	private JTextField txtTitle;
	private JTextField txtEstimatedPrice;
	private GameReposiroty game;
	private DeveloperRepository devs;
	
	/**
	 * Create the frame.
	 */
	public FrameGamerManager() {
		devs = new DeveloperRepository();
		game = new GameReposiroty();
		
		
		
		setTitle("Game Manager");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 710, 460);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(248, 248, 252));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel formPanel = new JPanel();
		formPanel.setBackground(new Color(248, 248, 252));
		formPanel.setBounds(10, 34, 341, 341);
		contentPane.add(formPanel);
		formPanel.setLayout(null);
		
		JLabel lblTitle = new JLabel("Titulo:");
		lblTitle.setBounds(77, 0, 54, 30);
		formPanel.add(lblTitle);
		lblTitle.setFont(new Font("Verdana", Font.PLAIN, 16));
		
		txtTitle = new JTextField();
		txtTitle.setBounds(141, 3, 200, 30);
		formPanel.add(txtTitle);
		txtTitle.setFont(new Font("Verdana", Font.PLAIN, 16));
		txtTitle.setColumns(10);
		
		JLabel lblDeveloper = new JLabel("Developer:");
		lblDeveloper.setBounds(42, 44, 89, 30);
		formPanel.add(lblDeveloper);
		lblDeveloper.setFont(new Font("Verdana", Font.PLAIN, 16));
		
		JComboBox comboDeveloper = new JComboBox();
		DefaultComboBoxModel<String> modelDeveloper = new DefaultComboBoxModel<String>();
		
		for (Developer d : devs.getDeveloperList()) {
			modelDeveloper.addElement(d.getName());
		}
		
		comboDeveloper.setModel(modelDeveloper);
		comboDeveloper.setBounds(141, 44, 200, 30);
		formPanel.add(comboDeveloper);
		comboDeveloper.setFont(new Font("Verdana", Font.PLAIN, 16));
		
		JLabel lblConsole = new JLabel("Console:");
		lblConsole.setBounds(59, 85, 72, 30);
		formPanel.add(lblConsole);
		lblConsole.setFont(new Font("Verdana", Font.PLAIN, 16));
		
		JComboBox comboConsole = new JComboBox();
		DefaultComboBoxModel<String> modelConsole = new DefaultComboBoxModel<String>();
		
		for (Console c : Console.values()) {
			modelConsole.addElement(c.getName());
		}
		
		
		comboConsole.setModel(modelConsole);
		comboConsole.setBounds(141, 85, 200, 30);
		formPanel.add(comboConsole);
		comboConsole.setFont(new Font("Verdana", Font.PLAIN, 16));
		
		JLabel lblestimatedPrice = new JLabel("Valor Estimado:");
		lblestimatedPrice.setBounds(0, 126, 131, 30);
		formPanel.add(lblestimatedPrice);
		lblestimatedPrice.setFont(new Font("Verdana", Font.PLAIN, 16));
		
		txtEstimatedPrice = new JTextField();
		txtEstimatedPrice.setBounds(141, 126, 112, 30);
		formPanel.add(txtEstimatedPrice);
		txtEstimatedPrice.setFont(new Font("Verdana", Font.PLAIN, 16));
		txtEstimatedPrice.setColumns(10);
		
		JCheckBox checkFinished = new JCheckBox("Zerado");
		checkFinished.setBounds(259, 126, 82, 30);
		formPanel.add(checkFinished);
		checkFinished.setBackground(new Color(248, 248, 252));
		checkFinished.setFont(new Font("Verdana", Font.PLAIN, 16));
		
		JLabel lblObservations = new JLabel("Observa\u00E7\u00F5es:");
		lblObservations.setBounds(19, 167, 112, 30);
		formPanel.add(lblObservations);
		lblObservations.setFont(new Font("Verdana", Font.PLAIN, 16));
		
		JButton btnSave = new JButton("Salvar");
		btnSave.setBounds(0, 301, 150, 40);
		formPanel.add(btnSave);
		
		JTextArea txtAreaObservations = new JTextArea();
		txtAreaObservations.setLineWrap(true);
		txtAreaObservations.setFont(new Font("Verdana", Font.PLAIN, 16));
		txtAreaObservations.setTabSize(4);
		txtAreaObservations.setBounds(141, 167, 200, 120);
		formPanel.add(txtAreaObservations);
		
		JButton btnDelete = new JButton("Deletar");
		btnDelete.setBounds(180, 301, 160, 40);
		formPanel.add(btnDelete);
		
		JPanel listPanel = new JPanel();
		listPanel.setBackground(new Color(248, 248, 252));
		listPanel.setBounds(384, 34, 300, 341);
		contentPane.add(listPanel);
		listPanel.setLayout(null);
		
		JLabel lblJogos = new JLabel("Meus Jogos:");
		lblJogos.setBounds(0, 0, 101, 21);
		listPanel.add(lblJogos);
		lblJogos.setFont(new Font("Verdana", Font.PLAIN, 16));
		
		JScrollPane listScrollPane = new JScrollPane();
		listScrollPane.setBounds(0, 21, 300, 268);
		listPanel.add(listScrollPane);
		
		JList gameList = new JList();
		gameList.setFont(new Font("Verdana", Font.PLAIN, 16));
		DefaultListModel<String> modelGame = new DefaultListModel<String>();
		gameList.setModel(modelGame);
		listScrollPane.setViewportView(gameList);
		
		JButton btnPrevious = new JButton("<");
		btnPrevious.setFont(new Font("Verdana", Font.PLAIN, 16));
		btnPrevious.setBounds(94, 301, 50, 40);
		listPanel.add(btnPrevious);
		
		JButton btnNext = new JButton(">");
		btnNext.setFont(new Font("Verdana", Font.PLAIN, 16));
		btnNext.setBounds(154, 301, 50, 40);
		listPanel.add(btnNext);
		
				
		btnSave.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!txtTitle.getText().equals("") && !txtEstimatedPrice.getText().equals("")) {
					Game g = new Game();
					
					g.setTitle(txtTitle.getText());
					g.setDeveloper(devs.getDeveloperList()[comboDeveloper.getSelectedIndex()]);
					g.setConsole(Console.values()[comboConsole.getSelectedIndex()]);
					g.setEstimatedPrice(txtEstimatedPrice.getText());
					g.setFinished(checkFinished.isSelected());
					g.setObservations(txtAreaObservations.getText());
					
					game.addGame(g);
					modelGame.addElement(g.getTitle());
				} else {
					JOptionPane.showMessageDialog(null, "Por favor preencha o formulario!", "Por favor preencha o formulario!",
										JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		btnDelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!gameList.isSelectionEmpty()) {
					game.removeGame(gameList.getSelectedIndex());
					modelGame.remove(gameList.getSelectedIndex());
				}
			}
		});
		
		gameList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				try {
					Game g = game.getGame(gameList.getSelectedIndex());
					txtTitle.setText(g.getTitle());
					comboDeveloper.setSelectedIndex(devs.getIndexOf(g.getDeveloper()));
					comboConsole.setSelectedIndex(g.getConsole().ordinal());
					txtEstimatedPrice.setText(String.valueOf(g.getEstimatedPrice()));
					checkFinished.setSelected(g.isFinished());
					txtAreaObservations.setText(g.getObservations());
				} catch (Exception exception) {}
			}
		});
		
		btnPrevious.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (gameList.getSelectedIndex() > 0) {
					int previousIndex = gameList.getSelectedIndex() - 1;
					gameList.setSelectedIndex(previousIndex);
				} else {
					gameList.setSelectedIndex(gameList.getLastVisibleIndex());
				}
			}
		});
		
		btnNext.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (gameList.getSelectedIndex() < gameList.getLastVisibleIndex()) {
					int previousIndex = gameList.getSelectedIndex() + 1;
					gameList.setSelectedIndex(previousIndex);
				} else {
					gameList.setSelectedIndex(0);
				}
			}
		});
		
	}
}
