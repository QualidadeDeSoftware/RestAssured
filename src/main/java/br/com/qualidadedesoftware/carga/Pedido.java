package br.com.qualidadedesoftware.carga;

import org.json.simple.JSONObject;

import br.com.qualidadedesoftware.setup.SetupTest;

public class Pedido extends SetupTest {
	
	public Pedido() {
		pedido = new JSONObject();
		pedido.put("description", "Produto para teste de compra 532");
		pedido.put("totalAmount", 10.53f);
		pedido.put("returnable", false);
		pedido.put("quantity", 1);
	}
	
	public JSONObject getPedido() {
		return pedido;
	}
	
}