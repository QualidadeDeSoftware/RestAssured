package br.com.selfhelp.setup;

import org.json.simple.JSONObject;
import org.junit.Before;
import org.junit.BeforeClass;

import com.jayway.restassured.RestAssured;

public class SetupTest {

	protected static JSONObject cliente = null;
	protected static JSONObject pedido = null;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {		
		RestAssured.baseURI = "http://testedesoftware.com.br";
	}
	
	@Before
	public void setUp() throws Exception {

	}

}