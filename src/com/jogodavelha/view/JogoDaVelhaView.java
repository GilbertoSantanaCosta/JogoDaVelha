package com.jogodavelha.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JogoDaVelhaView extends JFrame {

	/**
	 * 
	 */
	
	private JLabel titulo;
	private JLabel[] botao;
	private JPanel painel;
	
	


	private static final long serialVersionUID = 1L;

	public JogoDaVelhaView() {
		
		initComponents();
		initController();
		initPanel();
		
		setSize(1000,600);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private void initPanel() {

		JPanel RecebePainel = new JPanel();
		RecebePainel.setLayout(null);
		RecebePainel.add(painel);
		RecebePainel.add(titulo);
		this.add(RecebePainel);
		
	}

	private void initController() {
		
		
	}

	private void initComponents() {
		
		titulo = new JLabel("Jogo da Velha");
		titulo.setFont(new Font("Courier", Font.BOLD + Font.ITALIC, 20));
		this.titulo.setBounds(420, 10, 200, 70);
		
		painel = new JPanel();
		botao = new JLabel[9];
		
		for (int i = 0; i != botao.length; i++) {
			
			botao[i] = new JLabel();
			botao[i].setBorder(BorderFactory.createEtchedBorder()); 
			botao[i].setPreferredSize(new Dimension(110,110));
			botao[i].setBackground( new Color(200,255,255) );
			painel.add(botao[i]);
		}
		
		
		
		painel.setBackground(Color.white);
		this.painel.setBounds(325, 100, 350, 350);
		
		
		
	}

	
	
}
