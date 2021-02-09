package com.selenium2.uimaps;

import org.openqa.selenium.WebDriver;

import com.selenium2.core.Element;
import com.selenium2.enums.ByValue;

public class InicioMap {
	WebDriver driver;
	
	public InicioMap(WebDriver driver) {
		this.driver = driver;
	}

	public Element selectDeparture = new Element(driver, ByValue.XPATH, "//div[@class='container']//following::form//following::select[@name='fromPort']");
	
	public Element selectDestination = new Element(driver, ByValue.XPATH, "//div[@class='container']//following::form//following::select[@name='toPort']");
	
	public Element buttonViewDemo(String string) {
		return new Element(driver, ByValue.XPATH, "//div//following::form//following::input[@type='submit']");
	}
	
	//Mensagem
	public Element tituloCabecalhoDeparts = new Element(driver, ByValue.XPATH, "//div[@class='container']//following::th[text()='Departs: San Diego']");
	public Element tituloCabecalhoArrives = new Element(driver, ByValue.XPATH, "//div[@class='container']//following::th[text()='Arrives: New York']");
	
}
