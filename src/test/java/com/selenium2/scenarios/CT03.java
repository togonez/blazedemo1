package com.selenium2.scenarios;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import com.selenium2.core.Driver;
import com.selenium2.pages.FormularioPage;
import com.selenium2.pages.InicioPage;

//Exercicio 2 da Turma 2/2020 - Beca de testes everis
//CT03
//Autor: Vinicius Alves de Carvalho - 09/06/2020
//
//Criar o caso de teste 3:
//1 - Acessar o site: https://blazedemo.com/
//2 - Em select �Choose your departure city:� selecionar qualquer valor passado por par�metro
//3 - Em select �Choose your destination city:� selecionar qualquer valor passado por par�metro
//3 - Clicar em �Find Flights�.
//4 - Escolher a viagem baseada no �Flight#�, ou seja clicar no bot�o �Choose This Flight� do �Flight#� passado por par�metro
//5 - Preencher todos os campos do formul�rio (passar as informa��es por par�metro)
//5 - Enviar (Purchase Flight) o formul�rio
//6 - Validar mensagem de sucesso
//
//Obs: Usar a estrutura Page Object.
//
//DICA: O caso 3 � basicamente o caso 2, por�m todas as entradas de dados s�o parametrizadas, isso reflete em um aproveitamento maior de c�digo e variedade de testes.
//Por exemplo: com o caso de teste 3 desenvolvido, � poss�vel testar todos os v�os utilizando as mesmas 'pages' e 'maps', alterando somente o cen�rio.


public class CT03 {
	WebDriver driver;
	InicioPage inicioPage;
	FormularioPage formularioPage;

	@Before
	public void before() {
		driver = new Driver().getDriver();
		Driver.acessarURL(driver, "https://blazedemo.com/");
		inicioPage = new InicioPage(driver);
		formularioPage = new FormularioPage(driver);
	}
	@Test
	public void test() {
		inicioPage.selecionarFormularioParam("Paris", "Dublin");
		formularioPage.clicarBtnChooseThisFlightParam(9696);
		formularioPage.preencherFormularioParam("Vinicius Alves de Carvalho", "Rua Tal, 10", "Uberaba", "Minas Gerais", "38010-000", "Visa", "1111222233334444", "06", "2027", "Fulano de Tal");
		formularioPage.validarMensagemSucesso();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	@After
	public void after() {
		Driver.close(driver);
	}
}
