package com.jogodavelha.action;

import java.awt.Color;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import com.jogodavelha.view.JogoDaVelhaView;

public class ActionLabel implements MouseListener{

	private JogoDaVelhaView jogoDaVelhaView;
	
	

	public ActionLabel(JogoDaVelhaView jogoDaVelhaView) {
		
		this.jogoDaVelhaView = jogoDaVelhaView;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		UIManager.put("OptionPane.cancelButtonText", null);  
		UIManager.put("OptionPane.noButtonText", "O");  
		UIManager.put("OptionPane.yesButtonText", "X");
		String imagen;
		int x_o;
		x_o = JOptionPane.showConfirmDialog(null, "Escolha X ou O para iniciar o jogo" );
		
		if(x_o == 0) {
			imagen = jogoDaVelhaView.getImgX();
		}else if(x_o == 1){
			imagen = jogoDaVelhaView.getImgO();
		}else {	
			imagen = "";
		}
		
		System.out.println(x_o);
		String str = e.toString();
		String ultimaPosicao;
	    ultimaPosicao = String.valueOf(str.charAt(str.length() - 1));
		int posicao = Integer.valueOf(ultimaPosicao);
		
		jogoDaVelhaView.setBotao(BorderFactory.createLineBorder(Color.black, 1), posicao, imagen);
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
		
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
			
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
		String str = e.toString();
		String ultimaPosicao;
	    ultimaPosicao = String.valueOf(str.charAt(str.length() - 1));
		int posicao = Integer.valueOf(ultimaPosicao);
		
		jogoDaVelhaView.setBotao(BorderFactory.createLineBorder(Color.black,3), posicao);
		
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
		String str = e.toString();
		String ultimaPosicao;
	    ultimaPosicao = String.valueOf(str.charAt(str.length() - 1));
		int posicao = Integer.valueOf(ultimaPosicao);
		
		jogoDaVelhaView.setBotao(BorderFactory.createLineBorder(Color.black,1), posicao);
		
	}
}
