package suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import tests.ContaTeste;
import tests.MovimentacaoTeste;
import tests.ResumoTeste;

@RunWith(Suite.class)
public class SuiteTestes {
	ContaTeste.class,
	MovimentacaoTeste.class,
	ResumoTeste.class
	
}
