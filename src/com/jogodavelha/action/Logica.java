package com.jogodavelha.action;
import java.util.Objects;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import com.jogodavelha.view.JogoDaVelhaView;

public class Logica {

	int x_o = 3;
	boolean jogoGanho;
	boolean jogoCancelado;
	

	String[] valor = new String[9];

	public Logica() {

	}

	public String modarImagen(JogoDaVelhaView jogoDaVelhaView) {

		UIManager.put("OptionPane.cancelButtonText", null);
		UIManager.put("OptionPane.noButtonText", "O");
		UIManager.put("OptionPane.yesButtonText", "X");
		
		
		

		if (jogoDaVelhaView.getJaSelecionado() == 1 && jogoDaVelhaView.eVazio == true) {
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
				jogoDaVelhaView.contador++;
				jogoDaVelhaView.setJaSelecionado(1);
			} else if (x_o == 1) {
				jogoDaVelhaView.setImg(jogoDaVelhaView.getImgO());
				jogoDaVelhaView.contador++;
				jogoDaVelhaView.setJaSelecionado(1);
			}else {
				jogoDaVelhaView.setJaSelecionado(0);
			}
		}
		
		return jogoDaVelhaView.getImg();
	}

	public void ganhandoJogo(JogoDaVelhaView jogoDaVelhaView) {

		for (int i = 0; i < valor.length; i++) {
			if (!Objects.isNull(jogoDaVelhaView.botao[i].getIcon())) {
				valor[i] = jogoDaVelhaView.botao[i].getIcon().toString();
			} else {
				valor[i] = String.valueOf(i);
			}
		}
		jogoDaVelhaView.contador = jogoDaVelhaView.contador + 1;
		System.out.println(jogoDaVelhaView.contador);

		if (valor[0].equals(valor[1]) && valor[0].equals(valor[2])
				|| valor[0].equals(valor[3]) && valor[0].equals(valor[6])
				|| valor[0].equals(valor[4]) && valor[0].equals(valor[8])
				|| valor[2].equals(valor[5]) && valor[2].equals(valor[8])
				|| valor[2].equals(valor[4]) && valor[2].equals(valor[6])
				|| valor[3].equals(valor[4]) && valor[3].equals(valor[5])
				|| valor[6].equals(valor[7]) && valor[6].equals(valor[8])
				|| valor[1].equals(valor[4]) && valor[1].equals(valor[7])) {

			
			String ganhou = (jogoDaVelhaView.getImg() == "/imagens/o.jpg") ? "jogador O ganhou" : "jogador X ganhou";
			if(ganhou == "jogador O ganhou") {
				jogoDaVelhaView.pontosO++;
			}else {
				jogoDaVelhaView.pontosX++;
			}
			
			jogoDaVelhaView.pontoO.setText("Jogador O: " + jogoDaVelhaView.pontosO);
			jogoDaVelhaView.pontoX.setText("Jogador X: " + jogoDaVelhaView.pontosX);
			JOptionPane.showMessageDialog(null, ganhou);
			
			jogoDaVelhaView.contador = 0;
			jogoGanho = true;
			
		}
		
		
		
		
		if (jogoGanho == true || jogoDaVelhaView.contador == 10) {

			if(jogoDaVelhaView.contador == 10) {
				JOptionPane.showMessageDialog(null, "Não houve ganhador");
				jogoDaVelhaView.setJaSelecionado(0);
				jogoDaVelhaView.setImg(null);
				jogoDaVelhaView.contador = 0;
				
			}
			for (int i = 0; i < jogoDaVelhaView.botao.length; i++) {
				
				jogoDaVelhaView.setJaSelecionado(0);
				jogoDaVelhaView.botao[i].setIcon(null);
				jogoDaVelhaView.setImg(null);
				jogoGanho = false;
				
			}
		}
	}

	public int getX_o() {
		return x_o;
	}

	public void setX_o(int x_o) {
		this.x_o = x_o;
	}

}
