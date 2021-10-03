package com.jogodavelha.action;

import java.awt.Color;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;


import com.jogodavelha.view.JogoDaVelhaView;

public class ActionLabel implements MouseListener{

	private JogoDaVelhaView jogoDaVelhaView;
	
	

	public ActionLabel(JogoDaVelhaView jogoDaVelhaView) {
		
		this.jogoDaVelhaView = jogoDaVelhaView;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
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
