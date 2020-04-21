package pages;

import org.junit.Assert;
import org.openqa.selenium.By;

import core.BasePage;


public class ContasPage extends BasePage {
	
	public void setNome(String nome) {
		escrever("nome", nome);
	}
	
	public void salvar(String botao) {
		clicarBotao(By.xpath("//button[@type=\"submit\"]"));
	}
	
	public void validarConta(String expecMsg) {
		String msg = obterTexto(By.xpath("//div[@role=\"alert\"]"));
		Assert.assertEquals(msg, expecMsg);
	}
	
	public void clicarAlterarConta(String string) {
		obterCelula("Conta", string, "Ações", "tabelaContas")
		.findElement(By.xpath(".//span[@class='glyphicon glyphicon-edit']")).click();
	}
	
	public void clicarDeletarConta(String string) {
		obterCelula("Conta", string, "Ações", "tabelaContas")
		.findElement(By.xpath(".//span[@class='glyphicon glyphicon-remove-circle']")).click();
	}
	
	public String obterSaladoConta(String conta) {
		return obterCelula("Conta", conta, "Saldo", "tabelaSaldo").getText();
	}
}
