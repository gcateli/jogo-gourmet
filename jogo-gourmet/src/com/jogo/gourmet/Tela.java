package com.jogo.gourmet;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;

import com.jogo.gourmet.model.Massa;
import com.jogo.gourmet.model.NaoMassa;
import com.jogo.gourmet.model.Prato;
import com.jogo.gourmet.model.Pratos;

public class Tela implements ActionListener {

	Massa massa = new Massa();
	NaoMassa naoMassa = new NaoMassa();
	int resposta;

	public Tela() {

		Label label = new Label("Pense em um prato que goste");
		Button button = new Button("Ok");
		button.addActionListener(this);

		Frame frame = new Frame("Jogo Gourmet");

		frame.setLayout(new FlowLayout());
		frame.add(label);
		frame.add(button);

		frame.setSize(300, 100);
		frame.setLocation(450, 450);
		frame.setVisible(true);

		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		comecarJogo();
	}

	public void comecarJogo() {

		resposta = JOptionPane.showConfirmDialog(null, "O que você pensou é uma massa?");

		if (resposta == JOptionPane.YES_OPTION) {
			advinharPratos(massa);
		} else if (resposta == JOptionPane.NO_OPTION) {
			advinharPratos(naoMassa);
		}

	}

	public void advinharPratos(Pratos pratos) {
		int contador = 0;

		for (contador = pratos.getPratos().size() - 1; contador > 0; contador--) {
			resposta = JOptionPane.showConfirmDialog(null,
					"O prato que pensou é " + pratos.getPratos().get(contador).getCaracteristica() + "?");

			if (resposta == JOptionPane.YES_OPTION) {
				resposta = JOptionPane.showConfirmDialog(null,
						"O prato que pensou é " + pratos.getPratos().get(contador).getDescricao() + "?");
				if (resposta == JOptionPane.YES_OPTION) {
					JOptionPane.showMessageDialog(null, "Acertei de novo!");
					break;
				} else if ((resposta == JOptionPane.NO_OPTION) && (contador == 0)) {
					adicionarPrato(pratos, contador);
					break;
				}
			}
		}

		if (contador == 0) {
			resposta = JOptionPane.showConfirmDialog(null,
					"O prato que pensou é " + pratos.getPratos().get(contador).getDescricao() + "?");
			if (resposta == JOptionPane.YES_OPTION)
				JOptionPane.showMessageDialog(null, "Acertei de novo!");
			else if (resposta == JOptionPane.NO_OPTION) {
				adicionarPrato(pratos, contador);
			}
		}
	}

	public void adicionarPrato(Pratos pratos, int ordemPrato) {
		String descricaoPrato;
		String caracteristicaPrato;

		descricaoPrato = JOptionPane.showInputDialog("Qual você pensou então?");
		caracteristicaPrato = JOptionPane.showInputDialog(
				descricaoPrato + " é ________ mas " + pratos.getPratos().get(ordemPrato).getDescricao() + " não");
		pratos.setPratos(new Prato(descricaoPrato, caracteristicaPrato));
	}

}
