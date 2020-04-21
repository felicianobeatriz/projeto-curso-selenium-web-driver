package pages;

import org.junit.Assert;
import org.openqa.selenium.By;

import core.BasePage;

public class ResumoPage extends BasePage {

	public void setMes(String mes) {
		selecionarCombo("mes", mes);
	}
	
	public void setAno(String ano) {
		selecionarCombo("ano", ano);
	}
	
	public void buscar() {
		clicarBotao(By.xpath("//input[@value=\"Buscar\"]"));
	}
	
	public void validaResumo(String expecMsg) {
		String msg = obterTexto(By.xpath("//div[@role=\"alert\"]"));
		Assert.assertEquals(msg, expecMsg);
	}
	
	public void deletaResumo() {
		clicarBotao(By.xpath("//tbody//tr//td[6]//a"));
	}
}
