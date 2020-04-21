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
		page.setDescricao("Movimentação de Teste");
		page.setInteressado("Interessado");
		page.setValor("500");
		page.setConta("eeee");
		page.setSituacao("status_pago");
		page.enviar();
		page.validaMovimentacao("Movimentação adicionada com sucesso!");
	}
	
	@Test
	public void validarCampos() {
		menu.acessarTelaInserirMovimentacao();
		page.enviar();
		List<String> erros = page.obterErros();
		
		Assert.assertTrue(erros.containsAll(Arrays.asList(
				"Data da Movimentação é obrigatório",
				"Data do pagamento é obrigatório",
				"Descrição é obrigatório",
				"Interessado é obrigatório",
				"Valor é obrigatório",
				"Valor deve ser um número"
				)));
	}
	
	@Test
	public void movimentacaoFutura() {
		menu.acessarTelaInserirMovimentacao();
		page.setMovimentacao("Receita");
		page.setDataMovimentacao("01/09/2020");
		page.setDataPagamento("02/09/2020");
		page.setDescricao("Movimentação de Teste");
		page.setInteressado("Interessado");
		page.setValor("500");
		page.setConta("eeee");
		page.setSituacao("status_pago");
		page.enviar();
		page.validaMovimentacao("Data da Movimentação deve ser menor ou igual à data atual");
	}
}
