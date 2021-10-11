package com.jogodavelha.action;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

import com.jogodavelha.view.JogoDaVelhaView;

public class Logica {

	int x_o = 3;

	public Logica() {

	}

	public String modarImagen(JogoDaVelhaView jogoDaVelhaView) {

		UIManager.put("OptionPane.cancelButtonText", null);
		UIManager.put("OptionPane.noButtonText", "O");
		UIManager.put("OptionPane.yesButtonText", "X");

		if (jogoDaVelhaView.getJaSelecionado() == 1) {
			if (jogoDaVelhaView.getImg() == "/imagens/o.jpg") {

				jogoDaVelhaView.setImg(jogoDaVelhaView.getImgX());
			} else {

				jogoDaVelhaView.setImg(jogoDaVelhaView.getImgO());
			}

		}

		if (jogoDaVelhaView.getJaSelecionado() != 1) {
			x_o = JOptionPane.showConfirmDialog(null, "Escolha X ou O para iniciar o jogo");
			if (x_o == 0) {
				jogoDaVelhaView.setImg(jogoDaVelhaView.getImgX());

			} else if (x_o == 1) {
				jogoDaVelhaView.setImg(jogoDaVelhaView.getImgO());

			} else {
				jogoDaVelhaView.setImg(" ");
			}
		}
		return jogoDaVelhaView.getImg();
	}

	public int getX_o() {
		return x_o;
	}

	public void setX_o(int x_o) {
		this.x_o = x_o;
	}

}
