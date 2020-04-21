package tests;


import org.junit.Assert;
import org.junit.Test;

import core.BaseTest;
import pages.ContasPage;
import pages.MenuPage;

public class ContaTeste extends BaseTest {
	MenuPage menu = new MenuPage();
	ContasPage page = new ContasPage();
	
	@Test
	public void inserirConta() {
		menu.acessarTelaInserirConta();
		page.setNome("Nova Conta");
		page.salvar("//button[@type=\"submit\"]");
		page.validarConta("Conta adicionada com sucesso!");
	}
	
	@Test
	public void alterarConta() {
		menu.acessarTelaDeListagem();
		page.clicarAlterarConta("Nova Conta");
		page.setNome("Nova Conta Atualizada");
		page.salvar("//button[@type=\"submit\"]");
		page.validarConta("Conta alterada com sucesso!");
	}
	
	@Test
	public void inserirContaComMesmoNome() {
		menu.acessarTelaInserirConta();
		page.setNome("Nova Conta Atualizada");
		page.salvar("//button[@type=\"submit\"]");
		page.validarConta("Já existe uma conta com esse nome!");
	}
	
	@Test
	public void removerContaComMovimentacao() {
		menu.acessarTelaDeListagem();
		page.clicarDeletarConta("aaaa");
		page.validarConta("Conta em uso na movimentações");
	}
	
	@Test
	public void validaSaldo() {
		Assert.assertEquals("1500.00", page.obterSaladoConta("aaaa"));
	}
}
