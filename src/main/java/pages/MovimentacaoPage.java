package pages;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import core.BasePage;
import static core.DriverFactory.getDriver;

public class MovimentacaoPage extends BasePage {

	public void setMovimentacao(String string) {
		selecionarCombo("tipo" ,string);
	}
	
	public void setDataMovimentacao(String string) {
		escrever("data_transacao", string);
	}
	
	public void setDataPagamento(String string) {
		escrever("data_pagamento", string);
	}

	public void setDescricao(String string) {
		escrever("descricao", string);
	}
	
	public void setInteressado(String string) {
		escrever("interessado", string);
	}
	
	public void setValor(String string) {
		escrever("valor", string);
	}
	
	public void setConta(String string) {
		selecionarCombo("conta" ,string);
	}
	
	public void setSituacao(String string) {
		clicarRadio(string);	
	}
	
	public void enviar() {
		clicarBotao(By.xpath("//button[@type=\"submit\"]"));
	}
	
	public void validaMovimentacao(String expecMsg) {
		String msg = obterTexto(By.xpath("//div[@role=\"alert\"]"));
		Assert.assertEquals(msg, expecMsg);
	}
	
	public List<String> obterErros(){
		List<WebElement> erros = getDriver().findElements(By.xpath("//div[@class=\"alert alert-danger\"]//li"));
		List<String> retorno = new ArrayList<String>();
		
		for(WebElement erro : erros) {
			retorno.add(erro.getText());
		}
		
		return retorno;
	}
}