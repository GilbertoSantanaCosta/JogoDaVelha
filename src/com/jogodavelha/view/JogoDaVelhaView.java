package com.jogodavelha.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import com.jogodavelha.action.ActionLabel;

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
		
		for (int i = 0; i != botao.length; i++) {
		
		botao[i].addMouseListener(new ActionLabel(this));
		
		}
	}

	private void initComponents() {
		
		titulo = new JLabel("Jogo da Velha");
		titulo.setFont(new Font("Courier", Font.BOLD + Font.ITALIC, 20));
		this.titulo.setBounds(420, 10, 200, 70);
		
		painel = new JPanel();
		botao = new JLabel[9];
		
		for (int i = 0; i != botao.length; i++) {
			
			botao[i] = new JLabel();
			botao[i].setName(String.valueOf(i));
			botao[i].setBorder(BorderFactory.createLineBorder(Color.black,1)); 
			botao[i].setPreferredSize(new Dimension(110,110));
			
			
			painel.add(botao[i]);
		}
		
		
		
		painel.setBackground(Color.white);
		this.painel.setBounds(325, 100, 350, 350);
		
		
}

	public JLabel[] getBotao() {
		return botao;
	}

	public int setBotao(Border borda, int posicao) {
		
		this.botao[posicao].setBorder(borda);
		return posicao;
	}

}
