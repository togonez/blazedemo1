package com.selenium2.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.selenium2.uimaps.FormularioMap;

public class FormularioPage {
	WebDriver driver;

	public FormularioPage(WebDriver driver) {
		this.driver = driver;
	}

	FormularioMap formularioMap = new FormularioMap(driver);

	public void clicarBtnChooseThisFlight() {
		formularioMap.btnChooseThisFlight.click(driver);
	}

	public void preencherFormulario() {
		formularioMap.inputFirstName.sendKeys(driver, "Vinicius Carvalho");
		formularioMap.inputAddress.sendKeys(driver, "Rua Tal, 10");
		formularioMap.inputCity.sendKeys(driver, "Uberaba");
		formularioMap.inputState.sendKeys(driver, "Minas Gerais");
		formularioMap.inputZipCode.sendKeys(driver, "38010-000");
		formularioMap.selectCardType.select(driver, "Visa");
		formularioMap.inputCreditCardNumber.sendKeys(driver, "1111222233334444");
		formularioMap.inputCreditCardMonth.eraseInput(driver); // apaga a informação que aparece automatico na tela.
		formularioMap.inputCreditCardMonth.sendKeys(driver, "06");
		formularioMap.inputCreditCardYear.eraseInput(driver); // apaga a informação que aparece automatico na tela.
		formularioMap.inputCreditCardYear.sendKeys(driver, "2027");
		formularioMap.inputNameOnCard.sendKeys(driver, "FULANO DE TAL");
		formularioMap.checkRememberMe.click(driver);
		formularioMap.btnSubmit.click(driver);
	}

	public void clicarBtnChooseThisFlightParam(Integer flight) {
		if (flight == 43 || flight == 234 || flight == 9696 || flight == 12 || flight == 4346) {
			formularioMap.btnChooseThisFlightParam(driver, flight).click(driver);
		}else{
			System.out.println("Vôo não encontrado.");
			driver.quit();	
		}
	}

	public void preencherFormularioParam(String firstName, String address, String city, String state, String zipCode,
			String cardType, String creditCardNumber, String creditCardMonth, String creditCardYear,
			String nameOnCard) {
		formularioMap.inputFirstName.sendKeys(driver, firstName);
		formularioMap.inputAddress.sendKeys(driver, address);
		formularioMap.inputCity.sendKeys(driver, city);
		formularioMap.inputState.sendKeys(driver, state);
		formularioMap.inputZipCode.sendKeys(driver, zipCode);
		formularioMap.selectCardType.select(driver, cardType);
		formularioMap.inputCreditCardNumber.sendKeys(driver, creditCardNumber);
		formularioMap.inputCreditCardMonth.eraseInput(driver); // apaga a informação que aparece automatico na tela.
		formularioMap.inputCreditCardMonth.sendKeys(driver, creditCardMonth);
		formularioMap.inputCreditCardYear.eraseInput(driver); // apaga a informação que aparece automatico na tela.
		formularioMap.inputCreditCardYear.sendKeys(driver, creditCardYear);
		formularioMap.inputNameOnCard.sendKeys(driver, nameOnCard);
		formularioMap.checkRememberMe.click(driver);
		formularioMap.btnSubmit.click(driver);
	}

	public void validarMensagemSucesso() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		try {
			wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath(formularioMap.tituloMensagem.getValue())));
			String resultado = driver.findElement(By.xpath(formularioMap.tituloMensagem.getValue())).getText();
			Assert.assertEquals("Erro", "Thank you for your purchase today!", resultado);
			System.out.println("[SUCESSO] - Mensagem ["+ resultado + "] aparece na tela!");
		} catch (Exception e) {
			System.out.println("[FALHA] - Erro.");
		}
	}
}
