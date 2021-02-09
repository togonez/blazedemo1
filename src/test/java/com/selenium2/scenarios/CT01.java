package com.selenium2.scenarios;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import com.selenium2.core.Driver;
//import com.selenium2.pages.FormularioPage;
import com.selenium2.pages.InicioPage;

//Exercicio 2 da Turma 2/2020 - Beca de testes everis
//CT01
//Autor: Vinicius Alves de Carvalho - 09/06/2020
//
//Criar o caso de teste 1:
//1 - Acessar o site: https://blazedemo.com/
//2 - No select “Choose your departure city:” selecionar “San Diego”.
//3 - No select “Choose your destination city:” selecionar “New York”.
//3 - Clicar em “Find Flights”.
//4 - Validar se no cabeçalho da tabela tem as informações: "Departs: San Diego" e "Arrives: New York"

public class CT01 {
	WebDriver driver;
	InicioPage inicioPage;

	@Before
	public void before() {
		driver = new Driver().getDriver();
		Driver.acessarURL(driver, "https://blazedemo.com/");
		inicioPage = new InicioPage(driver);
	}

	@Test
	public void test() {
		inicioPage.selecionarFormulario();
		inicioPage.validarMensagemSucesso();
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
