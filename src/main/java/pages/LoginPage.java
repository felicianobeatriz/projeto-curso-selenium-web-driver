package pages;

import core.BasePage;
import static core.DriverFactory.*;

import org.openqa.selenium.By;

public class LoginPage extends BasePage {

	public void acessarTelaInicial() {
		getDriver().get("https://seubarriga.wcaquino.me/login");
	}
	
	public void setEmail(String Email) {
		escrever("email", Email);
	}
	
	public void setSenha(String Senha) {
		escrever("senha", Senha);
	}
	
	public void entrar() {
		clicarBotao(By.xpath("//button[@type=\"submit\"]"));
	}
	
	public void Autenticar(String email, String senha) {
		acessarTelaInicial();
		setEmail(email);
		setSenha(senha);
		entrar();
	}
}
