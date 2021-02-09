package com.selenium2.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.selenium2.uimaps.InicioMap;

public class InicioPage {
	WebDriver driver;
	
	public InicioPage(WebDriver driver) {
		this.driver = driver;
	}
	InicioMap inicioMap = new InicioMap(driver);
	
	public void selecionarFormulario() {
		inicioMap.selectDeparture.select(driver, "San Diego");
		inicioMap.selectDestination.select(driver, "New York");
		inicioMap.buttonViewDemo("Find Flights").click(driver);
	}
	
	//Selecionar form para o CT03
	public void selecionarFormularioParam(String departure, String destination) {
		inicioMap.selectDeparture.select(driver, departure);
		inicioMap.selectDestination.select(driver, destination);
		inicioMap.buttonViewDemo("Find Flights").click(driver);
	}
	
	public void validarMensagemSucesso() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(inicioMap.tituloCabecalhoDeparts.getValue())));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(inicioMap.tituloCabecalhoArrives.getValue())));
			String titDeparts = driver.findElement(By.xpath(inicioMap.tituloCabecalhoDeparts.getValue())).getText();
			String titArrives = driver.findElement(By.xpath(inicioMap.tituloCabecalhoArrives.getValue())).getText();
			Assert.assertEquals("Erro", "Departs: San Diego", titDeparts);
			Assert.assertEquals("Erro", "Arrives: New York", titArrives);
			System.out.println("[SUCESSO] - Mensagens: " + titDeparts + " e " + titArrives + " aparecem na tela.");
		} catch (Exception e) {
			System.out.println("[FALHA] - Erro");
		}
	}
}
