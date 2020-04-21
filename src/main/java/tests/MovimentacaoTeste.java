package tests;

import org.junit.Assert;
import org.junit.Test;

import core.BaseTest;
import pages.MenuPage;
import pages.MovimentacaoPage;

import java.util.Arrays;
import java.util.List;

public class MovimentacaoTeste extends BaseTest {
	MenuPage menu = new MenuPage();
	MovimentacaoPage page = new MovimentacaoPage();
	
	@Test
	public void inserirMovimentacao() {
		menu.acessarTelaInserirMovimentacao();
		page.setMovimentacao("Receita");
		page.setDataMovimentacao("01/07/2019");
		page.setDataPagamento("02/07/2019");
		page.setDescricao("Movimenta��o de Teste");
		page.setInteressado("Interessado");
		page.setValor("500");
		page.setConta("eeee");
		page.setSituacao("status_pago");
		page.enviar();
		page.validaMovimentacao("Movimenta��o adicionada com sucesso!");
	}
	
	@Test
	public void validarCampos() {
		menu.acessarTelaInserirMovimentacao();
		page.enviar();
		List<String> erros = page.obterErros();
		
		Assert.assertTrue(erros.containsAll(Arrays.asList(
				"Data da Movimenta��o � obrigat�rio",
				"Data do pagamento � obrigat�rio",
				"Descri��o � obrigat�rio",
				"Interessado � obrigat�rio",
				"Valor � obrigat�rio",
				"Valor deve ser um n�mero"
				)));
	}
	
	@Test
	public void movimentacaoFutura() {
		menu.acessarTelaInserirMovimentacao();
		page.setMovimentacao("Receita");
		page.setDataMovimentacao("01/09/2020");
		page.setDataPagamento("02/09/2020");
		page.setDescricao("Movimenta��o de Teste");
		page.setInteressado("Interessado");
		page.setValor("500");
		page.setConta("eeee");
		page.setSituacao("status_pago");
		page.enviar();
		page.validaMovimentacao("Data da Movimenta��o deve ser menor ou igual � data atual");
	}
}
