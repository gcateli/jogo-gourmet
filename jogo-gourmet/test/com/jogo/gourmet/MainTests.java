package com.jogo.gourmet;

import static org.junit.Assert.*;

import org.junit.Test;

import com.jogo.gourmet.model.Massa;
import com.jogo.gourmet.model.NaoMassa;

public class MainTests {
	Massa massa = new Massa();
	NaoMassa naoMassa = new NaoMassa();

	@Test
	public void instanciaListas() {
		assertEquals("Lasanha", massa.getPratos().get(0).getDescricao());
		assertEquals("Bolo de Chocolate", naoMassa.getPratos().get(0).getDescricao());
	}

	@Test
	public void comecarJogo() {
		Tela tela = new Tela();
		tela.comecarJogo();
	}
	
}
