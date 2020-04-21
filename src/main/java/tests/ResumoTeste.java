package tests;

import org.junit.Test;

import core.BaseTest;
import pages.MenuPage;
import pages.ResumoPage;

public class ResumoTeste extends BaseTest {
	
	MenuPage menu = new MenuPage();
	ResumoPage page = new ResumoPage();
	
	@Test
	public void deveRemoverMovimentacao() {
		menu.verResumo();
		page.setMes("Julho");
		page.setAno("2019");
		page.buscar();
		page.deletaResumo();
		page.validaResumo("Movimentação removida com sucesso!");
		
		
	}
}
