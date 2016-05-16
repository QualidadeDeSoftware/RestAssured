package br.com.qualidadedesoftware.carga;

import org.json.simple.JSONObject;

import br.com.qualidadedesoftware.setup.SetupTest;

public class Client extends SetupTest {
	
	public Client() {		
		cliente = new JSONObject();
		cliente.put("uid", "67248ac2ddf794a223309380a36369e0");
	}
	
	public JSONObject getCliente() {
		return cliente;
	}
}