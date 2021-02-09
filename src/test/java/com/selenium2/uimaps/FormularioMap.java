package com.selenium2.uimaps;

import org.openqa.selenium.WebDriver;

import com.selenium2.core.Element;
import com.selenium2.enums.ByValue;

public class FormularioMap {
	WebDriver driver;
	
	public FormularioMap(WebDriver driver) {
		this.driver = driver;
	}

	//Formulario
	public Element btnChooseThisFlightParam(WebDriver driver, Integer flight) {
		return new Element(driver, ByValue.XPATH, "//form//following::td[text()='"+flight+"']/..//input[@type='submit']"); //Button Choose this Flight with params
	}
	public Element btnChooseThisFlight 		= new Element(driver, ByValue.XPATH, "(//form//following::input[@type='submit'])[1]"); 	//Button Choose this Flight
	public Element inputFirstName 			= new Element(driver, ByValue.ID   , "inputName");	//input Name
	public Element inputAddress 			= new Element(driver, ByValue.ID   , "address");	//input Address
	public Element inputCity 				= new Element(driver, ByValue.ID   , "city");	//input City
	public Element inputState 				= new Element(driver, ByValue.ID   , "state");	//input State
	public Element inputZipCode 			= new Element(driver, ByValue.ID   , "zipCode");	//input zipCode
	public Element selectCardType 			= new Element(driver, ByValue.XPATH, "//form//following::select[@id='cardType']");  
	public Element inputCreditCardNumber 	= new Element(driver, ByValue.ID   , "creditCardNumber");	//input creditCardNumber
	public Element inputCreditCardMonth 	= new Element(driver, ByValue.ID   , "creditCardMonth");	//input creditCardMonth
	public Element inputCreditCardYear 		= new Element(driver, ByValue.ID   , "creditCardYear");	//input creditCardYear
	public Element inputNameOnCard 			= new Element(driver, ByValue.ID   , "nameOnCard");	//input nameOnCard
	public Element checkRememberMe 			= new Element(driver, ByValue.ID   , "rememberMe");	//Checkbox rememberMe
	public Element btnSubmit 				= new Element(driver, ByValue.XPATH, "//form//following::input[@type='submit']");	//button submit
	
	//Mensagem
	public Element tituloMensagem = new Element(driver, ByValue.XPATH, "//div[@class='container']//following::h1[text()='Thank you for your purchase today!']");
}
