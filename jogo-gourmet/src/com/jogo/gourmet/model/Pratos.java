package com.jogo.gourmet.model;

import java.util.ArrayList;
import java.util.List;

public class Pratos {
	List<Prato> pratos = new ArrayList<Prato>();

	public List<Prato> getPratos() {
		return pratos;
	}

	public void setPratos(Prato pratos) {
		this.pratos.add(pratos);
	}

}
