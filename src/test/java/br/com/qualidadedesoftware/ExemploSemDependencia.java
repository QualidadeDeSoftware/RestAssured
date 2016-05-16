package br.com.qualidadedesoftware;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

import org.json.simple.JSONArray;
import org.junit.Test;

import br.com.selfhelp.setup.SetupTest;

public class ExemploSemDependencia extends SetupTest {
	
	@Test
	public void validar_DetalhesDoItem() {
		given().
			header("uid", "67248ac2ddf794a223309380a36369e0").
			contentType("application/json;charset=UTF-8").
		expect().
	         statusCode(200).
	         body("items.description", 	contains("Produto para teste de compra 532")).
	         body("items.totalAmount", 	contains(10.53f)).
	         body("items.returnable", 	contains(false)).
	         body("items.quantity", 	contains(1)).
		when().
			get("/order/123456");
	}
	
	@Test
	public void validar_DetalhesDeVariosItens() {
		given().
			header("uid", "67248ac2ddf794a223309380a36369e0").
			contentType("application/json;charset=UTF-8").
		expect().
	         statusCode(200).
	         body("paymentMethods.method", 				hasItems("CREDIT_CARD", "CREDIT_CARD")).
	         body("paymentMethods.currencyUnit", 		hasItems("BRL", "EUA")).
	         body("paymentMethods.parcelAmount", 		hasItems(1, 2)).
	         body("paymentMethods.completeName", 		hasItems("Auto Test", "Auto Test 2")).
	         body("paymentMethods.brand", 				hasItems("VISA", "MASTERCARD")).
	         body("paymentMethods.lastDigitsOfCard", 	hasItems("1111", "2222")).
	         body("paymentMethods.installmentValue", 	hasItems(2.53f, 5.0f)).
	         body("paymentMethods.expired", 			hasItems(false, false)).
		when().
			get("/order/542456");
	}
	
	@Test
	public void validar_ListaDeItens() {
		JSONArray list = new JSONArray();
		
		given().
			header("uid", "67248ac2ddf794a223309380a36369e0").
			contentType("application/json;charset=UTF-8").
		expect().
	         statusCode(200).
	         body("items", equalTo(list)).
		when().
			get("/order/542456");
	}
}
