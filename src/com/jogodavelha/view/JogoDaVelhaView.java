package com.jogodavelha.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.Objects;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;

import com.jogodavelha.action.ActionLabel;

public class JogoDaVelhaView extends JFrame {

	/**
	 * 
	 */

	private JLabel titulo;
	public JLabel pontoX;
	public JLabel pontoO;
	public JLabel[] botao;
	private JPanel painel;
	private String img;
	private final String imgX = "/imagens/x.jpg";
	private final String imgO = "/imagens/o.jpg";
	private int jaSelecionado;
	public final String caminhoX = "file:/C:/Users/gsdc/eclipse-workspace/jogo_da_velha/bin/imagens/x.jpg";
	public final String caminhoO = "file:/C:/Users/gsdc/eclipse-workspace/jogo_da_velha/bin/imagens/o.jpg";
	public int contador = 0;
	public int pontosX = 0;
	public int pontosO = 0;
	public boolean eVazio;

	private static final long serialVersionUID = 1L;

	public JogoDaVelhaView() {

		initComponents();
		initController();
		initPanel();

		setSize(500, 500);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private void initPanel() {

		JPanel RecebePainel = new JPanel();
		RecebePainel.setLayout(null);
		RecebePainel.add(painel);
		RecebePainel.add(titulo);
		RecebePainel.add(pontoX);
		RecebePainel.add(pontoO);
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
		this.titulo.setBounds(170, 0, 200, 70);
		
		pontoX = new JLabel("Jogador X: 0");
		pontoX.setFont(new Font("Courier", Font.BOLD + Font.ITALIC, 13));
		this.pontoX.setBounds(75, 400, 100, 70);
		
		pontoO = new JLabel("Jogador O: 0");
		pontoO.setFont(new Font("Courier", Font.BOLD + Font.ITALIC, 13));
		this.pontoO.setBounds(330, 400, 100, 70);

		painel = new JPanel();
		botao = new JLabel[9];

		for (int i = 0; i != botao.length; i++) {

			botao[i] = new JLabel();
			botao[i].setName(String.valueOf(i));
			botao[i].setBorder(BorderFactory.createLineBorder(Color.black, 1));
			botao[i].setPreferredSize(new Dimension(110, 110));

			painel.add(botao[i]);
		}

		painel.setBackground(Color.white);
		this.painel.setBounds(75, 50, 350, 350);

	}

	public int setBotao(Border borda, int posicao) {

		this.botao[posicao].setBorder(borda);
		return posicao;
	}

	public int setBotao(Border borda, int posicao, String imagen) {

		if( !Objects.isNull(botao[posicao].getIcon()))  {
			
			JOptionPane.showMessageDialog(null,"Escolha um campo vazio");
			eVazio = false;
			
			return 0;
		}else {
			eVazio = true;
		}
		
		botao[posicao].setIcon(new javax.swing.ImageIcon(getClass().getResource(imagen)));
		System.out.println(botao[posicao].getIcon().toString());
		this.botao[posicao].setBorder(borda);
		return posicao;
	}

	public int getJaSelecionado() {
		return jaSelecionado;
	}

	public void setJaSelecionado(int jaSelecionado) {
		this.jaSelecionado = jaSelecionado;
	}
	
	public void desabilitaBotao() {

		for(int i = 0; i < botao.length; i++ ) {
			
			if( !Objects.isNull(botao[i].getIcon()))  {
				
				this.botao[i].setEnabled(false);
				
			}
		}
		
	}

	public String getImgX() {
		return imgX;
	}

	public String getImgO() {
		return imgO;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

}
