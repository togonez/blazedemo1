package com.selenium2.scenarios;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import com.selenium2.core.Driver;
import com.selenium2.pages.FormularioPage;
import com.selenium2.pages.InicioPage;

//Exercicio 2 da Turma 2/2020 - Beca de testes everis
//CT02
//Autor: Vinicius Alves de Carvalho - 09/06/2020
//
//Criar o caso de teste 2:
//1 - Acessar o site: https://blazedemo.com/
//2 - Em select “Choose your departure city:” selecionar “San Diego”.
//3 - Em select “Choose your destination city:” selecionar “New York”.
//3 - Clicar em “Find Flights”.
//4 - Escolher a primeira viagem, ou seja clicar no primeiro botão “Choose This Flight”
//5 - Preencher todos os campos do formulário
//5 - Enviar (Purchase Flight) o formulário
//6 - Validar mensagem de sucesso

public class CT02 {
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
		inicioPage.selecionarFormulario();
		inicioPage.validarMensagemSucesso();
		formularioPage.clicarBtnChooseThisFlight();
		formularioPage.preencherFormulario();
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
