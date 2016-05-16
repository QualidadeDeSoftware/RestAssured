package br.com.qualidadedesoftware;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.contains;

import org.json.simple.JSONObject;
import org.junit.Before;
import org.junit.Test;

import br.com.qualidadedesoftware.carga.Client;
import br.com.qualidadedesoftware.carga.Pedido;
import br.com.qualidadedesoftware.setup.SetupTest;

public class ExemploComDependencia extends SetupTest {

	JSONObject cliente;
	JSONObject pedido;
	
	@Before
	public void setUp() throws Exception {
		cliente  = new Client().getCliente();
		pedido  = new Pedido().getPedido();
	}
	
	@Test
	public void validar_DetalhesDoItem() {
		given().
			header("uid", cliente.get("uid")).
			contentType("application/json;charset=UTF-8").
		expect().
	         statusCode(200).
	         body("items.description", 	contains(pedido.get("description"))).
	         body("items.totalAmount", 	contains(pedido.get("totalAmount"))).
	         body("items.returnable", 	contains(pedido.get("returnable"))).
	         body("items.quantity", 	contains(pedido.get("quantity"))).
		when().
			get("/order/123456");
	}
		
}
